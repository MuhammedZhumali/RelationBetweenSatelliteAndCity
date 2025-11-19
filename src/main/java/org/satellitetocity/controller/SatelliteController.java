package org.satellitetocity.controller;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.SatellitePositionDto;
import org.satellitetocity.dto.VisibilityDto;
import org.satellitetocity.service.OrbitService;
import org.satellitetocity.service.SatelliteService;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/satellites")
@RequiredArgsConstructor
public class SatelliteController {
    private final SatelliteService satelliteService;
    private final OrbitService orbitService;

    @GetMapping("/{id}/position")
    public SatellitePositionDto getPosition(
            @PathVariable Long id,
            @RequestParam(required = false) Instant time
    ) {
        return orbitService.getPosition(id, time);
    }

    @GetMapping("/{id}/visibility/{cityId}")
    public VisibilityDto getVisibility(
            @PathVariable Long id,
            @PathVariable Long cityId,
            @RequestParam(required = false) Instant time
    ) {
        return orbitService.getVisibility(id, cityId, time);
    }
}
