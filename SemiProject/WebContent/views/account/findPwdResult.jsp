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
   
   .title{
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
	
	<div class="bigTitle">비밀번호 찾기 결과</div><br>
	<div class="outer">
	<br>
		<div id="findArea">
			
			<form id="findForm" action="<%= request.getContextPath() %>/account/login"
			method="post" onsubmit="return Validate();">
				<div id=findinside>
				<% if(member != null) { %>
					<div id="findAll">
						<div class="title">임시 비밀번호가 발급되었습니다.<br>
						확인하고 로그인해주세요.</div>
					</div>
					
				<% } else { %>
					<div id="findAll">
						<div class="title">등록된 정보를 찾을 수 없습니다.<br>
						다시 확인해 주세요.</div>
					</div>
				<% } %>	
					<div class="btnArea">
						<button class="btn btn-secondary" id="goLoginBtn" type="button">로그인</button>
						<button class="btn btn-secondary" id="goBackBtn" type="button" onclick="history.back()">다시찾기</button>	
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		// 로그인 버튼 이벤트
		const goLoginBtn = document.getElementById('goLoginBtn');
		goLoginBtn.addEventListener('click', function(){
			location.href='<%= request.getContextPath() %>/views/account/loginForm.jsp';
		});
		

		
	</script>
</body>
</html>