<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
      width : 550px;
      height : 200px;
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
   
      .secondTitle {
      text-align : center;
      font-size : 23px;
      font-weight : bold;
   }
  
          #joinArea {
            width : 500px;
            height : 150px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #joinForm {
      width : 480px;
      margin: auto;
      padding: 10px;
   }
   
   #joininside {
            width : 440px;
            height : 70px;
            margin: 0px auto;
            padding-top: 20px;
            border-radius: 20px;
            text-align: center;
   }
   
   .join_title{
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
   
   .btnArea {
   	  width : 160px;
   	  height : 70px;
      text-align:center;
      margin : auto;
      display : inline-block;
   }
   
    .btn:hover {
    background:#343A40;
   }
   
   button {
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
	<div class="bigTitle">회원가입</div><br>
	<div class="outer">
	<br>
		<div id="joinArea">
			<form id="joinForm" action="<%= request.getContextPath() %>/account/insert"
			method="post" onsubmit="return joinValidate();">
				<div class="secondTitle">원하시는 회원가입 형태를 선택하세요</div>
				<div id=joininside>
					<div class="btnArea">
						<button class="btn btn-secondary" id="btn1" type="button">일반회원</button>
					</div>
					<div class="btnArea">
						<button class="btn btn-secondary" id="btn2" type="button">기업회원</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script>
		// 1. 일반회원 버튼 클릭 시
		const btn1 = document.getElementById('btn1');
		btn1.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/views/account/memberJoinForm1.jsp";
		});
		
		// 2. 기업회원 버튼 클릭 시
		const btn2 = document.getElementById('btn2');
		btn2.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/views/account/memberJoinForm2.jsp";
		});
	

	</script>
</body>
</html>