package org.satellitetocity.entity;

import org.satellitetocity.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityDto toDto(CityEntity entity) {
        CityDto dto = new CityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLatitudeDeg(entity.getLatitudeDeg());
        dto.setLongitudeDeg(entity.getLongitudeDeg());
        dto.setAltitudeMeters(entity.getAltitudeMeters());
        return dto;
    }

    public CityEntity toEntity(CityDto dto) {
        CityEntity entity = new CityEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLatitudeDeg(dto.getLatitudeDeg());
        entity.setLongitudeDeg(dto.getLongitudeDeg());
        entity.setAltitudeMeters(dto.getAltitudeMeters());
        return entity;
    }
}
