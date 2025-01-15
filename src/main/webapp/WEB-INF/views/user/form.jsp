<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script defer src="/resources/javaScript/userForm.js"></script>
<script>
   let msg = "${msg}";
   if(msg == "UPDATE_ERROR"){
      alert("회원 수정에 실패하였습니다.");
   }
  </script>
<title>form</title>
</head>
<body>
<div class="formContainer">
   <h1><c:out value="${uvo eq null ? '회원가입':'마이페이지' }"></c:out></h1>
   <form name="userForm">
      <!-- 로그인 되어있을 시, 회원 채번 불러오기  -->
       <input type="hidden" name="uidx" value="${uvo eq null?'':uvo.getUidx()}"/>   
      <!--名前入力欄 이름입력란  -->
      <input type="text" name="uname" id="uname" placeholder="이름을 입력해주세요." value="${uvo eq null? '':uvo.getUname()}"/><br>
      <!-- id入力欄 아이디입력란 -->
      <input type="text" name="uid" id="uid" placeholder="아이디를 입력해주세요." value="${uvo eq null? '':uvo.getUid() }" ${uvo ne null? 'readonly':''}/><br>
      <!--id中複確認 아이디 중복확인  -->
      <c:if test = "${uvo eq null}">
      <input type="button" class="check-button" value="아이디 중복확인" onclick="idCheck()"/>
      <!-- 기본값을 0으로 받아온 히든값 idCheck가 활성화 되면 값을 1로 바꾸고 이곳의 값이 1이여야 submitBtn을 누를 수 있도록 -->
      <input type="hidden" name="idChk" id="idChk" value="${uvo eq null? '0' : '1' }"/><br>
      </c:if>
      <!-- パスワード入社欄 비밀번호 입력란 -->
      <input type="password" name="upw" id="upw" placeholder="비밀번호를 입력해주세요" /><br>
      <!--電話番号入力欄 전화번호 입력란 -->
      <input type="text" name="uphone" id="uphone" placeholder="&quot;-&quot;를 제외한 전화번호를 입력해주세요. "/>            
      <!-- 生年月日入力欄  -->
      <p>생년월일</p>
      <input type="date" name="ubirth" id="ubirth"/><br>
      <!-- kakao map apiを利用して郵便番号を受ける 카카오api이용 우편번호 받아옴-->
      <input type="text" name="upost" id="upost" readOnly/>
      <!-- 카카오맵 api활성화로 주소검색창 열림 -->
      <input type="button" class="check-button" value="주소찾기" onclick = "postSearch()"/><br>
      <!-- api에서 도로명주소를 받아옴 -->
      <input type="text" name="uaddress" id="uaddress" readOnly/><br>
      <!-- 상세주소(api에서 받아오지 않는 부분) -->
      <input type="text" name="uaddressd" id="uaddressd" placeholder="상세주소를 입력해주세요"/><br>
      <!--이메일  -->
      <input type="text" name="uemail" id="uemail" placeholder="이메일을 입력해주세요"/><br>
      <!--가입 확인 버튼  -->
      <c:choose>
         <c:when test ="${uvo eq null}">
            <div class="submitBtn"><a href="javascript:userSubmit();">가입</a></div>
         </c:when>
           <c:otherwise>
            <div class="button"><a href="javascript:userUpdate();">수정</a></div>
            
            <!-- 탈퇴 버튼 -->
            <div class="button"><a href="javascript:deleteUser();">회원 탈퇴</a></div>
         
         </c:otherwise>
      </c:choose>
   </form>
</div>
   
</body>
</html>