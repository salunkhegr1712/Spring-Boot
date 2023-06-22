package com.example.Application.repository;

import com.example.Application.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends CrudRepository<Person,Integer> {
}
