package com.metodologia.flyseven.repository;

import com.metodologia.flyseven.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by efalcon
 */
@Repository
public interface PlanRepository  extends JpaRepository<Plan, Integer> {
}
