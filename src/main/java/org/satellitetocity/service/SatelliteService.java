package org.satellitetocity.service;

import org.satellitetocity.dto.SatelliteDto;

import java.util.List;

public interface SatelliteService {
    List<SatelliteDto> getAllSatellites();
    SatelliteDto getSatelliteById(Long id);
    SatelliteDto createSatellite(SatelliteDto dto);
}
