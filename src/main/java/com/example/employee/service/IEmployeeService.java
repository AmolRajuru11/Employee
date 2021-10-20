package com.example.employee.service;

import java.util.List;

import com.example.employee.model.Employee;


public interface IEmployeeService {
	/**
	 * This method reads FORM data as a Model class
	 * @param e indicates ModelAttribute
	 * @return Integer PK generated after save
	 */
	public Integer saveEmployee(Employee e);
    public List<Employee> getAllEmployee();
    public void deleteEmployee(Integer id);
    public void updateEmployee(Employee emp);
    public Employee getOneEmployee(Integer id);
}
