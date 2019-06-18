package com.roopesh.students.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roopesh.beans.ErrorMessage;
import com.roopesh.beans.Student;
import com.roopesh.students.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@RequestMapping()
	public List<Object> getStudentsByClassesAndActiveAndAdmissionYear(@RequestParam(value = "classes", required = false)String classes, @RequestParam(value = "active", required = false)Boolean active, @RequestParam(value = "admissionYear", required = false)String admissionYear)
	{
		List<Object> listOfAllStudents = new StudentService().getListOfAllStudents();
		List<Object> lst = new ArrayList<Object>();
		if(classes!=null && active!=null && admissionYear!=null)
		{
			lst = new StudentService().getListOfStudents(classes, active, admissionYear);
		}
		else if(classes!=null && active!=null && admissionYear==null)
		{
			lst = new StudentService().getListOfStudents(classes, active);
		}
		else if(classes!=null && active == null && admissionYear == null)
		{
			lst = new StudentService().getListOfStudents(classes);
		}
		else if(classes==null && active != null)
		{
			lst = new StudentService().getListOfStudents(active);
		}
		else
			return listOfAllStudents;
		return lst;
	}
	
	@RequestMapping("/{id}")
	public Object getStudentById(@PathVariable Integer id)
	{
		Student s = new StudentService().getStudentbyId(id);
		if(s!=null)
			return s;
		ErrorMessage em = new ErrorMessage();
		em.setMessage("HTTP Status 404");
		return em;
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Object createStudent(@RequestBody Student student)
	{
		if(student.isActive()==null)
			student.setActive(true);
		String str = new StudentService().addStudent(student);
		ErrorMessage em = new ErrorMessage();
		em.setMessage(str);
		return em;
	}
	
	@PatchMapping(path="/{id}",consumes = "application/json", produces = "application/json")
	public Object updateStudent(@PathVariable Integer id, @RequestBody Student student)
	{
		String str = new StudentService().updateStudent(student,id);
		ErrorMessage em = new ErrorMessage();
		em.setMessage(str);
		return em;
	}
	
	@DeleteMapping(path="/{id}",consumes = "application/json", produces = "application/json")
	public Object inactiveUser(@PathVariable Integer id)
	{
		String str = new StudentService().markStudentInactive(id);
		ErrorMessage em = new ErrorMessage();
		em.setMessage(str);
		return em;
	}
}
