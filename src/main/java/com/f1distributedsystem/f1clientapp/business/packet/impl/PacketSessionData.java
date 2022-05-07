package com.f1distributedsystem.f1clientapp.business.packet.impl;

import com.f1distributedsystem.f1clientapp.business.packet.Packet;
import com.f1distributedsystem.f1clientapp.business.packet.PacketHeader;
import com.f1distributedsystem.f1clientapp.business.packet.data.WeatherForecastSample;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.*;
import com.f1distributedsystem.f1clientapp.business.packet.data.MarshalZone;
import com.f1distributedsystem.f1clientapp.utilities.Const;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PacketSessionData extends Packet {
    public static final int SIZE = PacketHeader.SIZE +
            19 // numbers of fields
            + MarshalZone.SIZE * Const.MARSHAL_ZONES +
            3 + WeatherForecastSample.SIZE * Const.WEATHER_FORECAST_SAMPLES
            +26 ;

    private Weather weather;
    private short trackTemperature;
    private short airTemperature;
    private short totalLaps;
    private int trackLength;
    private SessionType sessionType;
    private Track trackId;
    private Formula formula;
    private int sessionTimeLeft;
    private int sessionDuration;
    private short pitSpeedLimit;
    private short gamePaused;
    private short isSpectating;
    private short spectatorCarIndex;
    private short sliProNativeSupport;
    private short numMarshalZones;
    private List<MarshalZone> marshalZones = new ArrayList<>(Const.MARSHAL_ZONES);
    private SafetyCarStatus safetyCarStatus;
    private short networkGame;
    private short numWeatherForecastSamples;
    private List<WeatherForecastSample> weatherForecastSamples = new ArrayList<>(Const.WEATHER_FORECAST_SAMPLES);
    private short forecastAccuracy;
    private short aiDifficulty;
    private float seasonLinkIdentifier;
    private float weekendLinkIdentifier;
    private float sessionLinkIdentifier;
    private short pitStopWindowIdealLap;
    private short pitStopWindowLatestLap;
    private short pitStopRejoinPosition;
    private short steeringAssist;
    private short brakingAssist;
    private short gearboxAssist;
    private short pitAssist;
    private short pitReleaseAssist;
    private short ERSAssist;
    private short DRSAssist;
    private short dynamicRacingLine;
    private short dynamicRacingLineType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Session[");
        sb.append(super.toString());
        sb.append(",weather=" + this.weather);
        sb.append(",trackTemperature=" + this.trackTemperature);
        sb.append(",airTemperature=" + this.airTemperature);
        sb.append(",totalLaps=" + this.totalLaps);
        sb.append(",trackLength=" + this.trackLength);
        sb.append(",sessionType=" + this.sessionType);
        sb.append(",trackId=" + this.trackId);
        sb.append(",formula=" + this.formula);
        sb.append(",sessionTimeLeft=" + this.sessionTimeLeft);
        sb.append(",sessionDuration=" + this.sessionDuration);
        sb.append(",pitSpeedLimit=" + this.pitSpeedLimit);
        sb.append(",gamePaused=" + this.gamePaused);
        sb.append(",isSpectating=" + this.isSpectating);
        sb.append(",spectatorCarIndex" + this.spectatorCarIndex);
        sb.append(",sliProNativeSupport=" + this.sliProNativeSupport);
        sb.append(",numMarshalZones=" + this.numMarshalZones);
        sb.append(",marshalZones=");
        for (MarshalZone mz: marshalZones) {
            sb.append(mz.toString() + ",");
        }
        sb.append("safetyCarStatus=" + this.safetyCarStatus);
        sb.append(",networkGame=" + this.networkGame);
        sb.append(",numWeatherForecastSamples=" + this.numWeatherForecastSamples);
        sb.append(",weatherForecastSamples=");
        for (WeatherForecastSample wfs : weatherForecastSamples) {
            sb.append(wfs.toString() + ",");
        }
        sb.append(", forecastAccuracy=" + this.forecastAccuracy);
        sb.append(", aiDifficulty=" + this.aiDifficulty);
        sb.append(", seasonLinkIdentifier=" + this.seasonLinkIdentifier);
        sb.append(", weekendLinkIdentifier=" + this.weekendLinkIdentifier);
        sb.append(", sessionLinkIdentifier=" + this.sessionLinkIdentifier);
        sb.append(", pitStopWindowIdealLap=" + this.pitStopWindowIdealLap);
        sb.append(", pitStopWindowLatestLap=" + this.pitStopWindowLatestLap);
        sb.append(", pitStopRejoinPosition=" + this.pitStopRejoinPosition);
        sb.append(", steeringAssist=" + this.steeringAssist);
        sb.append(", brakingAssist=" + this.brakingAssist);
        sb.append(", gearboxAssist=" + this.gearboxAssist);
        sb.append(", pitAssist=" + this.pitAssist);
        sb.append(", pitReleaseAssist=" + this.pitReleaseAssist);
        sb.append(", ERSAssist=" + this.ERSAssist);
        sb.append(", DRSAssist=" + this.DRSAssist);
        sb.append(", dynamicRacingLine=" + this.dynamicRacingLine);
        sb.append(", dynamicRacingLineType=" + this.dynamicRacingLineType);
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.weather = Weather.valueOf(buffer.readUnsignedByte());
        this.trackTemperature = buffer.readByte();
        this.airTemperature = buffer.readByte();
        this.totalLaps = buffer.readUnsignedByte();
        this.trackLength = buffer.readUnsignedShortLE();
        this.sessionType = SessionType.valueOf(buffer.readUnsignedByte());
        this.trackId = Track.valueOf(buffer.readByte());
        this.formula = Formula.valueOf(buffer.readUnsignedByte());
        this.sessionTimeLeft = buffer.readUnsignedShortLE();
        this.sessionDuration = buffer.readUnsignedShortLE();
        this.pitSpeedLimit = buffer.readUnsignedByte();
        this.gamePaused = buffer.readUnsignedByte();
        this.isSpectating = buffer.readUnsignedByte();
        this.spectatorCarIndex = buffer.readUnsignedByte();
        this.sliProNativeSupport = buffer.readUnsignedByte();
        this.numMarshalZones = buffer.readUnsignedByte();
        for (int i = 0; i < Const.MARSHAL_ZONES; i++) {
            MarshalZone mz = new MarshalZone();
            this.marshalZones.add(mz.fill(buffer));
        }
        this.safetyCarStatus = SafetyCarStatus.valueOf(buffer.readUnsignedByte());
        this.networkGame = buffer.readUnsignedByte();
        this.numWeatherForecastSamples = buffer.readUnsignedByte();
        for (int i = 0; i < Const.WEATHER_FORECAST_SAMPLES; i++) {
            WeatherForecastSample wfs = new WeatherForecastSample();
            this.weatherForecastSamples.add(wfs.fill(buffer));
        }
        this.forecastAccuracy = buffer.readUnsignedByte();
        this.aiDifficulty = buffer.readUnsignedByte();
        this.seasonLinkIdentifier = buffer.readFloatLE();
        this.weekendLinkIdentifier = buffer.readFloatLE();
        this.sessionLinkIdentifier = buffer.readFloatLE();
        this.pitStopWindowIdealLap = buffer.readUnsignedByte();
        this.pitStopWindowLatestLap = buffer.readUnsignedByte();
        this.pitStopRejoinPosition = buffer.readUnsignedByte();
        this.steeringAssist = buffer.readUnsignedByte();
        this.brakingAssist = buffer.readUnsignedByte();
        this.gearboxAssist = buffer.readUnsignedByte();
        this.pitAssist = buffer.readUnsignedByte();
        this.pitReleaseAssist = buffer.readUnsignedByte();
        this.ERSAssist = buffer.readUnsignedByte();
        this.DRSAssist = buffer.readUnsignedByte();
        this.dynamicRacingLine = buffer.readUnsignedByte();
        this.dynamicRacingLineType = buffer.readUnsignedByte();
        return this;
    }
}
