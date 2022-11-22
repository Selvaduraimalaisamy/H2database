package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer>{

}
