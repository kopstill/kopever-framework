package com.kopdoctor.framework.data.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class CrudService<T, ID> {

    @Autowired
    private PagingAndSortingRepository<T, ID> repository;

    public Iterable<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(ID primaryKey) {
        return repository.findById(primaryKey);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public boolean existsById(ID primaryKey) {
        return repository.existsById(primaryKey);
    }

}
