<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat, account.model.vo.Account"%>
<%

	int hotelId = Integer.parseInt(request.getParameter("hotelId"));

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width : 600px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
		background : white;
	}
	.notice_title{
	
	}
	.titlename {
		color : white;
	}
	
	.tableArea{
		width:600px;
		margin:auto;
		background-color:white;
	}
	
	.notice_title{
		width : 600px;
		height : 50px;
		font-size : 25px;
		color:#B3B3B3;
		background:#343A40;
	}
	
	textarea {
		width : 600px;
		height : 300px;
		padding : 30px 10px 14px 10px;
		background : white;
	}
	.btnArea {
		text-align:center;
		padding : 10px;
	}
	.table {
	background:#343A40;
	text-align:center;
	}
	.content{
	background : white;
	}
	.title,
	.date,
	.writer {
	background:white;
	text-align:center;
	width:100%;
	}
	h1{
	color : white;
	}
	table tr,
	.title{
	color:black;
	}
	.date,
	.writer,
	.content,{
	background : white;
	color:black;
	}

	.content{
		margin-top:-15px;
		width:100%;
	}

	

	
	.inputTitle{
		width : 600px;
		height : 50px;
		border : none;
		text-align : center;
	}
	textarea {
		border:none;
	}
	
.btnArea{
	width : 600px;
	margin : auto;
	color:#B3B3B3; 
	background-color : #343A40;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>공지사항 작성</h1><br>
	<div class="outer">
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/hnotice/insert" method="post">
			<div class="notice_title">제목</div>
			<div class="input_area">
			<input type="text" class="inputTitle" name="title" maxlength="30" required>
			</div>
			<div class="notice_title">작성자</div>
			<div class="input_area">
			<input type="text" class="inputTitle" name="accountId" value="<%= loginUser.getAccountId() %>" readonly>
			</div>
			<div class="notice_title">작성일</div>
			<div class="input_area">
			<input type="date" class="inputTitle" name="date" value="<%= today %>" readonly>
			</div>
			<div class="notice_title">내용</div>
			<textarea name="content" style="resize:none;"></textarea>
			<input type="hidden" name="hotelId" value="<%= hotelId %>">
			<%-- <input type="hidden" name="hotel_id" value="<%= loginUser. %>"> --%>
			
			<div class="btnArea">
				<button class="btn btn-secondary" type="button" onclick="javascript:history.back();">취소</button>
				<button class="btn btn-secondary" type="submit">등록</button>
			</div>
			</form>
		</div>
	</div>

</body>
</html>