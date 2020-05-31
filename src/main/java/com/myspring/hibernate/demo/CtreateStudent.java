package com.myspring.hibernate.demo;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myspring.hibernate.entity.Student;

public class CtreateStudent {

	public static void main(String[] args) {
		// Create Sessionfactory, session using hibernate
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		//Create and save student data,commit it
		try
		{
			Student student = new Student("Nithisha", "Arunraj", "vijigov@gmail.com");
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			System.out.println("STudent created" );
			
		}
		catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		finally {
			factory.close();
		}



	}

}
