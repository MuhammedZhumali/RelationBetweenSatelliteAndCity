package org.satellitetocity.service;

import org.satellitetocity.entity.SatelliteEntity;

import java.time.Duration;
import java.time.Instant;

public class OrbitCalculator {

    private static final double R_EARTH = 6_371_000;    // meters
    private static final double MU = 3.986004418e14;   // m^3/s^2

    private static double rad(double deg) {
        return deg * Math.PI / 180.0;
    }

    private static double deg(double rad) {
        return rad * 180.0 / Math.PI;
    }

    /**
     * Simple circular orbit propagation with inclination.
     * RAAN ignored for now (good enough to see movement).
     */
    public static double[] computePosition(SatelliteEntity sat, Instant time) {

        // If epoch is null → assume now
        Instant epoch = sat.getEpoch() != null ? sat.getEpoch() : Instant.now();

        // Orbit radius
        double r = R_EARTH + sat.getAltitudeMeters();

        // Angular velocity (rad/s)
        double omega = Math.sqrt(MU / Math.pow(r, 3));

        // Time since epoch
        double t = Duration.between(epoch, time).toSeconds();

        // Position angle in orbit
        double theta = omega * t;   // radians

        // Convert to orbital plane x,y
        double x_orbit = r * Math.cos(theta);
        double y_orbit = r * Math.sin(theta);

        // Inclination rotation
        double inc = rad(sat.getInclinationDeg());
        double z_orbit = Math.sin(inc) * y_orbit;
        double x_inc = x_orbit;
        double y_inc = Math.cos(inc) * y_orbit;

        // Convert to lat/lon
        double lon = Math.atan2(y_inc, x_inc);
        double hyp = Math.sqrt(x_inc * x_inc + y_inc * y_inc);
        double lat = Math.atan2(z_orbit, hyp);

        return new double[]{
                deg(lat),
                deg(lon),
                sat.getAltitudeMeters()
        };
    }
}
