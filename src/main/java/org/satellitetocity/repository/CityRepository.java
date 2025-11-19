package org.satellitetocity.repository;

import org.satellitetocity.dto.CityDto;
import org.satellitetocity.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
