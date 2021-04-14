<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p,a{
		text-align : center;
	}
	
	.outer{
		width : 500px;
		background : white;
		margin : auto;
	}
	
	.title {
	height : 50px;
	font-size : 30px;
	color:#B3B3B3;
	background-color : #343A40;
	}
	
	.mainbtn {
		color : #343A40;
		margin-top : 10px;
	}
</style>
</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<div class="outer">
	<div class="title">예약 완료!</div>
	<br>
	
	<h5>결제가 성공적으로 완료 되었습니다.</h5>
	<br>
	<p>기타 궁금하신 사항은 우측 하단에 채널톡 1:1 문의로<br> 연락 주시면 성심껏 답변 드리겠습니다.</p>
	<p>예약하신 정보는 마이페이지 - 예약 내역에서 확인 가능 합니다.</p>
	
	<div class="mainpage"><a class="mainbtn" href="<%= request.getContextPath() %>">메인페이지로 돌아가기!</a></div>
	
	</div>
</body>
</html>