<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.*, java.util.ArrayList"%>
<%
	ArrayList<QnA> list = (ArrayList<QnA>) request.getAttribute("list");
	ArrayList<QnA> qList = (ArrayList<QnA>) request.getAttribute("qList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int hotelId = (Integer)(request.getAttribute("hotelId"));
	
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
<style>
.outer {
 width : 900px;
 margin : auto;
}
h1{
	color : white;
}

#listTable {
	width: 900px;
	text-align: center;
	margin: auto;
}
.QnAArea {
	width: 900px;
	min-height : 99px;
	padding : 0px;
	background : white;
}
h3{
	color : white;
}

table tr{
	color:black;
}
table th{
	width : 144px;
	color:#B3B3B3; 
	background-color : #343A40;
}

table th:first-child {
	width : 70px;
}

table th:nth-child(2) {
	width : 220px;
}

table th:nth-child(4) {
	width : 80px;
}

table th:nth-child(5) {
	width : 120px;
}

table th:nth-child(6) {
	width : 100px;
}

table td{
	background-color : white;
}
.pagingArea {
	width: 900px;
	background-color : white; 
	height : 50px;
	margin-top : 10px;
	margin : auto;
}
.pagingArea button {
		width:30px;
		margin:0px;
}
.searchArea, .QnAInsertArea{
	width : 900px;
	color:#B3B3B3; 
	background-color : #343A40;
}
.inner {
	padding : 0px 0px 0px 0px;
	background-color : white;
}
.pagingInside{
	height : 40px;
	padding-top : 10px;
}
</style>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
	<h1>Q&A</h1><br>
	<div class="outer">
	<div class="inner">
	
	<%
		if (!list.isEmpty() && loginUser.getAuth()==1) {
	%>
	
	
	<%}else if (!list.isEmpty() && loginUser.getAuth()==2) { %>
	<%} %>
		<div class="QnAArea">
			<table class="table table-striped table-hover" id="listTable">
				<tr>
					<th>NO</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>답변여부</th>
				</tr>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="5">등록된 Q&A가 없습니다.</td>
				</tr>
				<% } else { 
						for(QnA q : qList) { %>

				<tr>
					<td><%= q.getQna_no() %></td>
					<td><%= q.getQna_title() %></td>
					<td><%= q.getName() %></td>
					<td><%= q.getCreate_date() %></td>
					<% if(q.getQna_status() == 1) {%>
					<td style="color : gray;">답변대기</td>
					<% } else { %>
					<td style="color : green;">답변완료</td>
					<% } %>
				</tr>
							<%	} 
				} %>
			</table>
		</div>

		

		<div class="pagingArea">
			<!-- 이전 페이지로(<) -->
			<% if(pi.getCurrentPage() == 1) { %>
			<button class="btn btn-secondary btn-sm" disabled> &lt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/list?currentPage=<%= pi.getCurrentPage() - 1 %>&hotelId=<%=hotelId %>'"> &lt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchCondition=<%= searchCondition %>&hotelId=<%=hotelId %>&search=<%= search %>'"> &lt; </button>
			<% } %>
			<!-- 숫자로 된 페이지 목록 (최대 10개) -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<% if(p == pi.getCurrentPage()) { %>
				<button  class="btn btn-secondary btn-sm" disabled> <%= p %> </button>
				<% } else if(searchCondition == null) { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/list?currentPage=<%= p %>&hotelId=<%=hotelId %>'"> <%= p %> </button>
				<% } else { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= p %>&searchCondition=<%= searchCondition %>&hotelId=<%=hotelId%>&search=<%= search %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로(>) -->
			<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
			<button class="btn btn-secondary btn-sm" disabled> &gt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/list?currentPage=<%= pi.getCurrentPage() + 1 %>&hotelId=<%=hotelId %>'"> &gt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchCondition=<%= searchCondition %>&hotelId=<%=hotelId %>&search=<%= search %>'"> &gt; </button>
			<% } %>
		</div>
				<div class="searchArea">
			<form action="<%= request.getContextPath()%>/hotelQnA/search" method="get"
			onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition" style="background:#F2F2F2; color:black;">
					<option>----</option>
					<option value="title" <%= searchSelected[0] %>>제목</option>
					<option value="content" <%= searchSelected[1] %>>내용</option>
				</select>
				<input type="search" name="search" class="search" style="background:#F2F2F2; color:black;" value="<%= search %>">
				<button type="submit" id="searchBtn" class="btn btn-secondary btn-sm">&nbsp;검색&nbsp;</button>
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
		<div class="QnAInsertArea">
			<% if(loginUser != null && loginUser.getAuth() == 1) { %>
			<button class="btn btn-secondary btn-sm" id="QnAInsert">등록하기</button>
			<input type="hidden" name="hotelId" value="<%=hotelId%>">
			<script>
			const QnAInsert = document.getElementById('QnAInsert');
			QnAInsert.addEventListener('click', function(){
				location.href='<%= request.getContextPath() %>/views/account/accountQnAInsertForm.jsp';
			});
			</script>
			<% } %>
		</div>
		</div>
		</div>
	
		<script>
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"cursor" : "pointer"});
			}).click(function(){
				var qnaNo = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/qna/detail?qnaNo=" + qnaNo;
			});
		});
	</script>
</body>
</html>