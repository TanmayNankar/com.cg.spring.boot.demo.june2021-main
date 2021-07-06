package com.cg.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

//CRUD operation 
@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repository;

//	public Employee findEmployeeById(int eid) {
//		LOG.info("getEmployeeById");
//		return repository.findById(eid).get();
//	}

	// method that handles exception
	public Employee findEmployeeById(int eid) {
		LOG.info("findEmployeeById");
		try {
			return repository.findById(eid).get();
		} catch (NoSuchElementException nsee) {
			LOG.error(nsee.getMessage());
			return null;
		}
	}

//Get all Employee - http://localhost:8082/getAllEmployee
	public List<Employee> getAllEmpployees() {
		LOG.info("getAllEmployees");
		return repository.findAll();
	}

//Add new Employee  
	public Employee addEmployee(Employee emp) {
		LOG.info("addEmployee");
		return repository.save(emp);
	}

// Update employee 
	public Employee updateEmployee(Employee emp) {
		LOG.info("updateEmployee");
		return repository.save(emp);
	}

// delete employee
	public int deleteEmployee(int eid) {
		LOG.info("deleteEmployee");
		repository.deleteById(eid);
		return eid;
	}

//Search by name 
	public List<Employee> getEmployeeByName(String ename) {
		LOG.info("GetByName");
		return repository.findEmployeeByEname(ename);
	}

	// search By salary

	public List<Employee> getEmployeeBySalary(double salary) {
		LOG.info("GetByName");
		return repository.getEmployeeBySalary(salary);
	}

	public List<Employee> findEmployeeBySalary(double salary) {
		LOG.info("findEmployeeBySalary");
//		return repository.findBySalary(salary);
//		return repository.findBySalaryLessThan(salary);
//		return repository.findBySalaryGreaterThan(salary);
		return repository.findEmployeeBySalary(salary);
	}

//----------------------------------------------------------------------------     

	/**
	 * Try the below code only after you are comfortable with basic spring boot
	 * concepts
	 */

	// getting all Employee record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployees() {
		List<Employee> employee = new ArrayList<Employee>();
		repository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) {
		// logic
		try {
			return repository.findById(id).get();
		} catch (NoSuchElementException nse) {
			LOG.error("Not a valid employee id");

			return null;
		} catch (Exception ex) {
			// LOG.info();
			return null;
		}
	}

//	public List<Employee> getEmployeeByName(String ename) {
//		return repository.findEmployeeByEname(ename);
//	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
		repository.save(employee);
	}

	// updating a record
	public void update(Employee employee, int eid) {
		repository.save(employee);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		repository.deleteById(id);
	}

}
