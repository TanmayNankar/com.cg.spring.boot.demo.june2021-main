package com.cg.spring.boot.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

public abstract List<Employee> findEmployeeByEname(String ename);
public abstract List<Employee> getEmployeeBySalary(double salary);


@Query("SELECT e FROM Employee e WHERE e.salary != ?1")
public abstract List<Employee> findEmployeeBySalary(double salary);



} 
