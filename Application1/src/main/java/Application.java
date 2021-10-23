/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Patrick Brookshire
 */

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

            //Scene Loader
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ToDoList");
            primaryStage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //main function - startup
    public static void main(String[] args) {
        launch(args);
    }


}
