package org.satellitetocity.service;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.CityDto;
import org.satellitetocity.entity.CityEntity;
import org.satellitetocity.entity.CityMapper;
import org.satellitetocity.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper mapper;

    @Override
    public CityDto getCityById(Long id) {
        return cityRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CityDto createCity(CityDto cityDto) {
        CityEntity entity = mapper.toEntity(cityDto);
        CityEntity saved = cityRepository.save(entity);
        return mapper.toDto(saved);
    }
}

