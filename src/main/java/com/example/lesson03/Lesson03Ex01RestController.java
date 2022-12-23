package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {

	// http://localhost:80/lesson03/ex01/1?id=2
	
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/lesson03/ex01/1")
	public Review ex01_1(
			@RequestParam(value="id") int id   // 필수 파라미터 
//			@RequestParam(value="id", required=false) int id   // 필수 파라미터 1번째 방법
//			@RequestParam(value="id", required=true) int id // 2번째 방법
//			@RequestParam(value="id", required=false) Integer id  // 3번째 방법
//			@RequestParam(value="id",defaultValue="1") int id 
						// 비필수 파라미터인데, 디폴트값 때문에 null은 아니다. required=false는 디폴드와 같은 의미여서 쓰지X
			) {
		return reviewBO.getReivew(id);

// 		3번째 방법
//		if(id == null) {
//			return null;
//		} else {
//			return reviewBO.getReivew(id);
//		}
	}
}
