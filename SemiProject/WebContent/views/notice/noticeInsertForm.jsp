<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
<style>
	.outer{
		width : 455px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
		background : white;
	}
	
	.titlename {
		color : white;
	}
	
	.tableArea{
		width:452px;
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
	h2,
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
	table th{
	color:#B3B3B3;
	font-size: small;
	}
	.content{
		margin-top:-15px;
		width:100%;
	}
	table td{
		background : white;
		color : black;
	}
	table th {
		border:1px solid white;
	}
	

	
	input,
	textarea {
		border:none;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h2 class="titlename">공지사항 등록</h2><br>
	<div class="outer">
	
		<div class="tableArea">
			
			<form action="<%= request.getContextPath() %>/notice/insert" method="post">
			<table class="table table-striped">
				<tr>
					<th colspan="2">제목</th>
				</tr>
				<tr>
					<td colspan="2">
					<input class="title" type="text" name="title" maxlength="30" placeholder="공지사항 제목을 입력해주세요" required>
				</td>
				</tr>
				<tr>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				<tr>
					<td><input class="date" type="date" name="date" value="<%= today %>" readonly></td>
					<td><input class="writer" type="text" name="writer" value="<%= loginUser.getName() %>" readonly></td>
				</tr>
			</table>
					<input type="hidden" name="id" value="<%= loginUser.getAccountId() %>">
			<textarea name="content" class="content" style="resize:none;" placeholder="공지사항 내용을 입력해주세요"></textarea>
			
			<div class="btnArea">
				<button type="submit" class="btn btn-secondary btn-sm" id="insertBtn">등록</button> 
				<button type="button" class="btn btn-secondary btn-sm" onclick="javascript:history.back();">취소</button>
			</div>
			</form>
		</div>
	</div>

	<script>
		const insertBtn = document.getElementById('insertBtn');
			insertBtn.addEventListener('click', function(){
					alert("공지사항을 등록했습니다.");
			});
	</script>

</body>
</html>