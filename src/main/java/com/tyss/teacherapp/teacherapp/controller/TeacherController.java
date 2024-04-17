package com.tyss.teacherapp.teacherapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.teacherapp.teacherapp.dto.ResponseStructure;
import com.tyss.teacherapp.teacherapp.entity.Teacher;
import com.tyss.teacherapp.teacherapp.service.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@Operation(description = "To Save Student Info", summary = "Student will be saved in DataBase")
	@ApiResponses(value = { @ApiResponse(description = "Student Created..", responseCode = "201") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> getStudentById(@PathVariable int id) {
		return teacherService.getStudentById(id);
	}

	@PutMapping
	public String updateTeacher(@RequestBody Teacher teacher) {
		return teacherService.updateTeacher(teacher);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTeacher(@PathVariable int id) {
		return teacherService.deleteTeacher(id);
	}
	
	@GetMapping("/all")
	public List<Teacher> getAll(){
		return teacherService.getAll();
	}
}
