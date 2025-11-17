package org.satellitetocity.repository;

import org.satellitetocity.dto.CityDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CityRepository {
    private final Map<Long, CityDto> cities = new HashMap<>();

    public CityRepository() {
        CityDto astana = new CityDto();
        astana.setId(1L);
        astana.setName("Astana");
        astana.setLatitudeDeg(51.169392);
        astana.setLongitudeDeg(71.449074);

        CityDto almaty = new CityDto();
        almaty.setId(2L);
        almaty.setName("Almaty");
        almaty.setLatitudeDeg(43.238949);
        almaty.setLongitudeDeg(76.889709);

        CityDto shymkent = new CityDto();
        shymkent.setId(3L);
        shymkent.setName("Shymkent");
        shymkent.setLatitudeDeg(42.3417);
        shymkent.setLongitudeDeg(69.5901);

        CityDto newYork = new CityDto();
        newYork.setId(4L);
        newYork.setName("New York");
        newYork.setLatitudeDeg(40.7128);
        newYork.setLongitudeDeg(-74.0060);

        CityDto losAngeles = new CityDto();
        losAngeles.setId(5L);
        losAngeles.setName("Los Angeles");
        losAngeles.setLatitudeDeg(34.0522);
        losAngeles.setLongitudeDeg(-118.2437);

        CityDto chicago = new CityDto();
        chicago.setId(6L);
        chicago.setName("Chicago");
        chicago.setLatitudeDeg(41.8781);
        chicago.setLongitudeDeg(-87.6298);

        CityDto sanFrancisco = new CityDto();
        sanFrancisco.setId(7L);
        sanFrancisco.setName("San Francisco");
        sanFrancisco.setLatitudeDeg(37.7749);
        sanFrancisco.setLongitudeDeg(-122.4194);

        CityDto london = new CityDto();
        london.setId(8L);
        london.setName("London");
        london.setLatitudeDeg(51.5074);
        london.setLongitudeDeg(-0.1278);

        CityDto paris = new CityDto();
        paris.setId(9L);
        paris.setName("Paris");
        paris.setLatitudeDeg(48.8566);
        paris.setLongitudeDeg(2.3522);

        CityDto berlin = new CityDto();
        berlin.setId(10L);
        berlin.setName("Berlin");
        berlin.setLatitudeDeg(52.5200);
        berlin.setLongitudeDeg(13.4050);

        CityDto tokyo = new CityDto();
        tokyo.setId(11L);
        tokyo.setName("Tokyo");
        tokyo.setLatitudeDeg(35.6895);
        tokyo.setLongitudeDeg(139.6917);

        CityDto seoul = new CityDto();
        seoul.setId(12L);
        seoul.setName("Seoul");
        seoul.setLatitudeDeg(37.5665);
        seoul.setLongitudeDeg(126.9780);

        CityDto dubai = new CityDto();
        dubai.setId(13L);
        dubai.setName("Dubai");
        dubai.setLatitudeDeg(25.2048);
        dubai.setLongitudeDeg(55.2708);

        cities.put(astana.getId(), astana);
        cities.put(almaty.getId(), almaty);
        cities.put(shymkent.getId(), shymkent);

        cities.put(newYork.getId(), newYork);
        cities.put(losAngeles.getId(), losAngeles);
        cities.put(chicago.getId(), chicago);
        cities.put(sanFrancisco.getId(), sanFrancisco);

        cities.put(london.getId(), london);
        cities.put(paris.getId(), paris);
        cities.put(berlin.getId(), berlin);

        cities.put(tokyo.getId(), tokyo);
        cities.put(seoul.getId(), seoul);
        cities.put(dubai.getId(), dubai);
    }

    public CityDto findById(Long id) {
        return cities.get(id);
    }

    public Collection<CityDto> findAll() {
        return cities.values();
    }
}
