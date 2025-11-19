package org.satellitetocity.service;

import org.satellitetocity.dto.SatelliteDto;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class OrbitCalculator {

    private static final double R_EARTH = 6_371_000;
    private static final double MU = 3.986004418e14;

    public SatelliteDto calculatePosition(SatelliteDto satelliteDto, Instant time) {
        double r = R_EARTH + satelliteDto.getAltitudeMeters();

        double omega = Math.sqrt(MU / Math.pow(r, 3));

        double t = Duration.between(satelliteDto.getTime(), time).toSeconds();

        double theta = omega * t;

        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);

        double latitude = 0;
        double longitude = Math.toDegrees(theta % (2 * Math.PI));
        if (longitude < 0) longitude += 360;

        SatelliteDto result = new SatelliteDto();
        result.setX(x);
        result.setY(y);
        result.setAltitudeMeters(satelliteDto.getAltitudeMeters());
        result.setTime(time);
        result.setLongitudeDeg(longitude);
        result.setLatitudeDeg(latitude);

        return result;
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
