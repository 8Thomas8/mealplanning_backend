package com.thomasrousseau.mealplanning.models.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Define the entity's base, with the id attribute.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class EntityBase {
    /**
     * The id attribute, for each entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
