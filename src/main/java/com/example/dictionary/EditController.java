package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController extends DictionaryAction {

    @FXML
    private Button addViewButton;

    @FXML
    private Button searchViewButton;

    @FXML
    private Button editViewButton;
    private Parent root;
    private Stage stage;
    private Scene scene;


    public void switchToSearchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("searchScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

