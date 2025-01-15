<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script>
let msg = '${param.msg}';
</script>

</head>
<body>
     <div class="login-container">
        <h1>차지환씨 환영합니다</h1>
        <form method="POST" action="/login" name='loginForm' onsubmit="return formCheck(this);">
            ${msg}
            <div id="msg">
                <c:choose>
                    <c:when test="${param.msg eq 'ID_ERR'}">
                        NOT USER
                    </c:when>
                    <c:when test="${param.msg eq 'PW_ERR'}">
                        WRONG PW
                    </c:when>
                </c:choose>
            </div>
            <input type="text" id="uid" name="uid" placeholder="아이디를 입력하세요" />
            <input type="password" id="upw" name="upw" placeholder="비밀번호를 입력하세요" />
            <button>로그인</button>
        </form>
    </div>
    <c:if test="${not empty errorMessage}">
    <div class="error-message">
        ${errorMessage}
    </div>
</c:if>
    <script>
        function formCheck(form) {
            /* console.log ('잘 작동됩니다!');     */     
            let msg = '';
            
            if(form.uid.value.length == 0){
                setMessage('아이디를 입력해 주세요.', form.uid);
                return false;
            }
            
            if(form.upw.value.length == 0){
                setMessage('비밀번호를 입력해 주세요.', form.upw);
                return false;
            }
            return true;
        }
        function setMessage(msg, element){
            document.getElementById('msg').innerHTML = msg;
            if(element){
                element.focus();
            }
        }
        
    </script>
	<!-- 아이디 찾기 버튼 -->
    <div class="button"><a href="/user/findId">아이디 찾기</a></div>
 
</body>
</html>