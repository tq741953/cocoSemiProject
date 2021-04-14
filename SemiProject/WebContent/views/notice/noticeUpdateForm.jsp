<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>코코넨네</title>
<style>
	.outer{
		min-width : 500px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	.titlename {
		color : white;
	}
	
	.tableArea{
		width:500px;
		margin:auto;
		background-color:white;
	}
	
	textarea {
		width : 450px;
		height : 300px;
		padding : 30px 10px 14px 10px;
		background : white;
	}
	.btnArea {
		text-align:center;
		padding : 10px;
	}
	.table, .content {
	text-align:center;
	}
	.title {
	text-align:center;
	width:100%;
	border : none;
	}

	table tr,
	.content,
	.title{
	color:black;
	}
	table th{
	color:#B3B3B3;
	background-color : #343A40;
	}
	.content{
		margin-top:-15px;
		width:100%;
		border : none;
	}
	table td,
	table th {
		border:1px solid white;
	}
	
</style>
</head>
<body>
	<%@ include file = "../common/menubar.jsp" %>
	<h2 class="titlename">공지사항 수정</h2><br>
	<div class="outer">
		<div class="tableArea">
			
			<form action="<%= request.getContextPath() %>/notice/update" method="post">
				<input type="hidden" name="noticeNo" value="<%= n.getNoticeNo() %>">
			
			<table class="table table-striped">
				<tr>
					<th colspan="2">제목</th>
				</tr>
				<tr>
					<td colspan="2">
					<input class="title" type="text" name="title" value="<%= n.getNoticeTitle() %>">
				</td>
				</tr>
				<tr>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				<tr>
					<td><%= n.getCreateDate() %></td>
					<td><%= n.getAccountId() %></td>
				</tr>
			</table>
			<textarea name="content" class="content" style="resize:none;"><%= n.getNoticeContent() %></textarea>
				
				<div class="btnArea">
					<button type="submit" id="updateBtn" class="btn btn-secondary btn-sm">수정하기</button>
					<button type="button" onclick="javascript:history.back();" class="btn btn-secondary btn-sm">취소</button>
				</div>
			</form>
		</div>
	</div>	
</body>
</html>