package com.roopesh.beans;

public class Student {
	private Integer id;
	private String name;
	private Integer classs;
	private Boolean active;
	private String admissionYear;
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
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(String admissionYear) {
		this.admissionYear = admissionYear;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
