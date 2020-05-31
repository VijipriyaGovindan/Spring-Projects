package com.myspring.hibernate.onetomanyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {

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
			Instructor instructor = new Instructor("Vijipriya", "Arunraj", "vijigov@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("somesd", "dancing");
			instructor.setInstructorDetail(instructorDetail);
			Course course1 = new Course("Spring Framework 12");
			Course course2 = new Course("Spring Boot 1222");
			instructor.addCourse(course1);
	
			instructor.addCourse(course2);
			
			System.out.println(instructor);
			Transaction transaction = session.beginTransaction();
			session.save(course1);
			session.save(course2);
			session.save(instructor);
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
