package com.example.tutorial3.service;

import java.util.List;
import java.util.ArrayList;
import com.example.tutorial3.model.StudentModel;

public abstract class InMemoryStudentService implements StudentService {
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();
	
	@Override
	public StudentModel selectStudent(String npm) {
		for (StudentModel student : studentList) {
			if (npm.equals(student.getNpm()))
				return student;
		}
		return null;
	}
	
	@Override
	public List<StudentModel> selectAllStudents() {
		return studentList;
	}
	
	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}
	
	@Override
	public String deleteStudent(String npm) {
		String result = "";
		for (StudentModel student : studentList) {
			if (npm.equals(student.getNpm())) {
				studentList.remove(student);
				result = "success";
				break;
			} 
		}
		return result;
	}
}
