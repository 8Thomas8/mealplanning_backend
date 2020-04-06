package com.thomasrousseau.mealplanning.controllers.base;

import com.thomasrousseau.mealplanning.models.base.ResourceDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public abstract class BaseRestController<T extends ResourceDb<ID>, ID>
        implements CrudRestController<T, ID> {

    protected JpaRepository<T, ID> repository;

    public BaseRestController(JpaRepository<T, ID> repository) {
        super();
        this.repository = repository;
    }

    @GetMapping(value = {"", "/"})
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

    @PutMapping(value = "{id}")
    @Override
    public T update(@Valid @RequestBody T item, @PathVariable ID id) {
        item.setId(id);
        return this.save(item);
    }

    @DeleteMapping(value = {"", "/"})
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @PostMapping(value = {"", "/"})
    @Override
    public T create(@RequestBody T item) {
        return this.save(item);
    }

    @GetMapping("/count")
    @Override
    public Long count() {
        return repository.count();
    }

    protected T save(final T item) {
        return repository.save(item);
    }
}
