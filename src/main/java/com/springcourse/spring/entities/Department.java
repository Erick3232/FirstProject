package com.springcourse.spring.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DEPARTMENT")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_department;
	private String department;
	
	public Department() {
		
	}
	public Department(Integer id_department, String department) {
		super();
		this.id_department = id_department;
		this.department = department;
	}
	
	public Integer getId_department() {
		return id_department;
	}
	public void setId_department(Integer id_department) {
		this.id_department = id_department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_department);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id_department, other.id_department);
	}
	
	
	
}
