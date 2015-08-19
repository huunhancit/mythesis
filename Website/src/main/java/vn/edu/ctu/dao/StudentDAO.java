package vn.edu.ctu.dao;

import java.util.List;

import vn.edu.ctu.model.student.Student;

public interface StudentDAO {
	public void createStudent(Student student);

	public boolean checkLogin(String mssv, String password);

	public Student showStudent(String mssv);
	
	public List<Student> getListStudent();
}
