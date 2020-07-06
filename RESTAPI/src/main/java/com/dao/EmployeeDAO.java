package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dto.Employee;

public class EmployeeDAO {
	
	public void register(Employee employee) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");	
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		session.save(employee);			//Insert Operation - Insert Query
		
		Transaction txn = session.beginTransaction();
		txn.commit();		//Permanant Save
		
		session.close();
	}
	
	public List<Employee> getEmployees() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");	
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Query q1 = session.createQuery("from Employee");
		
		List<Employee> empList = (ArrayList<Employee>) q1.list();
		session.close();

		return empList;
	}
	
	
}
