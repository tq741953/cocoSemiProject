<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Account member = (Account)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
      width : 450px;
      height : 400px;
      margin : auto;
      background-color: #343A40;
      border : none;
      border-radius: 20px;
      position : relative;
   }
   
   .bigTitle {
    text-align: center;
            font-size: 30px;
            color : white;
   }
  
          #findArea {
            width : 400px;
            height : 350px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #findForm {
      width : 390px;
      margin : auto;
      padding: 10px;
   }
   
   #findinside {
            width : 380px;
            margin : auto;
            padding-top: 20px;
   }
   
   .inputTitle {
            width : 170px;
            height : 40px;
            margin : 0px;
            padding-left : 10px;
            display : inline-block;
            background-color : rgb(141, 145, 149);
            border : lightblue;
            font-size : 13px;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .inputTitle:focus {outline:2px solid rgb(52, 58, 64);}
   
   
   
   .find_title{
            width : 100px;
            height : 40px;
            background-color: rgb(86, 88, 90);
            border : none;
            text-align: center;
            float : left;
            margin: 0px auto;
            display : inline-block;
            /*color : rgb(52, 152, 219);*/
            border-top-left-radius : 5px;
            border-bottom-left-radius: 5px;
   }
   
     .title {
   margin : auto;
   padding-top : 5px;
   text-size : 13px;
   color : white;
   }
   
   .input_area {
            width : 170px;
            height : 50px;
            
            background-color: white;
            display : inline-block;
            border : lightblue;
   }
   
   .input_area1 {
            width : 300px;
            height : 50px;
            
            background-color: white;
            display : inline-block;
            border : lightblue;
   }
   
   
   #findAll {
            width : 270px;
            height : 55px;
            text-align: center;
            margin : auto;
            border : lightblue;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .btnArea {
      width : 300px;
   	  margin : auto;
   	  padding : 10px;

   }
   
   .btn2 {
            width : 120px;
            height : 40px;
            background-color: rgb(86, 88, 90);
            border : none;
            color : white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 4px;
            margin : auto;
   }
   
      .btn1 {
            width : 100px;
            height : 40px;
            background-color: rgb(86, 88, 90);
            border : none;
            color : white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 4px;
            margin : auto;
   }
   
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="bigTitle">비밀번호 찾기</div><br>
	<div class="outer">
	<br>
		<div id="findArea">
			<form id="findForm" action="<%= request.getContextPath() %>/account/tempPwd"
			method="post" onsubmit="return Validate();">
				<h5></h5>
				<div id=findinside>
					<div id="findAll">
						<div class="find_title"><div class="title">아이디</div></div>
						<div class="input_area">
						<input type="text" class="inputTitle" maxlength="13" id="accountId" name="accountId" required>
						</div>
					</div>
					<div id="findAll">
						<div class="find_title"><div class="title">이름</div></div>
						<div class="input_area">
						<input type="text" maxlength="13" class="inputTitle" id="name" name="name" required>
						</div>
					</div>
					<div id="findAll">
						<div class="find_title"><div class="title">이메일</div></div>
						<div class="input_area">
						<input type="email"  class="inputTitle" id="email" name="email" required>
						</div>
					</div>
					
					<div class="btnArea">
						<button class="btn btn-secondary" id="findPwdBtn" type="submit">비밀번호 찾기</button><br>
						<button class="btn btn-secondary" id="goMainBtn" type="button">메인으로</button>	
						<button class="btn btn-secondary" id="goBackBtn" type="button" onclick="history.back()">뒤로가기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		// 1. 메인
		const goMainBtn = document.getElementById('goMainBtn');
		goMainBtn.addEventListener('click', function(){
			location.href='<%= request.getContextPath() %>';
		});
		
		
	
		function Validate(){
			// 이름
			if(!(/^[가-힣]{2,}$/.test($("#findForm input[name=name]").val()))){
				alert('이름은 한글로 2글자 이상 입력해주세요');
				$("#findForm input[name=name]").select();
				return false;
			}
			
			return true;
			// 이메일
			if($("#email").val().trim().length == 0){
				alert("이메일을 입력하세요");
				$("#email").focus();
				return false;
			}
			return true;
		}
			
	</script>
	
</body>
</html>