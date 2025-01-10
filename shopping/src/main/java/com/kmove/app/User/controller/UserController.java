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
 * ����� ������ ���� ��Ʈ�ѷ� Ŭ����
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userservice;
    
    /**
     * ���� �������� �̵�
     * @return ���� ������ �� �̸�
     */
    @RequestMapping(value = "/")
    public String main() {
        return "index";
    }
    
    /**
     * ȸ�� ����/���� ���� �����ִ� �޼���
     * �α��ε� ������� ��� ���� ������ ���� ǥ��
     * @param session HTTP ����
     * @param model Spring Model ��ü
     * @return ȸ�� �� �� �̸�
     */
    
    //ȸ������
    @RequestMapping(value = "/form")
    public String insertUser(HttpSession session, Model model) throws Exception {
        System.out.println("UserController userform Start----------------------------------------------------");
        
        // ���ǿ��� ����� ID ��������
        String uidx = (String)session.getAttribute("uidx");
        System.out.println(uidx);
        
        // ����� ���� ��ȸ
        UserVO uvo = null;
        if(uidx != null) { // �α��ε� ������� ���
            uvo = userservice.selectOne(uidx);
            System.out.println(uvo);
        }
        
        // �𵨿� ����� ���� �߰�
        model.addAttribute("uvo", uvo);
        
        System.out.println("UserController userform End----------------------------------------------------");
        return "/user/form";
    }
    
    /**
     * ȸ�� ���� ó��
     * @param uvo ����� ���� ��ü
     * @param rattr �����̷�Ʈ �Ӽ�
     * @return �����̷�Ʈ ���
     */
    
    //�α��� �Ϸ�
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
    
    //���̵� �ߺ� üũ    
    @PostMapping(value="user/id")
   @ResponseBody
   public String idCheck(@RequestParam String uid) throws Exception {
      System.out.println("UserController idCheck  Start----------------");
      System.out.println("UserController uid >>" + uid);
      int res =  userservice.idCheck(uid);
      return String.valueOf(res);
      
   }
    
    //ȸ�� ����
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
    
    //��ü ȸ�� ��ȸ(������)
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
    
    //ȸ�� Ż��
    @GetMapping(value="/user/delete")
    public String deleteUser(HttpSession session, RedirectAttributes rattr) throws Exception {
        System.out.println("UserController deleteUser Start----------------------------------------------------");    
        // ���ǿ��� ����� ������ȣ ��ȸ
        String uidx = (String)session.getAttribute("uidx");
        System.out.println("UserController deleteUser uidx >>" + uidx);
        
        String msg = "";
        
        // �α��� ������ ��쿡�� ���� ó��
        if(uidx != null) {
            int res = userservice.deleteUser(uidx);
            System.out.println("UserController deleteUser res >>" + res);
            
            // ���� ����� ���� �޽��� ����
            if(res == 1) {
                msg = "DELETE SUCCESS";
            } else {
                msg = "DELETE FAIL";
            }
        } else {
            msg ="DELETE ERROR";
        }
        
        // ó�� ��� �޽����� �����̷�Ʈ �� ����
        rattr.addFlashAttribute("msg", msg);
        
        session.invalidate();
        
        System.out.println("UserController deleteUser End----------------------------------------------------");

        return "redirect:/";
        //fuckkkkkhgdhdtyd
    }
}//END CLASS