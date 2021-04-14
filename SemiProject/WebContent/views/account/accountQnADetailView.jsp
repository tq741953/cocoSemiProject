<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="account.model.vo.QnA"%>
<%
	QnA q = (QnA)request.getAttribute("qna");
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
		border:1px solid white;
	}
</style>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
	<h2 class="title">Q&A</h2>
	<div class="outer">
		<div class="tableArea">
			<table class="table table-striped">
				<tr>
					<th colspan="4">제목</th>
				</tr>
				<tr>
					<td colspan="4"><%=q.getQna_title() %></td>
				</tr>
				<tr>
					<th>문의한 업체</th>
					<th>작성일</th>
					<th>작성자</th>
					<th>답변여부</th>
				</tr>
				<tr>
					<td><%= q.getHotel_name() %></td>
					<td><%= q.getCreate_date() %></td>
					<td><%= q.getName() %></td>
					<% if(q.getQna_status() == 1) {%>
					<td style="color : gray;">답변대기</td>
					<% } else { %>
					<td style="color : green;">답변완료</td>
					<% } %>
				</tr>
			</table>
			<textarea name="content" class="content" style="resize:none;" readonly><%= q.getQna_content()%></textarea>
			
			<div class="btnArea">
				<button type="button" class="btn btn-secondary btn-sm" id="listBtn">목록으로</button>
				<% if(loginUser != null && q.getAccount_id().equals(loginUser.getAccountId()) ) { %>
				<button type="button" class="btn btn-secondary btn-sm" id="deleteBtn" onclick="if(!confirm('Q&A를 삭제하시겠습니까?')){return false;}">삭제하기</button>
				<% if(q.getQna_status() == 1 ) {%>
				<button type="button" class="btn btn-secondary btn-sm" id="updateBtn">수정하기</button>
				
				<script>
					// 수정
					const updateBtn = document.getElementById('updateBtn');
					updateBtn.addEventListener('click', function(){
						$("#qnaNoForm").attr("action", "<%= request.getContextPath() %>/qna/updateForm");
						$("#qnaNoForm").submit();
					});
				</script>
				
				<% } 
				}%>
				<form id="qnaNoForm" method="post">
					<input type="hidden" name="qnaNo" value="<%=q.getQna_no()%>">
					<input type="hidden" name="accountId" value="<%=loginUser.getAccountId() %>">
				</form>
				
				<script>
					// 삭제
					const deleteBtn = document.getElementById('deleteBtn');
					deleteBtn.addEventListener('click', function(){
						$("#qnaNoForm").attr("action", "<%= request.getContextPath() %>/qna/delete");
						$("#qnaNoForm").submit();
						alert('Q&A를 삭제했습니다!');
					});
					
				</script>
			</div>
		</div>
		<%if(q.getQna_status() == 2) { %>
		<div class="tableArea">
		<table class="table table-striped">
			<tr>
				<th><%=q.getName() %>님 답변드립니다.</th>
			</tr>
			<tr>
				<td><textarea class="content" style="resize:none;" readonly><%= q.getQna_answer()%></textarea></td>
			</tr>
		</table >
		</div>
		<% } %>
	</div>
	
	<script>
		// 목록으로 버튼 이벤트
		const listBtn = document.getElementById('listBtn');
		const hotelId = <%=q.getHotel_id()%>;
		listBtn.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/qna/mylist?accountId=<%=q.getAccount_id()%>";
		});
	</script>
</body>
</html>