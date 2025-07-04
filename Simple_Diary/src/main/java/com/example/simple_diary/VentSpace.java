package com.example.simple_diary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VentSpace extends Application {
    @Override
    public void start(Stage stage) {
        //welcome message
        Label dateLabel = new Label("Welcome to Your Vent Space");

        //first control with event: button to list current date
        Button dateBtn = new Button("Today's Date:");
        //second control with event: text editor for user to write text
        TextArea textSpace = new TextArea("Vent here...");
        //third control: store entry in list
        ListView<String> ventBox = new ListView<>();

        //event handler for button to display time
        dateBtn.setOnAction(e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            dateLabel.setText(now.format(formatter));
        });

        //fourth control: event handler to store each vent (third item) and alert user it's been saved
        textSpace.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case ENTER:
                    String text = textSpace.getText().trim();
                    if (!text.isEmpty()) {
                        ventBox.getItems().add(text);
                        textSpace.clear();

                        //fourth control: alert
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Have a great day!");
                        alert.setHeaderText(null);
                        alert.setContentText("Your entry has been saved.");
                        alert.showAndWait();
                    }
                    keyEvent.consume(); //this prevents new line on Enter
                    break;
            }
        });

        //VBox layout of all items
        VBox layout = new VBox(10);
        layout.getChildren().addAll(dateLabel, dateBtn, textSpace);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        //create stage and set params for window
        Scene scene = new Scene(layout, 540, 440);
        stage.setTitle("Vent Space");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}