<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.QnA, java.util.Date, java.text.SimpleDateFormat"%>
<%
	QnA q = (QnA)request.getAttribute("qna");
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);	
	
	int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
	int hotelId = Integer.parseInt(request.getParameter("hotelId"));
	String content = request.getParameter("content");
%>
<!DOCTYPE html>
<html>
<head>
<style>
	.outer{
		min-width : 700px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	.title {
		color : white;
	}
	.tableArea{
		width:700px;
		margin:auto;
		background-color:white;
	}
	
	textarea {
		width : 450px;
		height : 300px;
		padding : 30px 10px 14px 10px;
		border : none;
	}
	.btnArea {
		text-align:center;
		padding : 10px;
		background-color : #343A40;
	}
	.table, .content {
	text-align:center;
	}
	h2,
	table tr,
	.content{
	color:black;
	}
	table th{
	color:#B3B3B3; 
	background-color : #343A40;
	}
	.content, .answer {
		margin-top:-15px;
		width:100%;
	}
	table td,
	table th {
		border:1px solid white;
	}
	.answerArea{
	height : 70px;
	text-align : center;
	padding-top : 5px;
	color:#B3B3B3; 
	background-color : #343A40;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<h2 class="title">Q&A 답변</h2>
	<div class="outer">
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/qnaAnswer/insert" method="post">
			<table class="table table-striped">
				<tr>
					<th>작성일</th>
					<td><%= today %></td>
					<th>작성자</th>
					<td><%= loginUser.getName() %></td>
				</tr>
				<tr>
				</tr>
			</table>
			<textarea name="answer" class="content" style="resize:none;"></textarea>
			<div class="btnArea">
				<input type="hidden" name="id" value="<%=loginUser.getAccountId() %>">
				<input type="hidden" name="qnaNo" value="<%=qnaNo %>">
				<input type="hidden" name="hotelId" value="<%=hotelId %>">
				<button type="submit" class="btn btn-secondary btn-sm" id="insertBtn">등록</button> 
				<button type="button" class="btn btn-secondary btn-sm" onclick="javascript:history.back();">취소</button>
			</div>
			</form>
			</div>
				<script>
		const insertBtn = document.getElementById('insertBtn');
			insertBtn.addEventListener('click', function(){
					alert("Q&A 답변을 등록했습니다.");
			});
	</script>
			</div>
</body>
</html>