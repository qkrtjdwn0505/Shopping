package com.kmove.app.User.dao;

import java.util.List;

import com.kmove.app.User.vo.SearchCondition;
import com.kmove.app.User.vo.UserVO;

public interface UserDAO {
		
	public int insertUser(UserVO uvo) throws Exception; //ȸ�� ����
	public List<UserVO> userSelectAll(SearchCondition sc) throws Exception; //���� ��ü ���								
	public UserVO selectOne(String uidx) throws Exception;//���� ���� ����								
	public int updateUser(UserVO uvo) throws Exception; //ȸ������								
	public int deleteUser(String uidx) throws Exception; //ȸ��Ż��								
	public int userCount(SearchCondition sc) throws Exception; //������ ����								
	public int idCheck(String uid) throws Exception; //���̵� �ߺ� üũ								
	public String userUidx(String uid) throws Exception; //���� ä��								
	public String maxno() throws Exception;
	public UserVO loginCheck(String uid)throws Exception;
	public String findUserId(String uemail)throws Exception;
	
}
