package com.roopesh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "classs")
    private Integer classs;
    
    @Column(name = "active")
	private String active;
    
    @Column(name = "admissionyear")
	private String admissionyear;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClasss() {
		return classs;
	}

	public void setClasss(Integer classs) {
		this.classs = classs;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAdmissionyear() {
		return admissionyear;
	}

	public void setAdmissionYear(String admissionyear) {
		this.admissionyear = admissionyear;
	}

}
