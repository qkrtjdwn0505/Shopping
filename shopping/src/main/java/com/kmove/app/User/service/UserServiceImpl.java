package com.kmove.app.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmove.app.User.dao.UserDAO;
import com.kmove.app.User.vo.SearchCondition;
import com.kmove.app.User.vo.UserVO;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userdao;
	
	@Override
	public int insertUser(UserVO uvo) throws Exception {

		System.out.println("UserService insertUser Start----------------------------------------------------");
		System.out.println("UserService insertUser uvo >>" + uvo);
		int res = userdao.insertUser(uvo);
		System.out.println("UserService insertUser res >>" + res);
		System.out.println("UserService insertUser End----------------------------------------------------");

		return res;
	}

	@Override
	public List<UserVO> userSelectAll(SearchCondition sc) throws Exception {
		System.out.println("UserService userSelectAll Start----------------------------------------------------");
		System.out.println("UserService userSelectAll sc >>" + sc);
	    List<UserVO> uList = userdao.userSelectAll(sc);
	    System.out.println("UserService userSelectAll uList >>" + uList);
		System.out.println("UserService userSelectAll End----------------------------------------------------");

		return uList;
	}

	@Override
	public UserVO selectOne(String uidx) throws Exception {
		System.out.println("UserService selectOne Start----------------------------------------------------");
		System.out.println("UserService selectOne uidx >>" + uidx);
		UserVO uvo = userdao.selectOne(uidx);
		System.out.println("UserService selectOne uvo >>" + uvo);
		System.out.println("UserService selectOne End----------------------------------------------------");

		return uvo;
	}

	@Override
	public int updateUser(UserVO uvo) throws Exception {
		System.out.println("UserService updateUser Start----------------------------------------------------");
		System.out.println("UserService updateUser uvo >>" + uvo);
		int res = userdao.updateUser(uvo);
		System.out.println("UserService updateUser res >>" + res);
		System.out.println("UserService updateUser End----------------------------------------------------");

		return res;
	}

	@Override
	public int deleteUser(String uidx) throws Exception {
		System.out.println("UserService deleteUser Start----------------------------------------------------");
		System.out.println("UserService deleteUser uidx >>" + uidx);
		int res = userdao.deleteUser(uidx);
		System.out.println("UserService deleteUser res >>" + res);
		System.out.println("UserService deleteUser End----------------------------------------------------");

		return res;
	}

	@Override
	public int userCount(SearchCondition sc) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(String uid) throws Exception {
	    System.out.println("UserService idCheck Start----------------------------------------------------");
	    System.out.println("UserService idCheck uid >>" + uid);
	    int res = userdao.idCheck(uid);
	    System.out.println("UserService idCheck res >>" + res);
	    System.out.println("UserService idCheck End----------------------------------------------------");

	    return res;
	}

	@Override
	public String userUidx(String uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String maxno() throws Exception {
		System.out.println("UserService maxno() Start----------------------------------------------------");	
		String maxno = userdao.maxno();
		System.out.println("Service maxno >> " + maxno);		
		System.out.println("UserService maxno() End----------------------------------------------------");
		
		return maxno;
	}

	@Override
	public UserVO loginCheck(String uid) throws Exception{
		System.out.println("UserService loginCheck Start----------------------------------------------------");	
		System.out.println("UserService loginCheck uid >>" + uid);
		UserVO uvo = userdao.loginCheck(uid);
		System.out.println("UserService loginCheck uvo >>" + uvo);
		System.out.println("UserService loginCheck End----------------------------------------------------");	

		return uvo;
	}

}
