package com.cg.spring.boot.demo;


import com.cg.spring.boot.demo.model.Employee;

public class Delete {

	public static void main(String[] args) {

		Employee emp = new Employee(101, "Sonu", 10.5);
		System.out.println(emp.toString());
	}

}