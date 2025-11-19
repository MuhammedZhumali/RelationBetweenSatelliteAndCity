package org.satellitetocity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class SatelliteEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private double altitudeMeters;

    private double inclinationDeg;
    private double raanDeg;
    private double eccentricity;
    private double argumentOfPerigeeDeg;
    private double meanAnomalyAtEpochDeg;

    private Instant epoch;
}
