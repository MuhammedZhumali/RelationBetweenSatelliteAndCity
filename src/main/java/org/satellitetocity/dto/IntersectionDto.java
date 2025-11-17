package org.satellitetocity.dto;

import lombok.*;

import java.time.Instant;

@Data
public class IntersectionDto {
    private CityDto city;
    private Instant firstVisibleTime;
    private double minDistanceKm;
}
