package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.Meat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<Meat, Integer> {
}
