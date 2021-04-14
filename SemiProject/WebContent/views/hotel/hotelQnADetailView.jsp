<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.QnA"%>
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
<title>코코넨네</title>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
	<h2 class="title"><%=q.getHotel_name()%>Q&A</h2><br>
	<div class="outer">
		<div class="tableArea">
			
			<table class="table table-striped">
				<tr>
					<th>제목</th>
					<td colspan="3"><%=q.getQna_title() %></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><%= q.getCreate_date() %></td>
					<th>작성자</th>
					<td><%= q.getName() %></td>
				</tr>
				<tr>
				</tr>
			</table>
			<textarea name="content" class="content" style="resize:none;" readonly><%= q.getQna_content()%></textarea>
			<div class="tableArea">	
				<form id="qnaNoForm" method="post">
					<input type="hidden" name="qnaNo" value="<%=q.getQna_no()%>">
					<input type="hidden" name="hotelId" value="<%=q.getHotel_id()%>">
				</form>
				<div>
					<div class="answerArea">
						<%if(q.getQna_answer() == null ) {%>
						<div class="answerArea">아직 답변이 등록되지 않았습니다.</div>
						<% } else { %>
						<div class="answerArea"><%=q.getName() %>님 문의하신 내용에 답변드립니다.</div>
					</div>	
						<textarea name="answer" class="answer" style="resize:none;" readonly><%= q.getQna_answer()%></textarea>
						<% } %>
					
				</div>
			</div>	
			<div class="btnArea">
				<button type="button" class="btn btn-secondary btn-sm" id="listBtn">목록으로</button>
				<% if(loginUser != null && loginUser.getAuth() == 2 && q.getQna_status() == 1) { %>
				<button type="button" class="btn btn-secondary btn-sm" id="answerBtn">답변하기</button>
				<% } else if(loginUser != null && loginUser.getAuth() == 2 && q.getQna_status() == 2) {%>
				<button type="button" class="btn btn-secondary btn-sm" id="answerBtn">수정하기</button>
				<% } %>
					<script>
					// 답변하기 버튼 이벤트
					const answerBtn = document.getElementById('answerBtn');
					answerBtn.addEventListener('click', function(){
						$("#qnaNoForm").attr("action", "<%= request.getContextPath() %>/views/hotel/QnAanswerForm.jsp");
						$("#qnaNoForm").submit();
					});
					
					</script>
				<% if(loginUser != null && q.getAccount_id().equals(loginUser.getAccountId()) ) { %>
				<button type="button" class="btn btn-secondary btn-sm" id="deleteBtn">삭제하기</button>
					<script>
					// 삭제
						const deleteBtn = document.getElementById('deleteBtn');
						deleteBtn.addEventListener('click', function(){
							$("#qnaNoForm").attr("action", "<%= request.getContextPath() %>/qna/delete");
							$("#qnaNoForm").submit();
							alert('Q&A를 삭제했습니다!');
						});
						
					</script>
				<% if(q.getQna_status() == 1) {%>
				<button type="button" class="btn btn-secondary btn-sm" id="updateBtn">수정하기</button>
				<% }
				} %>

			</div>
		</div>
	</div>
	
	<script>
		// 목록으로 버튼 이벤트
		const listBtn = document.getElementById('listBtn');
		const hotelId = <%=q.getHotel_id()%>;
		listBtn.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/qna/list?hotelId=" + hotelId;
		});
	</script>
</body>
</html>