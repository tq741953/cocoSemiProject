<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hnotice.model.vo.HNotice, account.model.vo.Account"%>
<%
	HNotice n = (HNotice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 바깥 영역 */
	.outer{
		width:700px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1 {
		color : white;
	}
	
	.notice_title{
		width : 700px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	
	
	/* 공지사항 목록 영역 */
	.tableArea{
		width : 700px;
		background: white;
		margin : auto;
	}
	
	.input_area {
		width : 700px;
		height : 60px;
	    background : white;
	    display : inline-block;
	}
	
	.input_area input {
		width : 700px;
		height : 60px;
		border: 0px;
		text-align : center;
	}
	
	textarea {
		width : 700px;
		height : 300px;
		border: none;
	}
	.btnArea {
		text-align:center;
		padding : 10px;
		background-color : #343A40;
	}
</style>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
				<h1>공지사항 상세 페이지</h1>
				<form id="hnnoForm" method="post">
	<div class="outer">
		<div class="tableArea">


			<h4 class="notice_title">제목</h4>
			<span class="input_area">
			<input type="text" name="title" value="<%= n.getHnTitle() %>" readonly>
			</span>
			<h4 class="notice_title">작성자</h4>
			<span class="input_area">
			<input type="text" name="writer" value="<%= n.getHotelName()%>" readonly>
			</span>
			<h4 class="notice_title">작성일</h4>
			<span class="input_area">
			<input type="date" name="date" value="<%= n.getCreate_date() %>" readonly>
			</span>
			<h4 class="notice_title">내용</h4>
			<textarea name="content" style="resize:none;" readonly><%= n.getHnContent() %></textarea>
			
			<div class="btnArea">
				<button type="button" class="btn btn-secondary" id="listBtn">목록으로</button>
				<button type="button" class="btn btn-secondary" id="updateBtn">수정하기</button>
				<button type="button" class="btn btn-secondary" id="deleteBtn">삭제하기</button>
				
				<% if(loginUser != null) {  %>

				
					<input type="hidden" name="hnno" id="hnno" value="<%= n.getHnNo() %>">
					<input type="hidden" name="hotelId" id="hotelId" value="<%= n.getHotel_id() %>">
				
				<script>
					// 수정하기 버튼 이벤트
					const updateBtn = document.getElementById('updateBtn');
					const hnno = document.getElementById('hnno').value;
		               updateBtn.addEventListener('click', function(){
		                  $("#hnnoForm").attr("action", "<%= request.getContextPath() %>/hnotice/update?hnno="+hnno);
		                  $("#hnnoForm").submit();
		               });
					// 삭제하기 버튼 이벤트
					const deleteBtn = document.getElementById('deleteBtn');
					deleteBtn.addEventListener('click', function(){
						$("#hnnoForm").attr("action", "<%= request.getContextPath() %>/hnotice/delete?hnno="+hnno);
						$("#hnnoForm").submit();
					});
				</script>
				
				<%  } %>
				
			</div>
		</div>
	</div>
	</form>
	<script>
		// 목록으로 버튼 이벤트
		const listBtn = document.getElementById('listBtn');
		listBtn.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/hnotice/list?hotelId="+<%=n.getHotel_id()%>;
		});
	</script>

</body>
</html>