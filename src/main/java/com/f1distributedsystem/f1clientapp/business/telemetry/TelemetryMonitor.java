package com.f1distributedsystem.f1clientapp.business.telemetry;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketDecoder;
import com.f1distributedsystem.f1clientapp.business.sender.PacketSender;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

@Slf4j
public class TelemetryMonitor extends Thread{
    private PacketDecoder controller;
    private static int MAX_BUFFER = 2048;
    private boolean is_running;
    private PacketSender packetSender;
    private String uniqueId;
    private int port;

    public TelemetryMonitor(PacketDecoder controller, PacketSender packetSender, String uniqueId, int port) {
        this.controller = controller;
        this.packetSender = packetSender;
        this.uniqueId = uniqueId;
        this.port = port;
        this.is_running = true;
    }

    public void run() {
        System.out.println("SERVER RUNNING");
        try {
            while(is_running) {
                DatagramSocket socket = new DatagramSocket(port);
                byte[] buffer = new byte[MAX_BUFFER];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                ByteBuf byteBuf = Unpooled.wrappedBuffer(buffer);
                if (controller.checkPacket(byteBuf)) {
                    Packet packet1 = controller.decode(byteBuf);
                    try {
                        packetSender.splitPackages(packet1, uniqueId);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(packet1.toString());
                }
                socket.close();

               // packet.setLength(buffer.length);
            }

        } catch (IOException ex) {
            log.error(ex.getMessage());
            System.out.println("Check port: '" + port + "' or packet.");
        }
    }

    public void stopServer(){
        is_running = false;
    }
}
