package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;

import java.io.IOException;

public interface PacketSenderInterface {
    void sendPacket(Packet packet) throws IOException, InterruptedException;
}
