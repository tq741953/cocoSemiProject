<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.Review"%>
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	
	String searchCondition = request.getParameter("searchCondition");
	String search = request.getParameter("search") != null ? request.getParameter("search") : "";
	String[] searchSelected = new String[2];
	if(searchCondition != null){
	if(searchCondition.equals("booking number"))
		searchSelected[0] = "selected";
	else
		searchSelected[1] = "selected";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	.outer{
		width : 1000px;
		min-width : 200px;
		background: rgb(248, 249, 250);
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1{
		color : white;
	}
	
	/* 공지사항 목록 영역 */
	.tableArea{
		width : 1000px;
	}
	
	/* 공지사항 테이블 */
	#listTable{
		width : 1000px;
		border:1px solid white;
	 	text-align:center;
		margin:auto; 
	}
	
	table th{
		height : 50px;
		color:#B3B3B3;
		background-color : #343A40;
	}
	
	table td{
		height : 50px;
		background-color : white;
	}
	.tableArea {
		width : 1000px;
	}
	
	#listTable th:nth-child(1) {
		width : 100px;
	}
	
	#listTable th:nth-child(2) {
		width : 250px;
	}
	
	#listTable th:nth-child(3) {
		width : 400px;
	}
	
	#listTable th:nth-child(4) {
		width : 150px;
	}
	
	#listTable th:nth-child(5) {
		width : 100px;
	}
	
	/* 검색하기 영역 */
	.searchArea {
		width : 1000px;
		color:#B3B3B3; 
		background-color : #343A40;
	}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>리뷰페이지</h1><br>
	<div class="outer">
		<div class="tableArea">
			
			<table id="listTable">
				<tr>
					<th>글번호</th>
					<th>예약번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>평점</th>
				</tr>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="5">존재하는 리뷰가 없습니다.</td>
				</tr>
				<% } else { 
				for(Review r : list) { %>
				<tr>
					<td><%= r.getReview_no() %></td>
					<td><%= r.getReservation_no() %></td>
					<td><%= r.getReview_title() %></td>
					<td><%= r.getName() %></td>
					<td style="color:tomato"><%= r.getReview_grade() %>점</td>
				</tr>
				<%	} 
				} %>
			</table>
		</div>
		
		
			<div class="searchArea">
				<form action="<%= request.getContextPath() %>/review/search" method="get"
			onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition">
					<option value="----">----</option>
					<option value="booking number" <%= searchSelected[0] %>>예약번호</option>
					<option value="content" <%= searchSelected[1] %>>내용</option>
				</select>
				<input type="search" name="search" value="<%= search %>">
				<button type="submit" class="btn btn-secondary">검색하기</button>
			</form>
			<script>
				function checkSearchCondition(){
					if($("#searchCondition option:selected").val() == '----'){
						return false;
					}
					return true;
				}
			</script>
			</div>
	</div>
	<script>
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor" : "pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "rgb(248, 249, 250)");
			}).click(function(){
				var review_no = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/review/detail2?review_no=" + review_no;
			});
		});
	</script>
</body>
</html>