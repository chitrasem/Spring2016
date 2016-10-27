package com.chitra.kmt.dao;

import java.util.List;

import com.chitra.kmt.model.Student;

public interface StudentDao {
	
	List findAll(int userId, String firstName, String lastName, String searchName, int maxResult, int firstResult);
	long countRecordListl(int userId, String firstName, String lastName, String searchName);
	
	void save(Student student);
	Student findById(int id);
	Student findByFirstName(String firstName);

}
