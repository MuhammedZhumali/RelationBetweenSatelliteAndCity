package org.satellitetocity.service;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.CityDto;
import org.satellitetocity.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface CityService {
    List<CityDto> getAllCities();
    CityDto getCityById(Long id);
    CityDto createCity(CityDto dto);
}
