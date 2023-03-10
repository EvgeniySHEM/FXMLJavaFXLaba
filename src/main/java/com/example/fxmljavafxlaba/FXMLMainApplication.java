package com.example.fxmljavafxlaba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FXMLMainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLMain.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setScene(scene);
        ((FXMLMainController)fxmlLoader.getController()).init(primaryStage);
        primaryStage.show();
    }
}
