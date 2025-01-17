package com.kmove.app.User.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.kmove.app.User.vo.SearchCondition;
import com.kmove.app.User.vo.UserVO;

public interface UserService {
	
	public int insertUser(UserVO uvo) throws Exception; //회원 가입
	public List<UserVO> userSelectAll(SearchCondition sc) throws Exception; //정보 전체 목록								
	public UserVO selectOne(String uidx) throws Exception;//개인 정보 열람								
	public int updateUser(UserVO uvo) throws Exception; //회원수정								
	public int deleteUser(String uidx) throws Exception; //회원탈퇴								
	public int userCount(SearchCondition sc) throws Exception; //유저수 세기								
	public int idCheck(String uid) throws Exception; //아이디 중복 체크								
	public String userUidx(String uid) throws Exception; //유저 채번	
	public String maxno() throws Exception;
	public UserVO loginCheck(String uid) throws Exception;
	public String findUserId(HttpServletResponse response, String uemail) throws Exception;

}
