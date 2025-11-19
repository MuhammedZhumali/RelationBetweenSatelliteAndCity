package org.satellitetocity.service;

import org.satellitetocity.entity.SatelliteEntity;

import java.time.Duration;
import java.time.Instant;

public class OrbitCalculator {

    private static final double R_EARTH = 6_371_000;    // meters
    private static final double MU = 3.986004418e14;   // m^3/s^2

    /**
     * Computes a simple circular orbit position (placeholder).
     * Latitude = 0 (equatorial orbit)
     * Longitude changes linearly with time.
     */
    public static double[] computePosition(SatelliteEntity sat, Instant time) {

        if (sat.getEpoch() == null) {
            sat.setEpoch(Instant.now());
        }

        double altitude = sat.getAltitudeMeters();
        double r = R_EARTH + altitude;

        double omega = Math.sqrt(MU / Math.pow(r, 3));

        double t = Duration.between(sat.getEpoch(), time).toSeconds();

        double theta = omega * t;

        double lon = Math.toDegrees(theta % (2 * Math.PI));
        if (lon < 0) lon += 360;

        double lat = 0.0;

        return new double[] { lat, lon, altitude };
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
