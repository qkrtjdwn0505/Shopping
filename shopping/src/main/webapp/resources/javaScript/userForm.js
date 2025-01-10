
console.log("dd");

function postSearch(){ //카카오api 주소찾기
   new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
          
            console.log(data.zonecode);
            document.getElementById('upost').value = data.zonecode;
            document.getElementById('uaddress').value = data.roadAddress;
        }
    }).open();
 } // END OF POSTSEARCH
 
 
function idCheck(){ // 아이디 중복 확인
    let uid = $("#uid").val(); 
    let idChecked = $("#idChk").val();    
    //idChecked.value='1';
    //$("#idCheck").val('1');
    
    
    console.log("아이디 값 확인:", uid); // uid 값이 제대로 출력되는지 확인

    if (uid == '') {
        alert("아이디를 입력해주세요.");
        return false;
    }

    $.ajax({
        url: '/user/id', // 요청 URL
        data: { uid: uid }, // 데이터 객체 전달
        type: 'POST', 
        success: function (result) {
            if (result == 0) { 
                alert("사용 가능한 아이디입니다.");
               $("#idChk").val('1');
                console.log($("#idChk").val());
                // 아이디 중복이 아닌 경우 회원가입 가능하도록 버튼 활성화
            } else { 
                alert("중복된 아이디입니다.");
                console.log($("#idChk").val());
            }
        },
        error: function (error) {
            console.error(error);
            alert("서버 요청 중 에러가 발생했습니다.");
        }
    });
}

/**function userSubmit(){
*   
*    let uid = $("#uid").val();
*    if (!uid) {
*        alert("아이디를 입력해주세요.");
*        return;
*    }
*    
}*/



//회원가입 버튼
function userSubmit(){
   let idChecked = document.getElementById('idChk').value;
   if(idCheck != 1){
      alert("아이디중복확인을 해주세요");
      return false;
   }
   
   document.userForm.method = 'POST';
   document.userForm.action = '/user/join';
   document.userForm.submit();
}

//회원수정 버튼
function userUpdate(){

   document.userForm.method = 'POST';
   document.userForm.action = '/user/update';
   document.userForm.submit();
}

function deleteUser(){
   document.userForm.method = 'GET';
   document.userForm.action = '/user/delete';
   document.userForm.submit();
}