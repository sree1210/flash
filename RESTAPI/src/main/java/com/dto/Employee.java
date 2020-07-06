package com.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
//@Table(name="EmployeeDetails")
public class Employee {
	@Id@GeneratedValue
	private int empId;		
	private String empName;
	private String gender;
	private double salary;
	private Date doj;
	private String mobile;
	private String country;
	
	public Employee() {		
	}

	public Employee(int empId, String empName, String gender, double salary, Date doj, String mobile, String country) {
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.salary = salary;
		this.doj = doj;
		this.mobile = mobile;
		this.country = country;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", salary=" + salary
				+ ", doj=" + doj + ", mobile=" + mobile + ", country=" + country + "]";
	}	
}
