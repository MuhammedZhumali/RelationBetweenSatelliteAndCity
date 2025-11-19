package org.satellitetocity.controller;

import lombok.RequiredArgsConstructor;
import org.satellitetocity.dto.CityDto;
import org.satellitetocity.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/get/{cityId}")
    public CityDto getCity(@PathVariable Long cityId) {
        return cityService.getCityById(cityId);
    }

    @GetMapping("/get/all")
    public Collection<CityDto> getAllCities() {
        return cityService.getAllCities();
    }
    @PostMapping
    public CityDto createCity(@RequestBody CityDto cityDto) {
        return cityService.createCity(cityDto);
    }
}
