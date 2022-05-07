package com.f1distributedsystem.f1clientapp.business.packet.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDataDetails {
    public static final int SIZE = 7;

    private FastestLap fastestLap;
    private Retirement retirement;
    private TeamMateInPits teamMateInPits;
    private RaceWinner raceWinner;
    private Penalty penalty;
    private SpeedTrap speedTrap;
    private StartLights startLights;
    private DriveThroughPenaltyServed driveThroughPenaltyServed;
    private StopGoPenaltyServed stopGoPenaltyServed;
    private Flashback flashback;
    private Buttons buttons;

    @Override
    public String toString() {
        return "EventDataDetails[fastestLap=" + this.fastestLap +
                ",retirement=" + this.retirement +
                ",teamMateInPits=" + this.teamMateInPits +
                ",raceWinner=" + this.raceWinner +
                ",penalty=" + this.penalty +
                ",speedTrap=" + this.speedTrap +
                "]";
    }
}
