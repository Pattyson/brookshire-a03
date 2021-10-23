/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Patrick Brookshire
 */

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;

public class ListController implements Initializable{

    FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    TextField descriptionTextField;
    @FXML
    ListView<Item> itemList;
    @FXML
    Button addButton;
    @FXML
    Button removeButton;
    @FXML
    Button clearButton;
    @FXML
    Button updateButton;
    @FXML
    Button exportButton;
    @FXML
    Button displayCompletedButton;
    @FXML
    Button importButton;
    @FXML
    Button markCompleteButton;
    @FXML
    Button markIncompleteButton;
    @FXML
    Button displayIncompletedButton;
    @FXML
    Button displayAllButton;
    @FXML
    DatePicker datePicker;

    ObservableList<Item> list = FXCollections.observableArrayList();

    public void refresh() {
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
        itemList.refresh();
    }

    @FXML
    public void addItem(Event e) {
        list.add(new Item(descriptionTextField.getText(), datePicker.getValue(), false));
        itemList.setItems(list);
        refresh();
    }

    @FXML
    public void removeItem(Event e) {
        int index = itemList.getSelectionModel().getSelectedIndex();
        itemList.getItems().remove(index);
        refresh();
    }

    @FXML
    public void clearAll(Event e) {
        itemList.getItems().clear();
        refresh();
    }

    public void listViewSelectedItem() {
        itemList.setOnMouseClicked(event -> {
            String selectedItem = itemList.getSelectionModel().getSelectedItem().getDescription();
            int index = itemList.getSelectionModel().getSelectedIndex();
            descriptionTextField.setText(selectedItem);
            datePicker.setValue(itemList.getItems().get(index).getDate());
        });
        refresh();
    }

    @FXML
    public void updateItem(Event e) {
        int index = itemList.getSelectionModel().getSelectedIndex();
        itemList.getItems().get(index).setDate(datePicker.getValue());
        itemList.getItems().get(index).setDescription(descriptionTextField.getText());
        refresh();
    }

    @FXML
    public void exportList(javafx.scene.input.MouseEvent mouseEvent) {
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV (Comma delimited)", "*.csv"));
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null) {
            try {
                PrintWriter pw = new PrintWriter(file);
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i).getDate());
                    sb.append(",");
                    sb.append(list.get(i).getDescription());
                    sb.append(",");
                    sb.append(list.get(i).getCompletedBoolean(list.get(i).getComplete()));
                    sb.append("\r\n");
                }
                pw.write(sb.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void importList(javafx.scene.input.MouseEvent mouseEvent) {
        String line = "";
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV (Comma delimited)", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        itemList.getItems().clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null) {
                Boolean fromCSV;
                String[] values = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(values[0], formatter);
                if(values[2].equals("incomplete")) {
                    fromCSV = false;
                } else {
                    fromCSV = true;
                }
                list.add(new Item(values[1], date, fromCSV));
                itemList.setItems(list);
                refresh();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @FXML
    public void markComplete(Event e) {
        int index = itemList.getSelectionModel().getSelectedIndex();

        list.get(index).setComplete(true);
        refresh();
    }

    @FXML
    public void markIncomplete(Event e) {
        int index = itemList.getSelectionModel().getSelectedIndex();
        list.get(index).setComplete(false);
        refresh();
    }

    @FXML
    public void displayComplete(Event e) {
        ObservableList<Item> complete = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getComplete().equals(true)) {
                complete.add(list.get(i));
            }
        }
        itemList.setItems(complete);
        refresh();
    }

    @FXML
    public void displayIncomplete(Event e) {
        ObservableList<Item> incomplete = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getComplete().equals(false)) {
                incomplete.add(list.get(i));
            }
        }
        itemList.setItems(incomplete);
        refresh();
    }

    @FXML
    public void displayAll(Event e) {
        itemList.setItems(list);
        refresh();
    }

}
