package com.example.simple_diary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label timeStamp;
    private Label textEditor;

    @FXML
    protected void onHelloButtonClick() {
        timeStamp.setText("Welcome to JavaFX Application!");
    }

}