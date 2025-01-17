package com.kmove.app.User.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kmove.app.User.vo.SearchCondition;
import com.kmove.app.User.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession session;
	private String namespace ="com.kmove.app.mapper.UserMapper." ;
	
	@Override
	public int insertUser(UserVO uvo) throws Exception {
		System.out.println("UserDAO insertUser Start----------------------------------------------------");
		System.out.println("UserDAO insertUser uvo >>" + uvo);
		int res = session.insert(namespace+ "selectInsert", uvo);  
		System.out.println("UserDAO insertUser res >>" + res);
		System.out.println("UserDAO insertUser End------------------------------------------------------");
		
		return res;
	}
	
	@Override
	public List<UserVO> userSelectAll(SearchCondition sc) throws Exception {
		System.out.println("UserDAO userSelectAll Start----------------------------------------------------");
		System.out.println("UserDAO userSelectAll sc >>" + sc);
	    List<UserVO> uList = session.selectList(namespace+ "userSelectAll",sc);
	    System.out.println("UserDAO userSelectAll uList >>" + uList);
		System.out.println("UserDAO userSelectAll End----------------------------------------------------");

		return uList;
	}
	
	@Override
	public UserVO selectOne(String uidx) throws Exception {		
		System.out.println("UserDAO selectOne Start----------------------------------------------------");
		System.out.println("UserDAO selectOne uidx >>" + uidx);
		UserVO uvo = session.selectOne(namespace+ "selectOne", uidx);  
	    System.out.println("UserDAO selectOne res >>" + uvo);
		System.out.println("UserDAO selectOne End----------------------------------------------------");

		return uvo;
	}
	
	@Override
	public int updateUser(UserVO uvo) throws Exception {
		System.out.println("UserDAO updateUser Start----------------------------------------------------");
		System.out.println("UserDAO updateUser uvo >>" + uvo);
		int res = session.update(namespace+ "updateUser", uvo);  
		System.out.println("UserDAO updateUser res >>" + res);
		System.out.println("UserDAO updateUser End----------------------------------------------------");

		return res;
	}
	@Override
	public int deleteUser(String uidx) throws Exception {
		System.out.println("UserDAO deleteUser Start----------------------------------------------------");
		System.out.println("UserDAO deleteUser uidx >>" + uidx);
		int res = session.update(namespace+ "deleteUser", uidx);
		System.out.println("UserDAO deleteUser res >>" + res);
		System.out.println("UserDAO deleteUser End----------------------------------------------------");

		return res;
	}
	@Override
	public int userCount(SearchCondition sc) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int idCheck(String uid) throws Exception {
		System.out.println("UserDAO idCheck Start----------------------------------------------------");
		System.out.println("UserDAO idChec uid >>" + uid);
		int res = session.selectOne(namespace+ "idCheck", uid);
		System.out.println("UserDAO idChec res >>" + res);
		System.out.println("UserDAO idCheck End----------------------------------------------------");

		return res;
	}
	@Override
	public String userUidx(String uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String maxno() throws Exception {
		System.out.println("UserDAO maxno() -------------------------");
		String maxno = String.valueOf(session.selectOne(namespace+"maxno"));		
		System.out.println("UserDAO maxno >> " + maxno);
		System.out.println("UserDAO maxno() --------------------------------");
		return maxno;
	}

	@Override
	public UserVO loginCheck(String uid) throws Exception {
	    System.out.println("UserDAO loginCheck Start----------------------------------------------------");
	    System.out.println("UserDAO loginCheck uid >>" + uid);
	    UserVO uvo = session.selectOne(namespace + "loginCheck", uid);  // namespace와 매퍼 ID 추가, 파라미터 전달
	    System.out.println("UserDAO loginCheck uvo >>" + uvo);
	    System.out.println("UserDAO loginCheck End----------------------------------------------------");
	    
	    return uvo;
	}

	@Override	
	public String findUserId(String uemail) throws Exception {
        System.out.println("UserDAO findUserId Start----------------------------------------------------");
        System.out.println("UserDAO findUserId parameter >>" + uemail);       
        String uem = session.selectOne(namespace + "findUserId", uemail);          
        System.out.println("UserDAO findUserId result >>" + uem);
        System.out.println("UserDAO findUserId End----------------------------------------------------");
        
        return uem;
	}
}
