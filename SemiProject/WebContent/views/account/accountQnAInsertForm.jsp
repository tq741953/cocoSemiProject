<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat, account.model.vo.QnA" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
	QnA q = (QnA)request.getAttribute("qna");
	int hotelId = (Integer)request.getSession().getAttribute("hotelId");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
<style>
	.outer{
		min-width : 700px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
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
	}
	.btnArea {
		text-align:center;
		padding : 10px;
		background-color : #343A40;
	}
	.table, .content {
	text-align:center;
	}
	
	h2{
	color : white;
	}
	.title,
	.date,
	.writer {
	text-align:center;
	width:100%;
	}
	table tr,
	.content,
	.title,
	.date,
	.writer{
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
		border:1px solid white;
	}
	
	table th{
	color:#B3B3B3; 
	background-color : #343A40;
	}
	
	input,
	textarea {
		border:none;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h2>Q & A 질문하기</h2><br>
	<div class="outer">
		<div class="tableArea">
			
			<form action="<%= request.getContextPath() %>/qna/insert" method="post">
		<table class="table table-striped">
				<tr>
					<th colspan="2">제목</th>
				</tr>
				<tr>
					<td colspan="2">
					<input class="title" type="text" name="title" maxlength="30" placeholder="Q&A 제목을 입력해주세요" required>
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
			<input type="hidden" name="id" value="<%=loginUser.getAccountId() %>">
			<input type="hidden" name="hotelId" value="<%=hotelId%>">
			<textarea name="content" class="content" style="resize:none;" placeholder="Q&A 내용을 입력해주세요"></textarea>
			
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
					alert("Q&A을 등록했습니다.");
			});
	</script>

</body>
</html>