package com.ghansham.Security.repository;

import com.ghansham.Security.model.Student;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RepositoryClass extends CrudRepository<Student, Integer> {

}