package com.example.fxmljavafxlaba;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DomainsStage extends Stage {
    public void init(PersonDTO person) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDomains.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("Domains table");
        setScene(scene);
        ((FXMLDomainsController)fxmlLoader.getController()).initTable(person);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }
}
