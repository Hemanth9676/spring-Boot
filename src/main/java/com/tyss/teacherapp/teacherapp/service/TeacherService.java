package com.tyss.teacherapp.teacherapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.teacherapp.teacherapp.dao.TeacherDao;
import com.tyss.teacherapp.teacherapp.dto.ResponseStructure;
import com.tyss.teacherapp.teacherapp.entity.Teacher;
import com.tyss.teacherapp.teacherapp.exception.IdDoesNotPresentExeception;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(Teacher teacher) {

		Teacher recive = teacherDao.saveTeacher(teacher);

		ResponseStructure<Teacher> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(recive);

		return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Teacher>> getStudentById(int id) {
		Teacher teacher = teacherDao.getStudentById(id);

		if (teacher != null) {
			ResponseStructure<Teacher> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(teacher);
			return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdDoesNotPresentExeception("ID : " + id + ", Not Present in DB");

	}
    public String updateTeacher(Teacher teacher) {
    	return teacherDao.updateTeacher(teacher);
    }
    public String deleteTeacher(int id) {
    	return teacherDao.deleteTeacher(id);
    }
    public List<Teacher> getAll(){
    	return teacherDao.getAll();
    }
}
