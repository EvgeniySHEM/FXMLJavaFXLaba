package com.example.fxmljavafxlaba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPersonDTOController implements Initializable {

    @FXML
    private TableView<PersonDTO> table;
    @FXML
    private TableColumn<PersonDTO, Integer> idPerson;
    @FXML
    private TableColumn<PersonDTO, Integer> personJob;
    @FXML
    private TableColumn<PersonDTO, Integer> personName;
    @FXML
    private TableColumn<PersonDTO, Integer> personPhone;
    @FXML
    private TableColumn<PersonDTO, Integer> personEmail;
    @FXML
    private TableColumn<PersonDTO, Integer> countDomains;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PersonDTO> list = FXCollections.observableArrayList(new Server().getAllPersonDTO());
        idPerson.setCellValueFactory(new PropertyValueFactory<>("id"));
        personJob.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        personName.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        personPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        countDomains.setCellValueFactory(new PropertyValueFactory<>("countDomains"));
        table.setItems(list);
    }

    @FXML
    public void handleClickedAction(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()==2) {
            openDomainsStage();
        }
    }

    @FXML
    public void handleKeyPressedAction(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            openDomainsStage();
        }
    }

    private void openDomainsStage() {
        PersonDTO person = table.getSelectionModel().getSelectedItem();
        new DomainsStage().init(person);
    }
}