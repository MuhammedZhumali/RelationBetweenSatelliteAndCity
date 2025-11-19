package org.satellitetocity.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class SatellitePositionDto {
    private double latitudeDeg;
    private double longitudeDeg;
    private double altitudeMeters;
    private Instant time;
}
