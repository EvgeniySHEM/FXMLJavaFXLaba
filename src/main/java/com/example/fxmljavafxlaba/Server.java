package com.example.fxmljavafxlaba;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    private String login;
    private String password;

    public Server() {
        Properties properties = new Properties();
        File propertyFile = new File("property.prop");
        try {
            if (!propertyFile.exists()) propertyFile.createNewFile();
            properties.load(new FileReader(propertyFile));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        URL = properties.getProperty("db.url");
        USERNAME = properties.getProperty("db.user");
        PASSWORD = properties.getProperty("db.password");
    }

    public boolean signIn(TextField userNameField, PasswordField passwordField) {
        login = userNameField.getText();
        password = passwordField.getText();

        if (readUsers()) {
            new PersonDTOStage().init();
            return true;
        } else {
            userNameField.clear();
            passwordField.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = alert.getDialogPane();

            String style = Objects.requireNonNull(getClass().getResource("myDialogs.css")).toExternalForm();
            dialogPane.getStylesheets().add(style);
            dialogPane.getStyleClass().add("myDialog");

            alert.setTitle("login and password verification");
            alert.setHeaderText("Authentication failed!");
            alert.setContentText("Incorrect username or password! Please try again");
            alert.showAndWait();
            return false;
        }
    }

    private boolean readUsers() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT NAME, PASSWORD FROM USERS")) {
            resultSet.next();
            if (resultSet.getString(1).equals(login) && resultSet.getString(2).equals(password))
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<PersonDTO> getAllPersonDTO() {
        List<PersonDTO> personDTOList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT person.*, count(domains.id) " +
                     "FROM person LEFT JOIN domains ON person.id=domains.personid GROUP BY person.id")) {
            while (resultSet.next()) {
                personDTOList.add(new PersonDTO(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getInt(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personDTOList;
    }

    public List<Domain> getDomainByPersonId(Integer id) {
        List<Domain> domainList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM domains " +
                     "WHERE personid = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    domainList.add(new Domain(resultSet.getInt(1),
                            resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getTimestamp(5),
                            resultSet.getString(6), resultSet.getInt(7)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return domainList;
    }
}
