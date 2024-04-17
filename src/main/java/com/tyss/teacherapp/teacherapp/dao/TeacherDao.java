package com.tyss.teacherapp.teacherapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.teacherapp.teacherapp.entity.Teacher;
import com.tyss.teacherapp.teacherapp.repository.TeacherRepository;

import io.swagger.v3.oas.annotations.Operation;

@Repository
public class TeacherDao {

	@Autowired
	private TeacherRepository teacherRepository;

	public Teacher saveTeacher(Teacher teacher) {

		return teacherRepository.save(teacher);

	}

	public Teacher getStudentById(int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public String updateTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		return "Data Updated...";
	}
	public String deleteTeacher(int id) {
		 Optional<Teacher> optional = teacherRepository.findById(id);
		 if(optional.isPresent()) {
			Teacher t = optional.get();
			teacherRepository.delete(t);
			return "Record Deleted...";
		 }
		 else
			 return "Record is Not Found";
	}
	public List<Teacher> getAll() {
		 List<Teacher> list = teacherRepository.findAll();
		 return list;
	}

}
