package com.kmove.app.User.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kmove.app.User.service.UserService;
import com.kmove.app.User.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userservice;
	
	private static final String LOGIN_OK = "LOGIN_OK";
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
        System.out.println("LoginController logout() Start----------------------------------------------------");
        session.invalidate();      
        System.out.println("LoginController logout() End----------------------------------------------------");
        return "redirect:/";	
	}
	
	 @GetMapping("/login")
	 public String loginForm() {
		 return "loginForm"; // 로그인 폼 뷰 반환
	}
	 
	 @PostMapping("/login")
	 public String login(String uid, String upw, HttpServletRequest request, Model model) {
	     System.out.println("LoginController login() Start----------------------------------------------------");
	     
	     try {
	         // 입력값 확인
	         if (uid == null || uid.isEmpty() || upw == null || upw.isEmpty()) {
	             model.addAttribute("errorMessage", "아이디와 비밀번호를 모두 입력해주세요.");
	             return "loginForm";
	         }
	         
	         System.out.println("LoginController login uid >> " + uid);
	         System.out.println("LoginController login upw >> " + upw);
	         
	         // DB에서 사용자 정보 조회
	         UserVO uvo = userservice.loginCheck(uid);
	         
	         // 사용자 정보가 없는 경우
	         if (uvo == null) {
	             System.out.println("LoginController: User not found");
	             model.addAttribute("errorMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
	             return "loginForm";
	         }
	         
	         // 비밀번호 확인
	         if (!upw.equals(uvo.getUpw())) {
	             System.out.println("LoginController: Password mismatch");
	             model.addAttribute("errorMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
	             return "loginForm";
	         }

	         // 로그인 성공
	         HttpSession session = request.getSession();
	         session.setAttribute("uidx", uvo.getUidx());
	         session.setAttribute("uid", uvo.getUid());
	         session.setAttribute("uname", uvo.getUname());
	         session.setAttribute("ugrade", uvo.getUgrade());
	         
	         System.out.println("LoginController login() End----------------------------------------------------");
	         return "redirect:/";
	         
	     } catch (Exception e) {
	         System.out.println("LoginController: Error during login process");
	         e.printStackTrace();
	         model.addAttribute("errorMessage", "로그인 처리 중 오류가 발생했습니다.");
	         return "loginForm";
	     }
	 }
}
