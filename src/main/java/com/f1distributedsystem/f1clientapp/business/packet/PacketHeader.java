package com.f1distributedsystem.f1clientapp.business.packet;

import com.f1distributedsystem.f1clientapp.utilities.Utils;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PacketId;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * struct PacketHeader
 * {
 *     uint16    m_packetFormat;            // 2021
 *     uint8     m_gameMajorVersion;        // Game major version - "X.00"
 *     uint8     m_gameMinorVersion;        // Game minor version - "1.XX"
 *     uint8     m_packetVersion;           // Version of this packet type, all start from 1
 *     uint8     m_packetId;                // Identifier for the packet type, see below
 *     uint64    m_sessionUID;              // Unique identifier for the session
 *     float     m_sessionTime;             // Session timestamp
 *     uint32    m_frameIdentifier;         // Identifier for the frame the data was retrieved on
 *     uint8     m_playerCarIndex;          // Index of player's car in the array
 *     uint8     m_secondaryPlayerCarIndex; // Index of secondary player's car in the array (splitscreen)
 *                                          // 255 if no second player
 * };
 */
@Getter
@Setter
public class PacketHeader {
    public static final int SIZE = 24;
    // offset in the raw bytes where the packetId is
    public static final int PACKET_ID_OFFSET = 5;
    private ByteBuffer byteBuffer;
    private int packetFormat;
    private short gameMajorVersion;
    private short gameMinorVersion;
    private short packetVersion;
    private PacketId packetId;
    private BigInteger sessionUid;
    private float sessionTime;
    private long frameIdentifier;
    private short playerCarIndex;
    private short secondaryPlayerCarIndex;

    public PacketHeader fill(ByteBuf buffer) {
        this.packetFormat = buffer.readUnsignedShortLE();
        this.gameMajorVersion = buffer.readUnsignedByte();
        this.gameMinorVersion = buffer.readUnsignedByte();
        this.packetVersion = buffer.readUnsignedByte();
        this.packetId = PacketId.valueOf(buffer.readUnsignedByte());
        this.sessionUid = Utils.toUnsignedBigInteger(buffer.readLongLE());
        this.sessionTime = buffer.readFloatLE();
        this.frameIdentifier = buffer.readUnsignedIntLE();
        this.playerCarIndex = buffer.readUnsignedByte();
        this.secondaryPlayerCarIndex = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "Header[format=" + this.packetFormat +
                ",major=" + this.gameMajorVersion +
                ",minor=" + this.gameMinorVersion +
                ",version=" + this.packetVersion +
                ",id=" + this.packetId +
                ",sessionUid=" + this.sessionUid +
                ",sessionTime=" + this.sessionTime +
                ",frameIdentifier=" + this.frameIdentifier +
                ",playerCarIndex=" + this.playerCarIndex +
                ",secondaryPlayerCarIndex=" + this.secondaryPlayerCarIndex +
                "]";
    }
}
