package org.satellitetocity.service;

import org.satellitetocity.dto.SatellitePositionDto;
import org.satellitetocity.dto.VisibilityDto;

import java.time.Instant;

public interface OrbitService {
    SatellitePositionDto getPosition(Long satelliteId, Instant time);

    VisibilityDto getVisibility(Long satelliteId, Long cityId, Instant time);
}
