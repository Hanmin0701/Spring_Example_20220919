package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lesson01/ex01")
public class lesson01Ex01RestController {
	
	// http://localhost:8080/lesson01/ex01/3
	
	@RequestMapping("/3")
	public String Ex01_3() {
		return "@RestController 사용해서 String을 리턴한다.";
	}

	// http://localhost:8080/lesson01/ex01/4
	
	@RequestMapping("/4")
	public Map<String, String> Ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "qqq");
		map.put("bbb", "aaaa");
		map.put("ccc", "pppp");
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	
	@RequestMapping("/5")
	public Data Ex01_5() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("이한민");
		return data;  // 일반 bean 객체로 json으로 변환된다. (key value가 있으면 json이 된다.)
	}
	
	// http://localhost:8080/lesson01/ex01/6
	
	@RequestMapping("/6")
	
	public ResponseEntity<Data> Ex01_6() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("이한민");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		// return new ResponseEntity<>(data, HttpStatus.OK); 
	}
}
