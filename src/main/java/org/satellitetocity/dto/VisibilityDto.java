package org.satellitetocity.dto;

import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
public class VisibilityDto {
    private Long satelliteId;
    private Long cityId;
    private boolean visible;
    private double elevationDeg;
    private Instant time;
}

