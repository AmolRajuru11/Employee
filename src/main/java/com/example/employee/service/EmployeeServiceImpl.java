package com.example.employee.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		// after save(obj) same object is return with id effected
		e=repo.save(e);
		return e.getId();
	}
	@Override
	public List<Employee> getAllEmployee() {
	List<Employee> list=repo.findAll();
	//Interface ob=(method param)->{method body;}
	list.sort((e1,e2)->e1.getId()-e2.getId());
		return list;
	}
	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		}
	@Override
	public void updateEmployee(Employee emp) {
		repo.save(emp);
		}
	@Override
	public Employee getOneEmployee(Integer id) {
		Employee employee=repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee'"+id+"' Not exist"));
		return employee;
		}

}
