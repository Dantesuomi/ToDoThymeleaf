package com.example.todospring.service;

import com.example.todospring.entity.Todo;

import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepository{
    @Override
    public <S extends Todo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Todo> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Todo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Todo> findAll() {
        return null;
    }

    @Override
    public Iterable<Todo> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Todo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Todo> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
