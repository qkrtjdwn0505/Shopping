package com.kmove.app.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.kmove.app.Common.Chaebun;
import com.kmove.app.Common.PageHandler;
import com.kmove.app.User.service.UserService;
import com.kmove.app.User.vo.SearchCondition;
import com.kmove.app.User.vo.UserVO;

/**
 * 사용자 관리를 위한 컨트롤러 클래스
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userservice;
    
    /**
     * 메인 페이지로 이동
     * @return 메인 페이지 뷰 이름
     */
    @RequestMapping(value = "/")
    public String main() {
        return "index";
    }
    
    /**
     * 회원 가입/수정 폼을 보여주는 메서드
     * 로그인된 사용자의 경우 기존 정보를 폼에 표시
     * @param session HTTP 세션
     * @param model Spring Model 객체
     * @return 회원 폼 뷰 이름
     */
    
    //회원가입
    @RequestMapping(value = "/form")
    public String insertUser(HttpSession session, Model model) throws Exception {
        System.out.println("UserController userform Start----------------------------------------------------");
        
        // 세션에서 사용자 ID 가져오기
        String uidx = (String)session.getAttribute("uidx");
        System.out.println(uidx);
        
        // 사용자 정보 조회
        UserVO uvo = null;
        if(uidx != null) { // 로그인된 사용자인 경우
            uvo = userservice.selectOne(uidx);
            System.out.println(uvo);
        }
        
        // 모델에 사용자 정보 추가
        model.addAttribute("uvo", uvo);
        
        System.out.println("UserController userform End----------------------------------------------------");
        return "/user/form";
    }
    
    /**
     * 회원 가입 처리
     * @param uvo 사용자 정보 객체
     * @param rattr 리다이렉트 속성
     * @return 리다이렉트 경로
     */
    
    //로그인 완료
    @PostMapping(value = "/user/join")
    public String userJoin(@ModelAttribute UserVO uvo, RedirectAttributes rattr) throws Exception {
        System.out.println("UserController userJoin() -------------------------------");
        System.out.println("uvo >> " + uvo);
        
        
        String maxno = userservice.maxno();
        System.out.println("UserController usermaxno() >> " + maxno );
        
        String uidx = Chaebun.getUno(maxno);
        System.out.println("uidx >> " + uidx);
        uvo.setUidx(uidx);
        // uvo.setUidx(Chaebun.getUno(maxno));
        
        
        int res = userservice.insertUser(uvo);
        System.out.println("res >> " + res);        
        System.out.println("UserController userJoin() ------------------------------");
        
        
        if(res ==1) {
           String msg = "JOIN_OK";
           
           
           rattr.addFlashAttribute("msg",msg); 
           return "redirect:/"; 
        }else {
           
        }
        return "";
    }
    
    //아이디 중복 체크    
    @PostMapping(value="user/id")
   @ResponseBody
   public String idCheck(@RequestParam String uid) throws Exception {
      System.out.println("UserController idCheck  Start----------------");
      System.out.println("UserController uid >>" + uid);
      int res =  userservice.idCheck(uid);
      return String.valueOf(res);
      
   }
    
    //회원 수정
    @PostMapping(value="/user/update")
    public String updateUser(@ModelAttribute UserVO user, RedirectAttributes rattr) throws Exception{
       System.out.println("UserController updateUser Start----------");
       System.out.println("UserController updateUser user >> " + user);
       int res = userservice.updateUser(user);
       System.out.println("UserController updateUser res >> " + res);
       String msg ="";
       if(res != 0) {
          msg = "UPDATE_CLEAR";
          rattr.addFlashAttribute("msg",msg);
          return "redirect:/";
       }
       else {
          msg = "UPDATE_ERROR";
          rattr.addFlashAttribute("msg",msg);
          return "redirect:/form";
       }
    }
    
    //전체 회원 조회(관리자)
    @GetMapping(value="/user/list")
    public String selectAll(@RequestParam(defaultValue = "1") int page,@ModelAttribute SearchCondition sc,HttpSession session,RedirectAttributes rattr, Model model)throws Exception{
       System.out.println("UserController selectAll Start-----------");
       System.out.println("UserCOntroller selectAll page >>" + page);
       int ugrade = (session.getAttribute("ugrade") == null)? 0 : (Integer)session.getAttribute("ugrade");
      System.out.println("UserController ugrade >>" + ugrade);
      if(ugrade==0) {
         String msg ="GRD_ERR";
         rattr.addFlashAttribute("msg",msg);
         return "redirect:/";
      }
      else{
         int userCnt = userservice.userCount(sc);
         PageHandler ph = new PageHandler(userCnt, sc);
         List<UserVO> uList = userservice.userSelectAll(sc);
         
         System.out.println("UserController uList >>" + uList);
         if(uList.equals(null)) {
            String msg = "LST_ERR";
            rattr.addFlashAttribute("msg",msg);
            return "redirect:/";
         }
         model.addAttribute("uList",uList);
         model.addAttribute("ph",ph);
         return "user/list";
      }
    }
    
    //회원 탈퇴
    @GetMapping(value="/user/delete")
    public String deleteUser(HttpSession session, RedirectAttributes rattr) throws Exception {
        System.out.println("UserController deleteUser Start----------------------------------------------------");    
        // 세션에서 사용자 고유번호 조회
        String uidx = (String)session.getAttribute("uidx");
        System.out.println("UserController deleteUser uidx >>" + uidx);
        
        String msg = "";
        
        // 로그인 상태인 경우에만 삭제 처리
        if(uidx != null) {
            int res = userservice.deleteUser(uidx);
            System.out.println("UserController deleteUser res >>" + res);
            
            // 삭제 결과에 따른 메시지 설정
            if(res == 1) {
                msg = "DELETE SUCCESS";
            } else {
                msg = "DELETE FAIL";
            }
        } else {
            msg ="DELETE ERROR";
        }
        
        // 처리 결과 메시지를 리다이렉트 시 전달
        rattr.addFlashAttribute("msg", msg);
        
        session.invalidate();
        
        System.out.println("UserController deleteUser End----------------------------------------------------");

        return "redirect:/";
    }
}//END CLASS