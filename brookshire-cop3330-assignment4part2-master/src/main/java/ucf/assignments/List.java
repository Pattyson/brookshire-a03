package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Patrick Brookshire
 */
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class List extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ToDoList.fxml"));

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

    //main function
    public static void main(String[] args) {
        launch(args);
    }

}
