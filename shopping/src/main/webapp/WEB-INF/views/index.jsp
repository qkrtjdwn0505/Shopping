<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<html>
<head>
   <title>Shop</title>
   <script>
   let msg ="${msg}";
   if(msg == "UPDATE_CLEAR"){
      alert("회원 수정되었습니다.");
   }
   if(msg == "DELETE SUCCESS"){
      alert("회원 탈퇴되었습니다.");
   }
   if(msg == "DELETE FAIL"){
      alert("회원 탈퇴에 실패하였습니다.");
   }
   if(msg == "DELETE ERROR"){
      alert("회원 탈퇴에 에러가 발생하였습니다.");
   }
   </script>
</head>
<body>

   <div id = "body_layout">
      <div class = "mid" id="welcome">어서오세요.</div>
      <div>
         <c:set var="loginId" value="${sessionScope eq null ? '': sessionScope.uid}">
         </c:set>
         <c:set var="loginOutLink" value="${loginId eq null ? '/login' :'/logout'}">
         </c:set>
         <c:set var="loginOut" value="${loginId eq null ? '로그인':'로그아웃'}">
         </c:set>
         <c:set var="user" value="${loginId eq null ? '/form':'/form' }"/>
         <c:set var="form" value="${loginId eq null ? '회원가입':'마이페이지'}">
         </c:set>
         <div class = "image">
            <div class="select">
               <a class="a1" href="${user }" value="${form }" >${form}</a>
               <a class="a2" href="${loginOutLink }" value="${loginOut }" >${loginOut}</a>      
            </div>
         ${ugrade }
         ${uname }
         </div>
      </div>
   </div>
   
   
</body>
</html>