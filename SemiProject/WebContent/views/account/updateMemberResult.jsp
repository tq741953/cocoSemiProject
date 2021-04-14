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
  
          #updateMemberArea {
            width : 400px;
            height : 300px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #updateMemberForm {
      width : 380px;
      margin: auto;
      padding: 10px;
   }
   
   #updateMemberinside {
            width : 350px;
            margin : auto;
            padding-top: 20px;
   }
   
   
   .title {
            color : rgb(86, 88, 90);
            margin-block-start: 0.5em;
            padding : 0;
            text-align : center;
   }

   
   .updateMemberAll {
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
	
	<div class="bigTitle">회원정보 수정 실패</div><br>
	<div class="outer">
	<br>
		<div id="updateMemberArea">
			
			<form id="updateMemberForm" action="<%= request.getContextPath() %>/account/login"
			method="post" onsubmit="return Validate();">
				<div id=updateMemberinside>
					<div id="updateMemberAll">
						회원정보 수정에 실패하였습니다. 다시 확인해주세요.
					</div>	
					<div class="btnArea">
						<button class="btn btn-secondary" id="goBackBtn" type="button" onclick="history.back()">뒤로가기</button>	
					</div>
				</div>
			</form>
		</div>

	</div>
	
</body>
</html>