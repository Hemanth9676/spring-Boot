package com.tyss.teacherapp.teacherapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.teacherapp.teacherapp.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
