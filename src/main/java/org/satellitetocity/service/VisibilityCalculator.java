package org.satellitetocity.service;

public class VisibilityCalculator {
    private static final double R_EARTH = 6_371_000;

    private static double rad(double deg) {
        return deg * Math.PI / 180.0;
    }

    // Convert geodetic coordinates to ECEF XYZ
    public static double[] toECEF(double latDeg, double lonDeg, double altMeters) {
        double lat = rad(latDeg);
        double lon = rad(lonDeg);

        double cosLat = Math.cos(lat);
        double sinLat = Math.sin(lat);
        double cosLon = Math.cos(lon);
        double sinLon = Math.sin(lon);

        double r = R_EARTH + altMeters;

        double x = r * cosLat * cosLon;
        double y = r * cosLat * sinLon;
        double z = r * sinLat;

        return new double[]{x, y, z};
    }

    // Dot product
    private static double dot(double[] a, double[] b) {
        return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
    }

    // Vector length
    private static double norm(double[] v) {
        return Math.sqrt(dot(v, v));
    }

    // Subtract vectors: a - b
    private static double[] subtract(double[] a, double[] b) {
        return new double[]{
                a[0] - b[0],
                a[1] - b[1],
                a[2] - b[2]
        };
    }

    // Normalize vector
    private static double[] normalize(double[] v) {
        double n = norm(v);
        return new double[]{v[0]/n, v[1]/n, v[2]/n};
    }

    // MAIN: Calculate elevation angle
    public static double elevationDeg(
            double satLat, double satLon, double satAlt,
            double cityLat, double cityLon, double cityAlt) {

        double[] satECEF = toECEF(satLat, satLon, satAlt);
        double[] cityECEF = toECEF(cityLat, cityLon, cityAlt);

        double[] up = normalize(cityECEF);           // local "up" vector
        double[] diff = subtract(satECEF, cityECEF); // direction to satellite

        double cosAngle = dot(diff, up) / norm(diff);

        return Math.toDegrees(Math.asin(cosAngle));
    }
}
