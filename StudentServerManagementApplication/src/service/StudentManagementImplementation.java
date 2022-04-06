package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dataaccess.StudentDataAccess;
import domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService {

	@Inject
	private StudentDataAccess dao;
	
	@Override
	public void registerStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.getAll();
	}

	@Override
	public List<Student> searchByFirstName(String firstName) {
		return dao.findByFirstName(firstName);
	}

	@Override
	public Student getById(int id) {
		return dao.FindById(id);
	}

	@Override
	public List<Student> getByClass(String schoolClass) {
		return dao.FindByClass(schoolClass);
	}

}
