package com.example.fxmljavafxlaba;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainController implements Initializable {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    private Server server;
    private Stage stage;

    @FXML
    public void handleSubmitButtonAction(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()==1) {
            connectServer();
        }
    }

    @FXML
    public void handleKeyPressedAction(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            connectServer();
        }
    }

    private void connectServer() {
        if(server.signIn(userNameField, passwordField)) {
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         server = new Server();
    }

    public void init(Stage primaryStage) {
        stage = primaryStage;
    }
}
