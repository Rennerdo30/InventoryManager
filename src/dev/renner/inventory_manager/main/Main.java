package dev.renner.inventory_manager.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller.stage = primaryStage;

        File file = new File(this.getClass().getResource("locale.properties").toURI());
        URL[] urls = {file.getParentFile().toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"), ResourceBundle.getBundle("locale", Locale.getDefault(), loader));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
