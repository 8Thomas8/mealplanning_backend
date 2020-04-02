package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.Accompaniment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccompanimentRepository extends JpaRepository<Accompaniment, Integer> {
}
