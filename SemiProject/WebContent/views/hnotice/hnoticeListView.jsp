<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, hnotice.model.vo.HNotice"%>
<%
	ArrayList<HNotice> list = (ArrayList<HNotice>)request.getAttribute("list");
	int hotelId = Integer.parseInt(request.getParameter("hotelId"));
	String searchCondition = request.getParameter("searchCondition");
	String search = request.getParameter("search") != null ? request.getParameter("search") : "";
	String[] searchSelected = new String[2];
	if(searchCondition != null){
		if(searchCondition.equals("title"))
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
	 margin : auto;
	}
	
	/* 공지사항 목록 영역 */
	.tableArea{
	width: 900px;
	min-height : 99px;
	padding : 0px;
	background : white;
	}
	
	h1 {
	color : white;
	}
	
	/* 공지사항 테이블 */
	#listTable{
	 	text-align:center;
		margin:auto; 
	}
	
	#listTable th:nth-child(1) {
		width : 150px;
	}
	
	#listTable th:nth-child(2) {
		width : 400px;
	}
	
	#listTable th:nth-child(3) {
		width : 200px;
	}
	
	#listTable th:nth-child(4) {
		width : 150px;
	}
	
	#listTable th:nth-child(5) {
		width : 100px;
	}
	
	table tr{
	color:black;
	}
	table th{
		width : 144px;
		height : 45px;
		color:#B3B3B3; 
		background-color : #343A40;
	}
	
	table td{
	height : 45px;
	background-color : white;
	}
	
	/* 검색하기 영역 */
	.searchArea{
	width : 900px;
	margin : auto;
	color:#B3B3B3; 
	background-color : #343A40;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>호텔공지사항</h1><br>
	<div class="outer">
		<div class="tableArea">
			
			<table id="listTable">
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="4">존재하는 공지사항이 없습니다.</td>
				</tr>
				<% } else { 
				for(HNotice n : list) { %>
				<tr>
					<td><%= n.getHnNo() %></td>
					<td><%= n.getHnTitle() %></td>
					<td><%= n.getHotelName()%></td>
					<td><%= n.getCreate_date() %></td>
				</tr>
				<%	} 
				} %>
			</table>
		</div>
		
				<div class="searchArea">
			<form action="<%= request.getContextPath() %>/hnotice/search" method="get"
			onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition">
					<option value="----">----</option>
					<option value="title" <%= searchSelected[0] %>>제목</option>
					<option value="content" <%= searchSelected[1] %>>내용</option>
				</select>
				<input type="search" name="search" value="<%= search %>">
				<button type="submit" class="btn btn-secondary">검색하기</button>
				<%if(loginUser.getAuth() == 2) { %>
				<button type="button" class="btn btn-secondary" id="noticeInsert">작성하기</button>
				<% } %>
				<script>
					// 작성하기 버튼 이벤트
					const noticeInsert = document.getElementById('noticeInsert');
					noticeInsert.addEventListener('click', function(){
						location.href='<%= request.getContextPath() %>/hnotice/selectList?hotelId='+<%=hotelId%>;
					});
				</script>
				<input type="hidden" name="hotelId" value="<%=hotelId %>">
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
				var hnno = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/hnotice/detail?hnno=" + hnno;
			});
		});
	</script>
</body>
</html>