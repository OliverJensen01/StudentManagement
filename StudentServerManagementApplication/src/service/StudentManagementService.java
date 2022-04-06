package service;

import java.util.List;

import javax.ejb.Local;

import domain.Student;

@Local
public interface StudentManagementService {
	public void registerStudent(Student student);
	public List<Student> getAllStudents();
	public List<Student> searchByFirstName(String firstName);
	public Student getById(int id); 
	public List<Student> getByClass(String schoolClass);
} 
