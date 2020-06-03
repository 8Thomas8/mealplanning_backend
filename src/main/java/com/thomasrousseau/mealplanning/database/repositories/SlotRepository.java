package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
}
