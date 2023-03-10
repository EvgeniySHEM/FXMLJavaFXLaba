package com.example.fxmljavafxlaba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FXMLDomainsController implements Initializable {
    @FXML
    private TableView<Domain> table;
    private boolean flag = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("webName"));
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("domainName"));
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ip"));
        table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        table.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("personId"));
    }

    public void initTable(PersonDTO person) {
        ObservableList<Domain> list =
                FXCollections.observableArrayList(new Server().getDomainByPersonId(person.getId()));
        table.setItems(list);
        table.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Domain.css")).toExternalForm());
    }

    @FXML
    public void handleStyleСhanges(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()==1) {
            styleChenge();
        }
    }

    @FXML
    public void handleKeyPressedAction(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            styleChenge();
        }
    }

    private void styleChenge() {
        if(flag) {
            table.getStylesheets().clear();
            String style = Objects.requireNonNull(getClass().getResource("Domain2.css")).toExternalForm();
            table.getStylesheets().add(style);
            flag = false;
        } else {
            table.getStylesheets().clear();
            String style = Objects.requireNonNull(getClass().getResource("Domain.css")).toExternalForm();
            table.getStylesheets().add(style);
            flag = true;
        }
    }
}