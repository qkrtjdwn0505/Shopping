<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<title>아이디 찾기</title>
</head>
<body>
	 <div class="container">
	    <div class="findId">
	        <form action="/user/findId" method="post"> 
	            <div class="title">
	                <h3>아이디 찾기</h3>
	            </div>
	            <div class="form-content">
	                <p>
	                    <label>Email</label>
	                    <input type="text" id="uemail" name="uemail" placeholder="이메일을 입력하세요" required>
	                </p>
	                <p class="button-group">
	                    <button type="submit" id="findBtn">아이디 찾기</button>
	                    <button type="button" onclick="history.go(-1);">취소</button>
	                </p>
	            </div>
	        </form>
	        
	        <!-- 아이디 찾기 결과 표시 -->
	        <c:if test="${not empty id}">
	            <div class="result-message">
	                찾으시는 아이디는 ${id} 입니다.
	                <p class="login-link">
	                    <a href="/login" class="btn-login">로그인 페이지로 이동</a>
	                </p>
	            </div>
	        </c:if>
	    </div>
	</div>



</body>
</html>