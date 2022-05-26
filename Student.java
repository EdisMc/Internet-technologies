package models;

import java.util.Objects;

public class Student {
	private String facultyNumber;
	private String name;
	private String course;
	private String specialty;
	private String language;
	public Student() {
		
	}
	public Student(String facultyNumber, String name, String course, String specialty, String language) {
		super();
		this.facultyNumber = facultyNumber;
		this.name = name;
		this.course = course;
		this.specialty = specialty;
		this.language = language;
	}
	public String getFacultyNumber() {
		return facultyNumber;
	}
	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public int hashCode() {
		return Objects.hash(facultyNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(facultyNumber, other.facultyNumber);
	}
	
}
