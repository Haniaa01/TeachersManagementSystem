package com.example.teachersms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URISyntaxException;

public class HelloApplication extends Application {
    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 640, 640);

        root.setOnMousePressed((MouseEvent e) -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });

        //root.setOnMouseDragged((MouseEvent e) ->{
        //stage.setX(e.getScreenX() - x);
        // stage.setY(e.getScreenX() - y);

        // stage.setOpacity(.8);
        // });

        root.setOnMouseReleased((MouseEvent e) -> {
            stage.setOpacity(1);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
