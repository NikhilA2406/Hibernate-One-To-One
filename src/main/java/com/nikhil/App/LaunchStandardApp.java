package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.Answer;
import com.nikhil.model.Question;

public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Question q1=new Question();
		q1.setId(1);
		q1.setQuestion("What is Hibernate");
		
		Answer answer=new Answer();
		answer.setId(1);
		answer.setAnswer("Hibernate is a ORM Framework");
		
		q1.setAnswer(answer);
		answer.setQuestion(q1);
		
		Question q2=new Question();
		q2.setId(2);
		q2.setQuestion("What is JPA");
		
		Answer answer1=new Answer();
		answer1.setId(2);
		answer1.setAnswer("It is a Specification used to persist data between Java Object & Relational Databse");
		
		q2.setAnswer(answer1);
		answer1.setQuestion(q2);
		
		try
		{
			transaction=session.beginTransaction();
			
			session.persist(q1);
			session.persist(q2);
			session.persist(answer);
			session.persist(answer1);
			flag=true;
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}


	}

}
