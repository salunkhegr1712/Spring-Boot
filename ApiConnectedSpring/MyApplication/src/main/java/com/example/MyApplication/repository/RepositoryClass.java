package com.example.MyApplication.repository;

import com.example.MyApplication.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends CrudRepository<Student, Integer> {

}