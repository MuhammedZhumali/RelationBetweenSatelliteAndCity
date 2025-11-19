package org.satellitetocity.dto;

import lombok.*;

import java.time.Instant;

@Data
public class SatelliteDto {
    private double altitudeMeters;
    private double inclinationDeg;
    private double latitudeDeg;
    private double longitudeDeg;
    private Instant time;
    private double x;
    private double y;
}

