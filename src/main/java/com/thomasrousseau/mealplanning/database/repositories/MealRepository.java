package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
