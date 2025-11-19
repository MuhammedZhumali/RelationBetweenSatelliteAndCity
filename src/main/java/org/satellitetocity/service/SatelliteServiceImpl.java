package org.satellitetocity.service;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.SatelliteDto;
import org.satellitetocity.dto.SatellitePositionDto;
import org.satellitetocity.dto.VisibilityDto;
import org.satellitetocity.entity.CityEntity;
import org.satellitetocity.entity.SatelliteEntity;
import org.satellitetocity.entity.SatelliteMapper;
import org.satellitetocity.repository.CityRepository;
import org.satellitetocity.repository.SatelliteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository repository;
    private final SatelliteMapper mapper;

    @Override
    public List<SatelliteDto> getAllSatellites() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public SatelliteDto getSatelliteById(Long id) {
        SatelliteEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Satellite not found"));
        return mapper.toDto(entity);
    }

    @Override
    public SatelliteDto createSatellite(SatelliteDto dto) {
        SatelliteEntity saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}

