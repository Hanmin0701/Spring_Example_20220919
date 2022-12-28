package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@Controller
@RequestMapping("/lesson04/ex01")
public class Lesson04Ex01Controller {
	
	@Autowired
	// autowired가 여러개 있으면 autowired는 하나만 되니까 하나씩 해야한다.
	private UserBO userBO;
	
	// 회원가입 화면(add_user_view)
	//http://localhost:80/lesson04/ex01/add_user_view
	
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET) // path= 이거 생략해도 됨
	public String addUserView() {
		//     /WEB-INF/jsp/(lesson04/addUser).jsp
		return "lesson04/addUser";
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email, // null이 허용이면 이렇게 해야함
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser"; // 결과 jsp
	}
	
	//http://localhost:80/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUserView(Model model) {
		
		// DB select 
		// 가장 마지막에 추가된 사람 한명 가져오기
		User user = userBO.getLastUser(); // 여러개로 가져올거면 List<user>로 하기
		
		// model에 데이터를 담아 놓으면 jsp에서 꺼내서 사용을 할 수 있다.
		model.addAttribute("seller", user);
		model.addAttribute("title", "회원 정보");
		
		
		return "lesson04/getLastUser"; // 결과 jsp
	}
}
