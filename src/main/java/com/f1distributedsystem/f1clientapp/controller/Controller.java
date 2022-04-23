package com.f1distributedsystem.f1clientapp.controller;

import com.f1distributedsystem.f1clientapp.business.telemetry.TelemetryMonitor;
import io.netty.channel.Channel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("ui.fxml")
@Slf4j
public class Controller implements Initializable {
    @FXML
    private Button startButton;


    private TelemetryMonitor telemetryMonitor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        telemetryMonitor = new TelemetryMonitor();
    }

    public void startUdpServer(ActionEvent event){
        try{
            telemetryMonitor.run();
            Channel channel = telemetryMonitor.bind();
            System.out.println("PacketEventMonitor running");
            channel.closeFuture().sync();
        }catch (Exception e ){
            log.error(e.getLocalizedMessage());
        } finally {
            telemetryMonitor.stop();
        }

    }
}
