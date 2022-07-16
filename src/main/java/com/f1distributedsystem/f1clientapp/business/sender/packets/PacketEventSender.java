package com.f1distributedsystem.f1clientapp.business.sender.packets;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.PenaltyType;
import com.f1distributedsystem.f1clientapp.business.packet.impl.PacketEventData;
import com.f1distributedsystem.f1clientapp.dto.impl.*;
import com.f1distributedsystem.f1clientapp.service.PostSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PacketEventSender implements PacketSenderInterface {
    private PostSender postSender = new PostSender();
    private final static String URL = "event";
    @Override
    public void sendPacket(Packet packet, String uniqueId){
        PacketEventData packetEventData = (PacketEventData) packet;
        BigInteger sessionid = packetEventData.getHeader().getSessionUid();
        switch (packetEventData.getEventCode()){
            case SESSION_STARTED:
                postSender.sendPost(URL+"/main-event",new EventDto(sessionid, "session_started"), uniqueId);
                break;
            case SESSION_ENDED:
                postSender.sendPost(URL+"/main-event",new EventDto(sessionid, "session_end"), uniqueId);
                break;
            case FASTEST_LAP:
                postSender.sendPost(URL+"/fastest-lap",new FastestLapDto(sessionid, packetEventData.getEventDataDetails().getFastestLap().getVehicleIdx(),
                        String.valueOf(packetEventData.getEventDataDetails().getFastestLap().getLapTime())), uniqueId);
                break;
            case RETIREMENT:
                postSender.sendPost(URL+"/retirement",new CarEventDto(sessionid, packetEventData.getEventDataDetails().getRetirement().getVehicleIdx()),
                        uniqueId);
                break;
            case DRS_ENABLED:
                postSender.sendPost(URL+"/drs",new DrsDto(sessionid, true), uniqueId);
                break;
            case DRS_DISABLED:
                postSender.sendPost(URL+"/drs",new DrsDto(sessionid, false), uniqueId);
                break;
            case TEAM_MATE_IN_PITS:
                postSender.sendPost(URL+"/team-pits",new CarEventDto(sessionid, packetEventData.getEventDataDetails().getTeamMateInPits().getVehicleIdx()),
                        uniqueId);
                break;
            case RACE_WINNER:
                postSender.sendPost(URL+"/race-winner",new CarEventDto(sessionid, packetEventData.getEventDataDetails().getRetirement().getVehicleIdx()),uniqueId);
                break;
            case PENALTY_ISSUED:
                packetEventData.getEventDataDetails().getPenalty();
                postSender.sendPost(URL+"/penalty",new PenaltyDto(sessionid,
                        packetEventData.getEventDataDetails().getPenalty().getVehicleIdx(),
                        PenaltyType.valueOf(packetEventData.getEventDataDetails().getPenalty().getPenaltyType().getValue()).toString(),
                        String.valueOf(packetEventData.getEventDataDetails().getPenalty().getTime())),uniqueId);
                break;
            case CHEQUERED_FLAG:
            case START_LIGHTS:
            case SPEED_TRAP_TRIGGERED:
            case LIGHTS_OUT:
            case FLASHBACK:
            case BUTTON_STATUS:
            case STOP_GO_SERVED:
            case DRIVE_THROUGH_SERVED:
                break;

        }
    }
}
