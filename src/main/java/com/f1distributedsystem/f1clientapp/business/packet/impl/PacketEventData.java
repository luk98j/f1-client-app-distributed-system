package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketHeader;
import com.f1distributedsystem.f1clientapp.business.packet.data.*;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.EventCode;
import com.f1distributedsystem.f1clientapp.utilities.Utils;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacketEventData extends Packet {
    public static final int SIZE = PacketHeader.SIZE +
            4 +
            EventDataDetails.SIZE;

    private EventCode eventCode;
    private EventDataDetails eventDataDetails = new EventDataDetails();


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Event[");
        sb.append(super.toString());
        sb.append(",eventStringCode=" +  this.eventCode);
        sb.append(",eventDataDetails=" + this.eventDataDetails);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.eventCode = EventCode.valueFrom(Utils.readString(buffer, 4));
        switch (this.eventCode) {
            case SESSION_STARTED:
                break;
            case SESSION_ENDED:
                break;
            case FASTEST_LAP:
                FastestLap fl = new FastestLap();
                this.eventDataDetails.setFastestLap(fl.fill(buffer));
                break;
            case RETIREMENT:
                Retirement r = new Retirement();
                this.eventDataDetails.setRetirement(r.fill(buffer));
                break;
            case DRS_ENABLED:
                break;
            case DRS_DISABLED:
                break;
            case TEAM_MATE_IN_PITS:
                TeamMateInPits tmip = new TeamMateInPits();
                this.eventDataDetails.setTeamMateInPits(tmip.fill(buffer));
                break;
            case CHEQUERED_FLAG:
                break;
            case RACE_WINNER:
                RaceWinner rw = new RaceWinner();
                this.eventDataDetails.setRaceWinner(rw.fill(buffer));
                break;
            case PENALTY_ISSUED:
                Penalty p = new Penalty();
                this.eventDataDetails.setPenalty(p.fill(buffer));
                break;
            case SPEED_TRAP_TRIGGERED:
                SpeedTrap st = new SpeedTrap();
                this.eventDataDetails.setSpeedTrap(st.fill(buffer));
                break;
            case START_LIGHTS:
                StartLights startLights = new StartLights();
                this.eventDataDetails.setStartLights(startLights.fill(buffer));
                break;
            case LIGHTS_OUT:
                break;
            case DRIVE_THROUGH_SERVED:
                DriveThroughPenaltyServed driveThroughPenaltyServed = new DriveThroughPenaltyServed();
                this.eventDataDetails.setDriveThroughPenaltyServed(driveThroughPenaltyServed.fill(buffer));
                break;
            case STOP_GO_SERVED:
                StopGoPenaltyServed stopGoPenaltyServed = new StopGoPenaltyServed();
                this.eventDataDetails.setStopGoPenaltyServed(stopGoPenaltyServed.fill(buffer));
                break;
            case FLASHBACK:
                Flashback flashback = new Flashback();
                this.eventDataDetails.setFlashback(flashback.fill(buffer));
                break;
            case BUTTON_STATUS:
                Buttons buttons = new Buttons();
                this.eventDataDetails.setButtons(buttons.fill(buffer));
                break;
            default:
                throw new IllegalArgumentException("EventCode=" + this.eventCode + " not supported");
        }
        return this;
    }
}
