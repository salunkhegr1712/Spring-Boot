package com.example.MyApplication.repository;

import com.example.MyApplication.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPerson extends CrudRepository<Person,Integer> {
}
