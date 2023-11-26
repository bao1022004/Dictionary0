package com.example.dictionary;

import base.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController extends DictionaryAction {

    @FXML
    private WebView explain;

    @FXML
    private Button searchButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button removeButton;

    @FXML
    private Button addViewButton;

    @FXML
    private Button searchViewButton;

    @FXML
    private Button editViewButton;
    @FXML
    private Label spelling;

    @FXML
    private ListView<String> listWord = new ListView<String>();
    private Parent root;
    private Stage stage;
    private Scene scene;
    private WebEngine viewWordWebEngine;

    public void switchToAddScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEditScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void handleSearch() {
        String input = searchBar.getText();
        if (!input.isEmpty()) {
            listWord.getItems().clear();
            ArrayList<String> targets = dictionarySearcher(input);
            listWord.getItems().addAll(targets);
        }
        else {
            listWord.getItems().clear();
        }
    }
    @FXML
    void handleSelectWord() {
        String selectedWord = listWord.getSelectionModel().getSelectedItem();
        System.out.println(selectedWord);
        viewWordWebEngine = explain.getEngine();
        String explain = dictionaryLookup(selectedWord);
        spelling.setText(selectedWord);
        viewWordWebEngine.loadContent(explain, "text/html");
    }
}


