package com.myspring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.myspring.hibernate.entity.Student;

public class GetStudents {

	public static void main(String[] args) {
		
		
		// Create Sessionfactory, session using hibernate
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				Session session = factory.getCurrentSession();
				//Begin Transaction, get the student list display and close
				try
				{
					Transaction transaction = session.beginTransaction();
					List<Student> list =  session.createQuery("from Student where lastName LIKE 'A%' ").getResultList();
					for (Student student : list) {
						System.out.println(student);
					}
					System.out.println("STudent Retrieved" );
					transaction.commit();
					
					
				}
				catch (Exception e) {
					System.out.println("Error" + e.getMessage());
				}
				finally {
					factory.close();
				}


	}

}
