package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring bean : 제일 먼저 요청을 받는 객체로 만들겠다.
@RequestMapping("/lesson01/ex01") // 공통(주소)으로 사용을 할 수 있는 것은 올릴 수 있다.
public class lesson01Ex01Controller {
	
	
	// String 출력하기 = content type은 무조건 HTML이다.
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody  		   // return 되는 값을 HTML Response body에 넣어 보낸다.
	@RequestMapping("1")   // 주소 Mapping
	
	public String printString() { // 현재 방식
		String text = "예제 1번 <br> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	// Map 출력하기
	// http://localhost:8080/lesson01/ex01/2
	
	@RequestMapping("/2")
	
	public @ResponseBody Map<String, Object> printMap() { // 옛날 방식
		// {"aaaa"=1111, "bbbb"=1111....}  java의 map
		Map<String, Object> map = new HashMap<>();
		map.put("aaaa", 1111);
		map.put("bbbb", 2222);
		map.put("cccc", 3333);
		map.put("dddd", 4444);
		
		// Spring web starter 떄문에 jackson이라는 라이브러리가 포함 되어 있음
		return map; // map을 return을 하면 JSON으로 나타난다.
					
	}
}
