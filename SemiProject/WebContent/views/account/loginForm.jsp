<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
      width : 450px;
      height : 400px;
      margin : auto;
      background-color: #343A40;
      border : none;
      padding-top : 20px;
      border-radius: 20px;
      position : relative;
   }
   
   .bigTitle {
    text-align: center;
    font-size: 30px;
    color : white;
   }
  
          #loginArea {
            width : 400px;
            height : 350px;
            margin : auto;
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #loginForm {
      width : 380px;
      margin-top : 30px;
      margin: auto;
      padding: 10px;
   }
   
   #logininside {
            width : 250px;
            margin : auto;
            padding-top: 20px;
   }
   
   #accountId, #password {
            width : 150px;
            height : 40px;
            margin : opx;
            padding-left : 10px;
            font-size : 13px;
            background-color : rgb(141, 145, 149);
            border : lightblue;
            font-size : 13px;
            display : inline-block;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   #accountId:focus {outline:2px solid rgb(52, 58, 64);}
   #password:focus {outline:2px solid rgb(52, 58, 64);}
   
   .login_title{
            width : 100px;
            height : 40px;
            background-color: rgb(86, 88, 90);
            border : none;
            text-align: center;
            text-size : 13px;
            float : left;
            margin: 0px auto;
            display : inline-block;
            color : white;
            /*color : rgb(52, 152, 219);*/
            border-top-left-radius : 5px;
            border-bottom-left-radius: 5px;
   }
   
   #h4_id, #h4_pwd {
            color : white;
            margin-block-start: 0.5em;
            padding : 0;
   }

   
   .input_area {
            width : 150px;
            height : 50px;
            
            background-color: white;
            display : inline-block;
            border : lightblue;
   }
   
   .loginIdPwd {
            width : 250px;
            height : 55px;
            text-align: center;
            border : lightblue;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
      .title {
   margin : auto;
   padding-top : 5px;
   text-size : 13px;
   color : white;
   }
   
   .btnArea {
      text-align:center;
      padding : 5px;
   }
   
      .btn2 {
            width : 100px;
            height : 30px;
            background-color: rgb(141, 145, 149);
            border : none;
            color : white;
            font-size: 14px;
            font-weight: bold;
            border-radius: 4px;
            margin : auto;
   }
   
   #userInfo1 {
   		width : 300px;
   		height : 150px;
   		float : right;
   		margin : auto;
   }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<script>

	$(".loginArea").hide();

	</script>
	<div class="bigTitle">?????????</div><br>
	<div class="outer">
		<div id="loginArea">
			<% if(loginUser == null) { %>
				<form id="loginForm" action="<%= request.getContextPath() %>/account/login" 
				method="post" onsubmit="return validate();">
					
					<div id="logininside">
						<div class="loginIdPwd">
							<div class="login_title"><div class="title">?????????</div></div>
							<div class="input_area">
							<input type="text" name="accountId" id="accountId" placeholder="ID">
							</div>
						</div>
						<div class="loginIdPwd">
							<div class="login_title"><div class="title">????????????</div></div>
							<div class="input_area">
							<input type="password" name="password" id="password" placeholder="Password">
							</div>
						</div>
						<div class="btnArea">
						<button class="btn btn-secondary" id="loginBtn" type="submit">?????????</button>
						</div>
							<button class="btn2" id="findId" type="button">ID ??????</button>
							<button class="btn2" id="findPwd" type="button">PWD ??????</button>
						<div class="btnArea">
							<button class="btn btn-secondary" id="joinBtn" type="button">????????????</button>
						</div>
					</div>
				</form>
					

		<script>
			function validate(){
				if($("#accountId").val().trim().length == 0){
					alert("???????????? ???????????????");
					$("#accountId").focus();
					return false;
				}
				if($("#password").val().trim().length == 0){
					alert("??????????????? ???????????????");
					$("#password").focus();
					return false;
				}
				return true;
			}
			
			// ?????? ?????? ???
			const joinBtn = document.getElementById('joinBtn');
			joinBtn.addEventListener('click', function(){
				location.href="<%= request.getContextPath() %>/views/account/memberJoinForm.jsp";
			});
			
			// ??????????????? ???
			const findId = document.getElementById('findId');
			findId.addEventListener('click',function(){
				location.href="<%= request.getContextPath() %>/views/account/findIdForm.jsp";
			})
			
			// ???????????? ?????? ??????
			const findPwd = document.getElementById('findPwd');
			findPwd.addEventListener('click',function(){
				location.href="<%= request.getContextPath() %>/views/account/findPwdForm.jsp";
			})
			
		</script>
			<% } %>
		</div>
	</div>
</body>
</html>