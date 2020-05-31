package com.myspring.hibernate.onetomanyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

	public static void main(String[] args) {
		// Create Sessionfactory, session using hibernate
		SessionFactory factory = new Configuration().configure("hibernate.cfg3.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		//Create and save student data,commit it
		try
		{
			int id = 2;
			
			
			Transaction transaction = session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println(instructor.getCourses());
			transaction.commit();
			System.out.println("instructor and details created" );
			
		}
		catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		finally {
			session.close();
			factory.close();
		}



	}

}
