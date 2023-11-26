package com.example.dictionary;

import base.Dictionary;
import base.Word;
import healpers.DataBaseConnect;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DictionaryAction implements Initializable {
    private Connection connection;
    Dictionary dictionary = new Dictionary();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            importDictionaryFromDataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void importDictionaryFromDataBase() throws SQLException {
        connection = DataBaseConnect.getConnection();
        Statement statement = connection.createStatement();
        ArrayList<Word> words = new ArrayList<Word>();

        Statement e = connection.createStatement();
        ResultSet explain = e.executeQuery("select detail from tbl_edict limit 139239");
        Statement t = connection.createStatement();
        ResultSet target = t.executeQuery("select word from tbl_edict limit 139239");
        while (explain.next() && target.next()) {
            Word newWord = new Word();
            newWord.setWord_explain(explain.getString(1));
            newWord.setWord_target(target.getString(1));
            words.add(newWord);
        }
        dictionary.setWords(words);
        connection.close();
    }

    public void updateWord(String inputTarget, String newTarget, String newExplain) {

        ArrayList<Word> words = dictionary.getWords();
        for (int i = 0; i < words.size(); i++) {
            if (inputTarget.equals(words.get(i).getWord_target())) {
                words.add(new Word(newTarget, newExplain));
                words.remove(i);
                return;
            }
        }
        System.out.println("Khong có tu can sua trong tu dien.");
    }

//    public Word dictionaryLookup(String inputTarget) {
//        ArrayList<Word> words = dictionary.getWords();
//        for (int i = 0; i < words.size(); i++) {
//            if (words.get(i).getWord_target().equals(inputTarget)) {
//                return words.get(i);
//            }
//        }
//        return null;
//    }

    public ArrayList<String> dictionarySearcher(String input) {
        ArrayList<Word> words = dictionary.getWords(); // Lấy danh sách word từ từ điển
        ArrayList<String> resultList = new ArrayList<>(); // Tạo ds rỗng để chứa từ nối
        for (Word word : words) { // Vòng lặp từng từ trong danh sách từ
            if (word.getWord_target().startsWith(input)) { // Kiểm tra xem từ đó có bắt đầu bằng từ nhập vào không
                resultList.add(word.getWord_target()); //Thêm từ vào danh sách kết quả
            }
        }
        return resultList;
    }

    public String dictionaryLookup(String inputTarget) {
        ArrayList<Word> words = dictionary.getWords();
        for (int i = 0; i < words.size(); i++) {
            String target = words.get(i).getWord_target();
            if (inputTarget.equals(target)) {
                return words.get(i).getWord_explain();
            }
        }
        System.out.println("Khong co tu can tra cuu trong tu dien.");
        return null;
    }

}
