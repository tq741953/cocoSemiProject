<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<style>
	.outer{
		min-width : 500px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	.title {
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
		border: solid 1px black;
	}
	.btnArea {
		text-align:center;
		padding : 10px;
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
	.content{
		margin-top:-15px;
		width:100%;
	}
	table td,
	table th {
		border:1px solid black;
	}
	.contentBack {
		background-color : white;
	}
</style>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
	<h2 class="title">공지사항</h2><br>
	<div class="outer">
		<div class="tableArea">
			
			<table class="table table-striped">
				<tr>
					<th colspan="2">제목</th>
				</tr>
				<tr>
					<td colspan="2"><%=n.getNoticeTitle() %></td>
				</tr>
				<tr>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				<tr>
					<td><%= n.getCreateDate() %></td>
					<td><%= n.getName() %></td>
				</tr>
			</table>
			<textarea name="content" class="content" style="resize:none;" readonly><%= n.getNoticeContent() %></textarea>
			
			<div class="btnArea">
				<button type="button" class="btn btn-secondary btn-sm" id="listBtn">목록으로</button>
				<% if(loginUser != null && loginUser.getAuth() == 3) { %>
				<button type="button" class="btn btn-secondary btn-sm" id="updateBtn">수정하기</button>
				<button type="button" class="btn btn-secondary btn-sm" id="deleteBtn">삭제하기</button>
				
				<form id="noticeNoForm" method="post">
					<input type="hidden" name="noticeNo" value="<%= n.getNoticeNo() %>">
				</form>
				
				<% } %>
			</div>
		</div>
	</div>
					<script>
					// 수정하기 버튼 이벤트
					const updateBtn = document.getElementById('updateBtn');
					updateBtn.addEventListener('click', function(){
						$("#noticeNoForm").attr("action", "<%= request.getContextPath() %>/notice/updateForm");
						$("#noticeNoForm").submit();
					});
					
					// 삭제하기 버튼 이벤트
					const deleteBtn = document.getElementById('deleteBtn');
					deleteBtn.addEventListener('click', function(){
						if(confirm("공지사항을 삭제하시겠습니까?") == true){
							alert("공지사항을 삭제했습니다.");
						$("#noticeNoForm").attr("action", "<%= request.getContextPath() %>/notice/delete");
						$("#noticeNoForm").submit();
						} else {
							return false;
						}
					});
				</script>
	<script>
		// 목록으로 버튼 이벤트
		const listBtn = document.getElementById('listBtn');
		listBtn.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/notice/list";
		});
	</script>
</body>
</html>