package com.hcl.ManyToManyByUsingSpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ManyToManyByUsingSpringDataJpa.model.Student;

public interface StundentRepository extends JpaRepository<Student, Long> {

}
