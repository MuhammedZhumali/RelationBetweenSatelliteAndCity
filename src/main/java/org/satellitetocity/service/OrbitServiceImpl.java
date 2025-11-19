package org.satellitetocity.service;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.SatellitePositionDto;
import org.satellitetocity.dto.VisibilityDto;
import org.satellitetocity.entity.CityEntity;
import org.satellitetocity.entity.SatelliteEntity;
import org.satellitetocity.repository.CityRepository;
import org.satellitetocity.repository.SatelliteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class OrbitServiceImpl implements OrbitService {

    private final SatelliteRepository satelliteRepository;
    private final CityRepository cityRepository;

    @Override
    public SatellitePositionDto getPosition(Long satelliteId, Instant time) {

        SatelliteEntity sat = satelliteRepository.findById(satelliteId)
                .orElseThrow(() -> new RuntimeException("Satellite not found"));

        if (time == null) {
            time = Instant.now();
        }

        double[] pos = OrbitCalculator.computePosition(sat, time);

        SatellitePositionDto dto = new SatellitePositionDto();
        dto.setLatitudeDeg(pos[0]);
        dto.setLongitudeDeg(pos[1]);
        dto.setAltitudeMeters(pos[2]);
        dto.setTime(time);

        return dto;
    }

    @Override
    public VisibilityDto getVisibility(Long satelliteId, Long cityId, Instant time) {

        SatellitePositionDto satPos = getPosition(satelliteId, time);

        CityEntity city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));

        boolean visible = false;
        double elevationDeg = -10;

        return new VisibilityDto(
                satelliteId,
                cityId,
                visible,
                elevationDeg,
                satPos.getTime()
        );
    }


}
