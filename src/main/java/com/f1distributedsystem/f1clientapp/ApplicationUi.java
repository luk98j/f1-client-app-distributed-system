package com.f1distributedsystem.f1clientapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;

public class ApplicationUi extends Application {

    private ConfigurableApplicationContext applicationContext;
    private Parent root;
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    @Override
    public void init() throws IOException {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        applicationContext = new SpringApplicationBuilder()
                .sources(F1ClientAppApplication.class)
                .run(args);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        root = loader.load();

    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }
}
