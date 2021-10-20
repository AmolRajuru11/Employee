package com.example.employee.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "prj_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ename;
	private String email;
	private String gender;
	private String eaddr;

	@ElementCollection
	@CollectionTable(name = "emp_prjs_tab", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "emp_prjs_col")
	private List<String> prjs;

	@ElementCollection
	@CollectionTable(name = "emp_slots_tab", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "emp_slots_col")
	private List<String> slots;

}
