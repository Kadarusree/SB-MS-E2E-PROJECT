package com.srikanth.repo;

import org.springframework.data.repository.CrudRepository;

import com.srikanth.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	// This interface extends CRUDRepository which provides basic CRUD operations
	// for the Student entity with Integer as the ID type.

	// No additional methods are required unless specific queries are needed.
	// The default methods provided by CRUDRepository will suffice for basic operations.

	// Additional query methods can be defined here if needed

}
