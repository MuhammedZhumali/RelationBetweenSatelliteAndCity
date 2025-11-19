package org.satellitetocity.service;

import org.satellitetocity.dto.CityDto;
import org.satellitetocity.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDto getCityById(Long id) {
        CityDto city = cityRepository.findById(id);
        if (city == null) {
            throw new RuntimeException("City not found"); // потом заменишь на нормальное исключение/ResponseStatus
        }
        return city;
    }

    public Collection<CityDto> getAllCities() {
        return cityRepository.findAll();
    }

}
