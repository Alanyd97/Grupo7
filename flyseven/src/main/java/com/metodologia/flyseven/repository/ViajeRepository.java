package com.metodologia.flyseven.repository;

import com.metodologia.flyseven.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by efalcon
 */
@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
}
