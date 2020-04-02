package com.thomasrousseau.mealplanning.controllers.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.Optional;

public interface CrudRestController<T, ID> {
    /**
     * Get all method.
     *
     * @param pageable add page gestion.
     * @return is a result with pagination.
     */
    Page<T> getAll(@PageableDefault() final Pageable pageable);

    /**
     * Get by id.
     *
     * @param id: the id of the object to get.
     * @return is an object.
     */
    Optional<T> getById(ID id);

    /**
     * Delete an object by id.
     *
     * @param id: the id of the object to delete.
     */
    void deleteById(ID id);

    /**
     * Delete all the objects.
     */
    void deleteAll();

    /**
     * Create an object.
     *
     * @param item: it's the object to create.
     * @return is an object with T type.
     */
    T create(T item);

    /**
     * Return a number of object of a type.
     *
     * @return is a number of counted objects.
     */
    Long count();

    /**
     * Save an object.
     *
     * @param item is the object to save.
     * @return is the object saved.
     */
    T save(T item);

    /**
     * Update a saved object.
     *
     * @param item is the new item to save.
     * @param id   is the id of the object to update.
     * @return return is the object, updated.
     */
    T update(T item, ID id);
}
