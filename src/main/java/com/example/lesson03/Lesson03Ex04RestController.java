package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {
	
	// delete문
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:80/lesson04/ex03/1?id=21%review=도미노피자는 역시 맛있어!
	@RequestMapping("/lesson03/ex04/1")
	public String ex04(
			@RequestParam("id") int id) {
		
		reviewBO.deleteReviewById(id); 
		return "삭제 완료";
	}
}
