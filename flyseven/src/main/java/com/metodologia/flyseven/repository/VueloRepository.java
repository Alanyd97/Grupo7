package com.metodologia.flyseven.repository;

import com.metodologia.flyseven.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by efalcon
 */
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
