package com.ts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.EmployeeDAO;
import com.dto.Employee;

@Path("myresource")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@Path("Hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHi() {
		return "This is Hi Request";
	}

	@Path("Hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "This is Hello Request";
	}	

	@Path("GetEmployeeX")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Employee GetEmployeeX() {
		Employee employee = new Employee(101, "Harsha", "M", 7979.79, new Date("6/22/2018"),  "9700251531", "INDIA");
		return employee;
	}

	@Path("GetEmployeeJ")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee GetEmployeeJ() {
		Employee employee = new Employee(101, "Harsha", "M", 7979.79, new Date("6/22/2018"),  "9700251531", "INDIA");
		return employee;
	}

	@Path("GetEmployeesAJ")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> GetEmployeeSJ() {

		List<Employee> empList = new ArrayList<Employee>();		

		EmployeeDAO empDAO = new EmployeeDAO();
		empList = empDAO.getEmployees();

		return empList;
	}

	@Path("GetEmployeeById/{empId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee GetEmployeeById(@PathParam("empId") int empId) {

		List<Employee> empList = new ArrayList<Employee>();

		Employee employee1 = new Employee(101, "Pasha",  "M", 7878.78, new Date("05/21/2016"), "9032482080", "INDIA");
		Employee employee2 = new Employee(102, "Harsha", "M", 7676.76, new Date("06/22/2018"), "9700251531", "INDIA");
		Employee employee3 = new Employee(103, "Indira", "F", 8181.81, new Date("07/23/2016"), "8125479599", "INDIA");
		Employee employee4 = new Employee(104, "Venkat", "M", 7777.77, new Date("08/24/2017"), "8712890032", "INDIA");
		Employee employee5 = new Employee(105, "Gopi",   "M", 7575.75, new Date("02/25/2017"), "9542161124", "INDIA");

		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		empList.add(employee5);

		for(Employee emp : empList) {
			if(emp.getEmpId() == empId) {
				return emp;
			}
		}
		
		return null;
	}

	@Path("registerEmp")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerEmp(Employee employee) {
		System.out.println("\nEmployee Data Recieved from Register: \n" + employee + "\n");
		
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.register(employee);
		
		System.out.println("Employee Registered Successfully!!!");
	}
	
	@Path("updateEmp")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmp(Employee employee) {
		System.out.println("Data Received in update : " + employee);
	}


	@Path("deleteEmp/{empId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmp(@PathParam("empId") int empId) {
		System.out.println("Data Received in delete : " + empId);		
	}	
}
