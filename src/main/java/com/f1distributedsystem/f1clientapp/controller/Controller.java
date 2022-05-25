package com.f1distributedsystem.f1clientapp.controller;

import com.f1distributedsystem.f1clientapp.business.packet.PacketDecoder;
import com.f1distributedsystem.f1clientapp.business.sender.PacketSender;
import com.f1distributedsystem.f1clientapp.business.telemetry.TelemetryMonitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

@org.springframework.stereotype.Controller
@FxmlView("ui.fxml")
@Slf4j
public class Controller implements Initializable {
    @FXML
    private Button startButton;
    @FXML
    private Label errorField;
    @FXML
    private TextField portText;
    @FXML
    private TextField userKey;

    private TelemetryMonitor telemetryMonitor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startUdpServer(ActionEvent event){
        if(portText.getText() != null && portText.getText().length() > 2 && portText.getText().matches("[0-9]+")){
            errorField.setText("");
            String uniqueID = UUID.randomUUID().toString();
            userKey.setText(uniqueID);
            try{
                telemetryMonitor = new TelemetryMonitor(new PacketDecoder(), new PacketSender(), uniqueID, Integer.parseInt(portText.getText()));
                telemetryMonitor.run();
                System.out.println("PacketEventMonitor running");
            }catch (Exception e ){
                errorField.setText("Something went wrong with client");
                log.error(e.getLocalizedMessage());
            }
        } else {
            errorField.setText("Something went wrong with port number");
        }
    }
}
