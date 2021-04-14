<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="account.model.vo.*, java.util.*"%>
<%
	Account m = (Account)session.getAttribute("loginUser");
	
	String accountId = m.getAccountId();
	String name = m.getName();
	String email = (m.getEmail() != null) ? m.getEmail() : "";
	String phone = (m.getPhone() != null) ? m.getPhone() : "";
	String bLicense = (m.getbLicense() != null) ? m.getbLicense() : "";
	int auth = m.getAuth();
	int emailAuth = m.getEmailAuth();
	
	ArrayList<BusinessLicensePhoto> fileList = (ArrayList<BusinessLicensePhoto>)request.getAttribute("fileList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
      width : 550px;
      height : 500px;
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
  
          #accountInfoArea {
            width : 500px;
            height : 450px;
            margin : auto;
           
            background-color: white;
            border : none;
            border-radius: 20px;
        }
   
   #updateForm {
      width : 480px;
      margin: auto;
      padding: 10px;
   }
   
   #accountInfoInside {
            width : 470px;
            margin : auto;
            padding-top: 20px;
   }
   
   .inputText {
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
   
   .input_area {
            width : 170px;
            height : 50px;
            float : left;
            background-color: white;
            display : inline-block;
            border : lightblue;
   }
   
   .input_area1 {
            width : 170px;
            height : 50px;
            float : left;
            background-color: white;
            display : inline;
            border : lightblue;
   }
   
   .title {
   margin : auto;
   padding-top : 5px;
   text-size : 13px;
   color : white;
   }
   
   #accountAll {
            width : 320px;
            height : 55px;
            margin : auto;
            border : lightblue;
            border-top-right-radius : 5px;
            border-bottom-right-radius: 5px;
   }
   
   .btnArea {
   	  width : 400px;
      margin : auto;
   }

   
   #pwdUpdateBtn {
   width : 170px;
    height : 40px;
            background-color: rgb(141, 145, 149);
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
	<div class="bigTitle">회원 정보 수정</div><br>
	<div class="outer">
	<br>
		<div id="accountInfoArea">
			<form id="updateForm" action="<%= request.getContextPath() %>/account/update" method="post">
				<div id="accountInfoInside">
					<div id="accountAll">
						<div class="info_title"><div class="title">아이디</div></div>
						<div class="input_area">
						<input type="text" maxlength="13" class="inputText" name="accountId" value="<%= accountId %>" readonly>
						</div>
					</div>
					<div id="accountAll">
						<div class="info_title"><div class="title">비밀번호</div></div>
						<div class="input_area1">
						<button id="pwdUpdateBtn" type="button">비밀번호 변경</button>
						</div>
					</div>
					<div id="accountAll">
						<div class="info_title"><div class="title">이름</div></div>
						<div class="input_area">
						<input type="text" maxlength="5" class="inputText" name="name" value="<%= name %>" required>
						</div>
					</div>
					<div id="accountAll">
						<div class="info_title"><div class="title">연락처</div></div>
						<div class="input_area">
						<input type="tel" maxlength="11" class="inputText" name="changephone" value="<%= phone %>">
						</div>
					</div>
					<div id="accountAll">
						<div class="info_title"><div class="title">이메일</div></div>
						<div class="input_area">
						<input type="email" class="inputText"  name="email" value="<%= email %>">
						</div>
					</div>
					<% if(loginUser.getAuth() == 2) { %>
					<div id="accountAll">
						<div class="info_title"><div class="title">사업자 번호</div></div>
						<div class="input_area">
						<input type="text" maxlength="12" class="inputText" id="bLicense" name="bLicense" value="<%= bLicense %>" readonly>
						</div>
					</div>
					<% } %>
					
					<div class="btnArea">
						<%if(loginUser.getAuth() == 1) { %>
						<button class="btn btn-secondary" id="goMainBtn" type="button">메인으로</button>
						<script>
						const goMainBtn = document.getElementById('goMainBtn');
						goMainBtn.addEventListener('click', function(){
							location.href='<%= request.getContextPath() %>';
						});
						</script>	
						<% } else if (loginUser.getAuth() == 2) { %>
						<button class="btn btn-secondary" id="goMainBtn2" type="button">메인으로</button>
						<script>
						const goMainBtn2 = document.getElementById('goMainBtn2');
						goMainBtn2.addEventListener('click', function(){
							location.href='<%= request.getContextPath() %>/myhotel/list';
						});
						</script>
						<% } %>
						<button class="btn btn-secondary" id="updateBtn">수정하기</button>
						<button class="btn btn-secondary" id="deleteBtn" type="button">탈퇴하기</button>
		<script>
		// 1. 메인
		
		
		
		
		// 2. 탈퇴하기
		const deleteBtn = document.getElementById('deleteBtn');
		deleteBtn.addEventListener('click', function(){
			if(confirm("진짜 탈퇴하시겠습니까?")){
				location.href="<%= request.getContextPath() %>/account/delete";
			}
		});
		// 3. 비밀번호 변경 창
		const pwdUpdateBtn = document.getElementById('pwdUpdateBtn');
		pwdUpdateBtn.addEventListener('click', function(){
			window.open("pwdUpdateForm.jsp", "비밀번호 변경", "width=500, height=450");
		});
		
		$(document).ready(function(){
			if(<%=m.getAuth()%> == 1) {
			$("#bLicense").attr("readonly", true);
			}
		});
	</script>
					</div>
				</div>	
			</form>
			</div>
		</div>
</body>
</html>