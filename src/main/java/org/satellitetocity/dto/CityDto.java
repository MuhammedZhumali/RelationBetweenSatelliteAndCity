package org.satellitetocity.dto;

import lombok.Data;

@Data
public class CityDto {
    private Long id;
    private String name;
    private double latitudeDeg;
    private double longitudeDeg;
}
