<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% if(request.getAttribute("result") != null) { 
	if(request.getAttribute("result").equals("success")) {
%>
<script>
	alert("성공적으로 비밀번호를 변경하였습니다.");
	window.close();
</script>
<% } else { %>
<script>
	alert("비밀번호 변경에 실패하였습니다. 현재 비밀번호를 확인해주세요.");
</script>
<%
	}
}
%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
	.outer{
      width : 450px;
      height : 350px;
      margin : auto;
      background-color: #343A40;
      border : none;
      border-radius: 20px;
      position : relative;
   }
   
   .bigTitle {
   	font-size : 25px;
    text-align: center;
    font-weight : bold;
    color : #343A40;
   }
  
          #changePwdArea {
            width : 400px;
            height : 290px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #updatePwdForm {
      width : 380px;
      margin: auto;
   }
   
   #changeInfoInside {
            width : 320px;
            margin : auto;
            padding-top: 20px;
   }
   
   .inputText {
            width : 170px;
            height : 40px;
            margin : 0px;
            padding-left : 10px;
            display : inline-block;
            font-size : 13px;
            background-color : rgb(141, 145, 149);
            border : lightblue;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .inputText:focus {outline:2px solid rgb(52, 58, 64);}
   
   
   
   .info_title{
            width : 140px;
            height : 40px;
            background-color: rgb(86, 88, 90);
            border : none;
            text-align: center;
            float : left;
            margin: 0px auto;
            display : inline-block;
            color : rgb(52, 152, 219);
            border-top-left-radius : 5px;
            border-bottom-left-radius: 5px;
   }
   
   .title {
   margin : auto;
   padding-top : 5px;
   font-size : 13px;
   color : white;
   }
   .input_area {
            width : 170px;
            height : 40px;
            
            background-color: white;
            display : inline-block;
            border : lightblue;
   }
  
   
   .pwdAll {
            width : 310px;
            height : 55px;
            text-align: center;
            border : lightblue;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .btnArea {
      text-align:center;
      padding : 20px;
   }

</style>
</head>
<body>
	<br><div class="bigTitle">비밀번호 변경</div><br>
	<div class="outer"><br>
		<div id="changePwdArea">
			<form id="updatePwdForm" action="<%= request.getContextPath() %>/account/updatePwd" 
			method="post" onsubmit="return checkPwd();">
			<div id="changeInfoInside">
				<div class="pwdAll">
					<div class="info_title"><div class="title">현재 비밀번호</div></div>
					<div class="input_area">
					<input type="password" class="inputText" name="password" id="password" maxlength="15">
					</div>
				</div>
				<div class="pwdAll">
					<div class="info_title"><div class="title">새로운 비밀번호</div></div>
					<div class="input_area">
					<input type="password" class="inputText" name="newPassword" id="newPassword" maxlength="15">
					</div>
				</div>
				<div class="pwdAll">
					<div class="info_title"><div class="title">새로운 비밀번호 확인</div></div>
					<div class="input_area">
					<input type="password" class="inputText" name="newPassword2" id="newPassword2" maxlength="15">
					</div>
				</div>
				<div class="btnArea">
				<button class="btn btn-secondary" id="updatePwdBtn">변경하기</button>
				</div>
			</div>
			</form>
		</div>
	</div>
			
	<script>
		function checkPwd(){
			let password = document.getElementById('password');
			let newPassword = document.getElementById('newPassword');
			let newPassword2 = document.getElementById('newPassword2');
			
			if(password.value == "" || newPassword.value == "" || newPassword2.value == ""){
				alert("비밀번호를 모두 입력해주세요");
				return false;
			}
			
			if(newPassword.value != newPassword2.value){
				alert("비밀번호가 다릅니다. 다시 확인해주세요.");
				newPassword2.select();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>