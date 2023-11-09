package com.learn.org;

import java.util.Optional;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.org.model.Employee;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setFirstName("Test12");
		employee.setLastName("V");
		
		session.persist(employee);
		
		//Employee emp =  session.load(Employee.class, 10);
		Employee emp =  session.get(Employee.class, 5);
		//Consumer<T>
	   Optional.ofNullable(emp).ifPresentOrElse((em)->System.out.print(em), ()->System.out.print("No Data"));
		//System.out.println(emp);
		session.getTransaction().commit();
		session.clear();
		sessionFactory.close();

	}

}
