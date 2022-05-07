/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.f1distributedsystem.f1clientapp.business.packet.data;

import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.SessionType;
import com.f1distributedsystem.f1clientapp.business.packet.enumsPacket.Weather;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherForecastSample {

    public static final int SIZE = 8;

    private SessionType sessionType;
    private short timeOffset;
    private Weather weather;
    private short trackTemperature;
    private short trackTemperatureChange;
    private short airTemperature;
    private short airTemperatureChange;
    private short rainPercentage;

    public WeatherForecastSample fill(ByteBuf buffer) {
        this.sessionType = SessionType.valueOf(buffer.readUnsignedByte());
        this.timeOffset = buffer.readUnsignedByte();
        this.weather = Weather.valueOf(buffer.readUnsignedByte());
        this.trackTemperature = buffer.readByte();
        this.trackTemperatureChange = buffer.readByte();
        this.airTemperature = buffer.readByte();
        this.airTemperatureChange = buffer.readByte();
        this.rainPercentage = buffer.readUnsignedByte();
        return this;
    }

    @Override
    public String toString() {
        return "WeatherForecastSample[sessionType=" + this.sessionType +
                ",timeOffset=" + this.timeOffset +
                ",weather=" + this.weather +
                ",trackTemperature=" + this.trackTemperature +
                ",airTemperature=" + this.airTemperature +
                "]";
    }
}
