<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, reservation.model.vo.Reservation"%>
<%
	ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list");

	String searchCondition = request.getParameter("searchCondition");
	String search = request.getParameter("search") != null ? request.getParameter("search") : "";
	String[] searchSelected = new String[2];
	if(searchCondition != null){
		if(searchCondition.equals("account_id"))
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
/* 바깥 영역 */
	.outer{
		width : 900px;
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
		width : 900px;
	}
	
	/* 공지사항 테이블 */
	#listTable{
		width : 900px;
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
		width : 900px;
	}
	
	#listTable th:nth-child(1) {
		width : 100px;
	}
	
	#listTable th:nth-child(2) {
		width : 100px;
	}
	
	#listTable th:nth-child(3) {
		width : 240px;
	}
	
	#listTable th:nth-child(4) {
		width : 200px;
	}
	
	#listTable th:nth-child(5) {
		width : 200px;
	}
	
	/* 검색하기 영역 */
	.searchArea {
		width : 900px;
		color:#B3B3B3; 
		background-color : #343A40;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>예약/결제 확인</h1><br>
	<div class="outer">
		<div class="tableArea">
			
			<table id="listTable">
				<tr>
					<th>예약번호</th>
					<th>객실 번호</th>
					<th>투숙객 이름</th>
					<th>입실일</th>
					<th>퇴실일</th>
				</tr>
				
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr>
				<% } else { 
				for(Reservation r : list) { %>
				<tr>
					<td><%= r.getReservation_no() %></td>
					<td><%= r.getRoom_no() %></td>
					<td><%= r.getGuest_name() %></td>
					<td><%= r.getCheck_in() %></td>
					<td><%= r.getCheck_out() %></td>
				</tr>
				<%	} 
				} %>
			</table>
		</div>
		
		<div class="searchArea">
			<form action="<%= request.getContextPath() %>/reservation/search" method="get"
			onsubmit="return checkSearchCondition();">
			<select id="searchCondition" name="searchCondition">
					<option value="----">----</option>
					<option value="account_id" <%= searchSelected[0] %>>회원ID</option>
					<option value="room_number" <%= searchSelected[1] %>>객실번호</option>
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
		// 3. 공지사항 상세 보기 기능 (jquery)
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor" : "pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "rgb(248, 249, 250)");
			}).click(function(){
				// 쿼리 스트링을 이용하여 get 방식(url 노출)으로 글번호를 parameter로 전달
				var reservationNo = $(this).parent().children().eq(0).text();
				location.href="<%= request.getContextPath() %>/reservation/detail?reservationNo=" + reservationNo;
			});
		});
	</script>
</body>
</html>