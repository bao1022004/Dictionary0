package com.example.dictionary;

import base.DictionaryCommandline;
import base.Word;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        launch();
    }
}