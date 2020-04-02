package com.thomasrousseau.mealplanning.controllers.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.thomasrousseau.mealplanning.models.base.ResourceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public abstract class BaseRestController<T extends ResourceDb<ID>, ID>
        implements CrudRestController<T, ID> {

    @Autowired
    protected JpaRepository<T, ID> repository;

    public BaseRestController(JpaRepository<T, ID> repository) {
        super();
        this.repository = repository;
    }

    @GetMapping(value = {"", "/", "/index"})
    @Override
    public Page<T> getAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping(value = {"/{id}"})
    @Override
    public Optional<T> getById(@PathVariable(name = "id") ID id) {
        return repository.findById(id);
    }

    @DeleteMapping(value = {"/{id}"})
    @Override
    public void deleteById(@PathVariable(name = "id") ID id) {
        repository.deleteById(id);
    }

    @DeleteMapping(value = {"", "/", "/index"})
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @PostMapping(value = {"", "/", "/index"})
    @Override
    public T create(@Valid @RequestBody T item) {
        return this.save(item);
    }

    @PostMapping(value = {"", "/", "/index"})
    @Override
    public T save(T item) {
        return repository.save(item);
    }

    @Override
    public T update(@Valid @RequestBody T item, @PathVariable ID id) {
        item.setId(id);
        return this.save(item);
    }

    @GetMapping("/count")
    @Override
    public Long count() {
        return repository.count();
    }
}
