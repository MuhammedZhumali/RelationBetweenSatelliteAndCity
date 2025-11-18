package org.satellitetocity.service;

import org.satellitetocity.dto.SatelliteDto;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrbitCalculator {

    private static final double R_EARTH = 6_371_000;
    private static final double MU = 3.986004418e14;

    public SatelliteDto calculatePosition(SatelliteDto satelliteDto, Instant time) {
        double r = R_EARTH + satelliteDto.getAltitudeMeters();
        double omega = Math.sqrt(MU/Math.pow(r, 3));
        double period = (2 * Math.PI) / omega;

        SatelliteDto satelliteDto2 = new SatelliteDto();
        satelliteDto2.setAltitudeMeters(r * period);
        satelliteDto2.setTime(time);

        return satelliteDto2;
    }
}


/*
Theory Math
    Earth Radius (R) = 6 371 000 meters = 6371 km
    Standard Earth Gravitational parameter (u) = 3.98 * 10^14 m^3/s^2
    Attitude (h) of satellite above earth (r) = R + h
    Orbital period (T) = 2*Pi / w = 2*Pi * sqrt(r^3/u)
    Circular orbit angular velocity (w) = sqrt(u/T^3)
    Position in 2D at time t: x(t) = r*cos(wt), y(t) = r*sin(wt)

    Eccentricity
    if e = 0 - ideal circle
    if e > 0 - ellipse
    if e = 1 - very stretched orbit
*/
