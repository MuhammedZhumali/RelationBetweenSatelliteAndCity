package org.satellitetocity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private double latitudeDeg;
    private double longitudeDeg;
    private double altitudeMeters;
}
//ss