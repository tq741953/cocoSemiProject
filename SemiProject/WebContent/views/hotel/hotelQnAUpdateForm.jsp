<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="account.model.vo.QnA"%>
<%
	QnA q = (QnA)request.getAttribute("qna");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width : 710px;
		height : 532px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
		background-color : white;
	}
	
	.tableArea{
		width:710px;
		margin:auto;
	}
	
	textarea {
		width : 450px;
		height : 300px;
		padding : 30px 10px 14px 10px;
		margin : auto;
		background : rgba(130, 138, 130, 0.2);
		border: solid 1px #dadada;
	}
	.btnArea {
		width : 710px;
		heigth : 50px;
		text-align:center;
		padding : 0px;
		margin-top : 10px;
		margin : auto;
		background : white;
	}
	.table, .content {
	text-align:center;
	}
	.stitle {
	text-align:center;
	width:100%;
	height : 100%;
	border : none;

	}

	
	input.stitle {
	width : 700px;
	height : 44px;
	}
	h2{
	color:white;
	}
	table tr{
	color : black;
	}

	table th{
	color:#B3B3B3;
	}
	.content{
		margin-top:-15px;
		width:100%;
		color : black;
		background-color : white;
	}
	table td{
		border:1px solid white;
		background-color : white;
	}
	
	table td:first-child {
	padding : 0px;
	}
	table th {
		border:1px solid white;
		color:#B3B3B3; 
		background-color : #343A40;
	}
	
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
	<h2>Q&A 수정</h2><br>
	<div class="outer">
		<div class="tableArea">
			
			<form class="formtag" action="<%= request.getContextPath() %>/qna/update2" method="post">
				<input type="hidden" name="qnaNo" value="<%= q.getQna_no() %>">
			
			<table class="table table-striped">
				<tr>
					<th colspan="2">제목</th>
				</tr>
				<tr>
					<td colspan="2">
					<input class="stitle" type="text" name="title" value="<%= q.getQna_title() %>">
				</td>
				</tr>
				<tr>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				<tr>
					<td><%= q.getModify_date() %></td>
					<td><%= q.getName() %></td>
				</tr>
			</table>
			<textarea name="content" class="content" style="resize:none;"><%= q.getQna_content() %></textarea>
				
				<div class="btnArea">
					<button type="submit" id="updateBtn" class="btn btn-secondary btn-sm">수정하기</button>
					<button type="button" onclick="javascript:history.back();" class="btn btn-secondary btn-sm">취소</button>
				</div>
			</form>
		</div>
	</div>	
</body>
</html>