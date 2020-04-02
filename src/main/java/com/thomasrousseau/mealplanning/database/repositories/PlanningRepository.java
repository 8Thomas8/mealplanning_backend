package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning, Integer> {
}
