package com.f1distributedsystem.f1clientapp.controller;

import com.f1distributedsystem.f1clientapp.business.packet.PacketDecoder;
import com.f1distributedsystem.f1clientapp.business.sender.PacketSender;
import com.f1distributedsystem.f1clientapp.business.telemetry.TelemetryMonitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;

@org.springframework.stereotype.Controller
@FxmlView("ui.fxml")
@Slf4j
public class Controller implements Initializable {
    @FXML
    private Button startButton;

    private TelemetryMonitor telemetryMonitor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startUdpServer(ActionEvent event){
        try{
            telemetryMonitor = new TelemetryMonitor(new PacketDecoder(), new PacketSender());
            telemetryMonitor.run();

            System.out.println("PacketEventMonitor running");

        }catch (Exception e ){
            log.error(e.getLocalizedMessage());
        }

    }
}
