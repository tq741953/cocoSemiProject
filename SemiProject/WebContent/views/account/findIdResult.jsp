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
      height : 350px;
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
            height : 300px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #findForm {
      width : 380px;
      margin: auto;
      padding: 10px;
   }
   
   #findinside {
            width : 350px;
            margin : auto;
            padding-top: 20px;
   }
   
   .find_title{
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
            color : rgb(86, 88, 90);
            margin-block-start: 0.5em;
            padding : 0;
            text-align : center;
   }

   
   .findAll {
            width : 255px;
            height : 55px;
            text-align: center;
            color : rgb(86, 88, 90);
            border : lightgray;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .btnArea {
      text-align:center;
      padding : 50px;
   }
   
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="bigTitle">아이디 찾기 결과</div><br>
	<div class="outer">
	<br>
		<div id="findArea">
			
			<form id="findForm" action="<%= request.getContextPath() %>/account/login"
			method="post" onsubmit="return Validate();">
				<div id=findinside>
				<% if(member != null) { %>
					<div id="findAll">
						<div class="title"><%= member.getName() %> 님의 아이디는 <br>
						<%= member.getAccountId() %> 입니다.</div>
					</div>
				<% } else { %>
					<div id="findAll">
						<div class="title">등록된 정보를 찾을 수 없습니다.<br>
						다시 확인해 주세요.</div>
					</div>
				<% } %>		
					<div class="btnArea">
						<button class="btn btn-secondary" id="goLoginBtn" type="button">로그인</button>	
					</div>
				</div>
			</form>
		</div>
		<script>
			const goLoginBtn = document.getElementById("goLoginBtn");
			goLoginBtn.addEventListener('click', function(){
				location.href="<%= request.getContextPath()%>/views/account/loginForm.jsp";
			});
		</script>
	</div>
	
</body>
</html>