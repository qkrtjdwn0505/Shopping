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
		 return "loginForm"; // �α��� �� �� ��ȯ
	}
	 
	 @PostMapping("/login")
	 public String login(String uid, String upw, HttpServletRequest request, Model model) {
	     System.out.println("LoginController login() Start----------------------------------------------------");
	     
	     try {
	         // �Է°� Ȯ��
	         if (uid == null || uid.isEmpty() || upw == null || upw.isEmpty()) {
	             model.addAttribute("errorMessage", "���̵�� ��й�ȣ�� ��� �Է����ּ���.");
	             return "loginForm";
	         }
	         
	         System.out.println("LoginController login uid >> " + uid);
	         System.out.println("LoginController login upw >> " + upw);
	         
	         // DB���� ����� ���� ��ȸ
	         UserVO uvo = userservice.loginCheck(uid);
	         
	         // ����� ������ ���� ���
	         if (uvo == null) {
	             System.out.println("LoginController: User not found");
	             model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	             return "loginForm";
	         }
	         
	         // ��й�ȣ Ȯ��
	         if (!upw.equals(uvo.getUpw())) {
	             System.out.println("LoginController: Password mismatch");
	             model.addAttribute("errorMessage", "���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	             return "loginForm";
	         }

	         // �α��� ����
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
	         model.addAttribute("errorMessage", "�α��� ó�� �� ������ �߻��߽��ϴ�.");
	         return "loginForm";
	     }
	 }
}