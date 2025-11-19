package org.satellitetocity.entity;

import org.satellitetocity.dto.CityDto;
import org.satellitetocity.dto.SatelliteDto;
import org.springframework.stereotype.Component;

@Component
public class SatelliteMapper {
    public SatelliteDto toDto(SatelliteEntity entity) {
        SatelliteDto dto = new SatelliteDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setInclinationDeg(entity.getInclinationDeg());
        dto.setArgumentOfPerigeeDeg(entity.getArgumentOfPerigeeDeg());
        dto.setEpoch(entity.getEpoch());
        dto.setEccentricity(entity.getEccentricity());
        dto.setMeanAnomalyAtEpochDeg(entity.getMeanAnomalyAtEpochDeg());
        dto.setRaanDeg(entity.getRaanDeg());
        dto.setAltitudeMeters(entity.getAltitudeMeters());
        return dto;
    }

    public SatelliteEntity toEntity(SatelliteDto dto) {
        SatelliteEntity entity = new SatelliteEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setInclinationDeg(dto.getInclinationDeg());
        entity.setArgumentOfPerigeeDeg(dto.getArgumentOfPerigeeDeg());
        entity.setEpoch(dto.getEpoch());
        entity.setEccentricity(dto.getEccentricity());
        entity.setRaanDeg(dto.getRaanDeg());
        entity.setAltitudeMeters(dto.getAltitudeMeters());
        return entity;
    }
}
