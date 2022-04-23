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

    /**
     * Fill the current WeatherForecastSample with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled WeatherForecastSample instance
     */
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

    /**
     * Fill the buffer with the raw bytes representation of the current WeatherForecastSample instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.sessionType.getValue());
        buffer.writeByte(this.timeOffset);
        buffer.writeByte(this.weather.getValue());
        buffer.writeByte(this.trackTemperature);
        buffer.writeByte(this.trackTemperatureChange);
        buffer.writeByte(this.airTemperature);
        buffer.writeByte(this.airTemperatureChange);
        buffer.writeByte(this.rainPercentage);
        return buffer;
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
