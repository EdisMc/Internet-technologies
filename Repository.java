package repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import models.Student;

public class Repository {
	private static Repository instance = null;
	private static Set<Student> students;
	
	private Repository() {
		
	}
	
	public static Repository getInstance() {
		if(instance == null) {
			instance = new Repository();
			students = new HashSet<Student>();
		}
		return instance;
	}
	
	public boolean addStudent(Student student) {
		return students.add(student);
	}
	
	public Student getStudentByFN(String fn) {
		for(Student s : students) {
			if(s.getFacultyNumber().equals(fn)) {
				return s;
			}
		}
		return null;
	}
}
