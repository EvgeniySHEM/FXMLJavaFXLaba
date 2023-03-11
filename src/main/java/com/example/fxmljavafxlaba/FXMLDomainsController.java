package com.example.fxmljavafxlaba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FXMLDomainsController implements Initializable {
    @FXML
    private TableView<Domain> table;
    private final String STYLE1;
    private final String STYLE2;

    {
        STYLE1 = Objects.requireNonNull(getClass().getResource("Domain.css"),
                "Domain.css must not be null").toExternalForm();
        STYLE2 = Objects.requireNonNull(getClass().getResource("Domain2.css"),
                "Domain2.css must not be null").toExternalForm();
    }

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
        table.getStylesheets().add(STYLE1);
    }

    @FXML
    public void handleStyleСhanges(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()==1) {
            styleChange();
        }
    }

    @FXML
    public void handleKeyPressedAction(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            styleChange();
        }
    }

    private void styleChange() {
        String style = table.getStylesheets().contains(STYLE1) ? STYLE2 : STYLE1;
        table.getStylesheets().clear();
        table.getStylesheets().add(style);
    }
}