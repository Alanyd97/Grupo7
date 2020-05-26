package com.metodologia.flyseven.repository;

import com.metodologia.flyseven.model.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by efalcon
 */
@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Integer> {
}
