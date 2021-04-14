<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, hotel.model.vo.*"%>
<%
	ArrayList<Hotel> list = (ArrayList<Hotel>) request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	
	String searchCondition = request.getParameter("searchCondition");
	String search = request.getParameter("search") != null ? request.getParameter("search") : "";
	String[] searchSelected = new String[2];
	if(searchCondition != null){
		if(searchCondition.equals("hotelName"))
			searchSelected[0] = "selected";
		else
			searchSelected[1] = "selected";
	}
	
	int currentPage = pi.getCurrentPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<style>
	.outer {
	 width : 1300px;
 	margin : auto;
}
	#listTable {
	width:70%;
	text-align: center;
	margin: auto;
}

table tr{
	heignt : 44px;
	color : black;
	backgroundcolor:white;
}
table th{
	width : 144px;
	heignt : 44px;
	color:#B3B3B3; 
	background-color : #343A40;
}


table td:first-child{
	width : 10%;
}

table td:nth-child(2){
	width : 30%;
}

table td:nth-child(3){
	width : 30%;
}

table td:nth-child(4){
	width : 20%;
}

table td:nth-child(5){
	width : 10%;
}

.result{
	heignt : 44px;
	color : black;
	background-color:white;
}

.searchArea{
	width : 910px;
	margin : auto;
	background-color : #343A40;
}

.pagingArea{
	width : 910px;
	margin : auto;
	background-color : white;
}
</style>
<body>
	<%@ include file="mainMenubar.jsp"%>
	<h3 style="color : white;"><%=loginUser.getName() %>님의 보유 호텔 목록</h3><br>
	<div class="outer">
	
	<table class="table table-striped table-hover" id="listTable">
				<tr>
					<th>NO</th>
					<th>호텔명</th>
					<th>호텔주소</th>
					<th>전화번호</th>
					<th>승인</th>
				</tr>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td class="result" colspan="5">보유한 호텔이 없습니다.</td>
				</tr>
				<%
					} else {
						for (Hotel h : list) {
				%>

				<tr>
					<td class="result"><%=h.getHotel_id() %></td>
					<td class="result"><%=h.getHotel_name() %></td>
					<td class="result"><%=h.getHotel_address() %></td>
					<td class="result"><%=h.getHotel_phone() %></td>
					<td class="result"><%=h.getStatus() %></td>
				</tr>
				<%
						}
					}
				%>
			</table>
		</div>	
			
		<script>
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"cursor" : "pointer"});
			}).click(function(){
				var hotelId = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/myhotel/detail?hotelId=" + hotelId;
			});
		});
	</script>

	<div class="pagingArea">
			<!-- 이전 페이지로(<) -->
			<% if(pi.getCurrentPage() == 1) { %>
			<button class="btn btn-secondary btn-sm" disabled> &lt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/list?currentPage=<%= pi.getCurrentPage() - 1 %>'"> &lt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchCondition=<%= searchCondition %>&accountId=<%=loginUser.getAccountId() %>&search=<%= search %>'"> &lt; </button>
			<% } %>
			<!-- 숫자로 된 페이지 목록 (최대 8개) -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<% if(p == pi.getCurrentPage()) { %>
				<button  class="btn btn-secondary btn-sm" disabled> <%= p %> </button>
				<% } else if(searchCondition == null) { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/list?currentPage=<%= p %>'"> <%= p %> </button>
				<% } else { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/search?currentPage=<%= p %>&searchCondition=<%= searchCondition %>&accountId=<%=loginUser.getAccountId() %>&search=<%= search %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로(>) -->
			<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
			<button class="btn btn-secondary btn-sm" disabled> &gt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/list?currentPage=<%= pi.getCurrentPage() + 1 %>'"> &gt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/myhotel/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchCondition=<%= searchCondition %>&accountId=<%=loginUser.getAccountId() %>&search=<%= search %>'"> &gt; </button>
			<% } %>
		</div>
		
			<div class="searchArea">
			<form action="<%= request.getContextPath()%>/myhotel/search" method="get"
			onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition" style="background:#3E444A; color:white;">
					<option>----</option>
					<option value="hotelName" <%= searchSelected[0] %>>호텔명</option>
					<option value="address" <%= searchSelected[1] %>>주소</option>
				</select>
				<input type="search" name="search" class="search" style="background:white; color:white;" value="<%= search %>">
				<button type="submit" id="searchBtn" class="btn btn-secondary btn-sm">&nbsp;검색&nbsp;</button>
				<input type="hidden" name="accountId" value=<%=loginUser.getAccountId() %>>
			</form>
			<button class="btn btn-secondary" id="hotelListBtn">호텔등록</button>
			
			<script>
				function checkSearchCondition(){
					if($("#searchCondition option:selected").val() == '----'){
						return false;
					}
					return true;
				}
				const hotelListBtn = document.getElementById('hotelListBtn');
				hotelListBtn.addEventListener('click', function(){
					location.href="<%= request.getContextPath() %>/hotel/list";
				});
			</script>
	</div>
</body>
</html>