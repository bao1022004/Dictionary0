package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class menuControler implements Initializable {
    @FXML
    private Button searchButton, addButton, editButton;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private AnchorPane addPane;
    @FXML
    private AnchorPane editPane;
    @FXML
    private AnchorPane searchPane;

    @FXML
    private void handleSearchButton () {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(searchPane);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void handleAddButton () {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(addPane);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    private void handleEditButton () {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(editPane);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            searchPane = FXMLLoader.load(Objects.requireNonNull(menuControler.class.getResource("search.fxml")));
            mainPane.getChildren().setAll(searchPane);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            addPane = FXMLLoader.load(Objects.requireNonNull(menuControler.class.getResource("addword.fxml")));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            editPane = FXMLLoader.load(Objects.requireNonNull(menuControler.class.getResource("edit.fxml")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
