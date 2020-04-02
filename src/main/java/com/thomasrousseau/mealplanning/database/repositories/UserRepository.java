package com.thomasrousseau.mealplanning.database.repositories;

import com.thomasrousseau.mealplanning.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
