package com.roopesh.students.service;

import java.util.ArrayList;
import java.util.List;

import com.roopesh.entities.Student;
import com.roopesh.dao.StudentDAO;

public class StudentService {
	
	public List<Object> getListOfAllStudents()
	{
		List<Object> listOfAllStudents = new StudentDAO().getListOfAllStudents();
		return listOfAllStudents; 	
	}
	
	public List<Object> getListOfStudents(String classes,Boolean active,String admissionYear)
	{
		List<Object> lst = new ArrayList<Object>();
		List<Object> listOfAllStudents = getListOfAllStudents();
		String [] listOfClasses = classes.split(",");
		for(int i=0;i<listOfClasses.length;i++)
		{
			String classess = listOfClasses[i];
			for(int j=0;j<listOfAllStudents.size();j++)
			{
				String classe = new String(((Student)(listOfAllStudents.get(j))).getClasss()+"");
				String admission = ((Student)(listOfAllStudents.get(j))).getAdmissionyear();
				if(classe.equals(classess) && active.booleanValue()==new Boolean(((Student)(listOfAllStudents.get(j))).getActive()).booleanValue() && admission.compareTo(admissionYear)>=0)
					lst.add(listOfAllStudents.get(j));
			}
		}
		return lst;
	}
	
	public List<Object> getListOfStudents(String classes,Boolean active)
	{
		List<Object> lst = new ArrayList<Object>();
		List<Object> listOfAllStudents = getListOfAllStudents();
		String [] listOfClasses = classes.split(",");
		for(int i=0;i<listOfClasses.length;i++)
		{
			String classess = listOfClasses[i];
			for(int j=0;j<listOfAllStudents.size();j++)
			{
				String classe = new String(((Student)(listOfAllStudents.get(j))).getClasss()+"");
			
				if(classe.equals(classess) && active.booleanValue()==new Boolean(((Student)(listOfAllStudents.get(j))).getActive()).booleanValue())
					lst.add(listOfAllStudents.get(j));
			}
		}
		return lst;
	}
	
	public List<Object> getListOfStudents(String classes)
	{
		List<Object> lst = new ArrayList<Object>();
		List<Object> listOfAllStudents = getListOfAllStudents();
		String [] listOfClasses = classes.split(",");
		for(int i=0;i<listOfClasses.length;i++)
		{
			String classess = listOfClasses[i];
			for(int j=0;j<listOfAllStudents.size();j++)
			{
				String classe = new String(((Student)(listOfAllStudents.get(j))).getClasss()+"");
				if(classe.equals(classess))
					lst.add(listOfAllStudents.get(j));
			}
		}
		return lst;
	}

	public List<Object> getListOfStudents(Boolean active) {
		List<Object> lst = new ArrayList<Object>();
		List<Object> listOfAllStudents = getListOfAllStudents();
		for(int j=0;j<listOfAllStudents.size();j++)
		{
			boolean activei = new Boolean(((Student)(listOfAllStudents.get(j))).getActive()).booleanValue();
			if(active.booleanValue()==activei)
				lst.add(listOfAllStudents.get(j));
		}
		return lst;
	}

	public com.roopesh.beans.Student getStudentbyId(Integer id) {
		// TODO Auto-generated method stub
		Student ste = new StudentDAO().getStudentById(id);
		if(ste!=null)
		{
			com.roopesh.beans.Student st1 = new com.roopesh.beans.Student();
			st1.setId(ste.getId());
			st1.setClasss(ste.getClasss());
			st1.setAdmissionYear(ste.getAdmissionyear());
			st1.setActive(new Boolean(ste.getActive()));
			st1.setName(ste.getName());
			return st1;
		}
		
		return null;
	}

	public String addStudent(com.roopesh.beans.Student student) {
		// TODO Auto-generated method stub
		Student st = new Student();
		st.setId(student.getId());
		st.setClasss(student.getClasss());
		st.setAdmissionYear(student.getAdmissionYear());
		st.setActive(student.isActive()?"True":"False");
		st.setName(student.getName());
		String str = new StudentDAO().addStudent(st);
		return str;
	}

	public String markStudentInactive(Integer id) {
		com.roopesh.beans.Student st = getStudentbyId(id);
		if(st==null)
		{
			return "Student Not Present with this ID";
		}
		else
		{
			return new StudentDAO().markStudentInactive(id);
		}
	}

	public String updateStudent(com.roopesh.beans.Student student, Integer id) {
		com.roopesh.beans.Student st = getStudentbyId(id);
		if(st != null)
		{
			return new StudentDAO().updateStudent(student,id);
		}
		else
			return "Student not found";
	}

}
