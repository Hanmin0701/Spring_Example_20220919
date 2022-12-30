package com.example.lesson05;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05")
public class Lesson05Controller {
	
	// http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("mango");
		fruits.add("orange");
		fruits.add("peach");
		
		model.addAttribute("fruits", fruits);
		
		// List<map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "이한민");
		user.put("age", 22);
		user.put("hobby", "독서");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "이찬민");
		user.put("age", 21);
		user.put("hobby", "사냥하기");
		users.add(user);
		
		model.addAttribute("users", user);
		
		return "lesson05/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
		return "lesson05/ex03";
	}
}
