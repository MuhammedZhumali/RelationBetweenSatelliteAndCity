package org.satellitetocity.controller;

import org.satellitetocity.dto.CityDto;
import org.satellitetocity.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/get/{cityId}")
    public CityDto getCity(@PathVariable Long cityId) {
        return cityService.getCityById(cityId);
    }

    @GetMapping("/get/all")
    public Collection<CityDto> getAllCities() {
        return cityService.getAllCities();
    }
}
