package com.roopesh.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.roopesh.entities.Student;
import com.roopesh.config.HibernateUtil;

public class StudentDAO {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@SuppressWarnings("unchecked")
	public List<Object> getListOfAllStudents()
	{
		try
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Object> listOfAllStudents = session.createCriteria(Student.class).list();
			tx.commit();
			session.close();
			return listOfAllStudents;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Student se = session.get(Student.class, id);
			t.commit();
			session.close();
			return se;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public String addStudent(Student st) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.save(st);
			t.commit();
			session.close();
			return "HTTP Status 201 Student Added";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	public String markStudentInactive(Integer id) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Student st = (Student)session.get(Student.class, id);
			st.setActive("False");
			session.saveOrUpdate(st);
			t.commit();
			session.close();
			return "Student marked inactive";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	public String updateStudent(com.roopesh.beans.Student student, Integer id) {
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Student st = (Student)session.get(Student.class, id);
			if(st != null)
			{
				if(student.getId()!=null)
					st.setId(student.getId());
				if(student.isActive()!=null)
					st.setActive(student.isActive()?"True":"False");
				if(student.getAdmissionYear()!=null)
					st.setAdmissionYear(student.getAdmissionYear());
				if(student.getName()!=null)
					st.setName(student.getName());
				if(student.getClasss()!=null)
					st.setClasss(student.getClasss());
				session.update(st);
				t.commit();
				session.close();
				return "Student details updated";
			}
			else
				return "Student Not Found";
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
