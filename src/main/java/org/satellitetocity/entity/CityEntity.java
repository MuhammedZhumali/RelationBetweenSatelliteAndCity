package org.satellitetocity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class CityEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double latitudeDeg;
    private double longitudeDeg;
    private double altitudeMeters;
}
