package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@Controller
@RequestMapping("lesson04/ex02")
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost:80/lesson04/ex02/add_student_view
	
	@GetMapping("add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student) { // 여러개의 객체를 받아야 할때 @ModelAttribute 이걸 사용을 하자
											   // name(request Param)과 필드명이 일치하는 것이 담긴다.	
		
		// DB insert
		StudentBO.addStudent(student);
		
		// DB select(방금 가입된 사람)
		
		// view 페이지 이동(응답값)
		return "lesson04/afterAddStudent";
	}
}
