<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, notice.model.vo.*"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

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
<title>코코넨네</title>
<style>
.outer {
 width : 920px;
 margin : auto;
}

#listTable {
	width: 900px;
	text-align: center;
	margin: auto;
}
.noticeArea {
	width: 900px;
	min-height : 99px;
	padding : 0px;
	background : white;
}
h2{
	color:white;
}
table th{
	width : 144px;
	color:#B3B3B3; 
	background-color : #343A40;
}

table td{
	heignt : 44px;
}

.pagingArea {
	width: 900px;
	text-align:center;
	background-color : white;
	height : 50px;
	padding-top : 10px;
	margin : auto;
}
.pagingArea button {
		width:30px;
		margin:auto;
	}
.searchArea{
	width : 900px;
	margin : auto;
	color:#B3B3B3; 
  background-color: #343A40;
}
		.contentBack {
		padding-top:0px;
		padding-bottom:0px;
}

.noticeInsertArea {
	width : 900px;
	background-color : #343A40;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<h2>코코넨네 공지사항</h2><br>
	<div class="outer">
		<div class="container contentBack">
		<div class="noticeArea">
			<table class="table table-striped table-hover" id="listTable">
				<tr>
					<th>NO</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="5">등록된 공지사항이 없습니다.</td>
				</tr>
				<%
					} else {
						for (Notice n : list) {
				%>

				<tr>
					<td><%= n.getNoticeNo() %></td>
					<td><%= n.getNoticeTitle() %></td>
					<td><%= n.getName() %></td>
					<td><%= n.getnCount() %></td>
					<td><%= n.getCreateDate() %></td>
				</tr>
				<%
					}
					}
				%>

			</table>
		</div>
		
			<div class="pagingArea">
			<!-- 이전 페이지로(<) -->
			<% if(pi.getCurrentPage() == 1) { %>
			<button class="btn btn-secondary btn-sm" disabled> &lt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/list?currentPage=<%= pi.getCurrentPage() - 1 %>'"> &lt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &lt; </button>
			<% } %>
			<!-- 숫자로 된 페이지 목록 (최대 10개) -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<% if(p == pi.getCurrentPage()) { %>
				<button  class="btn btn-secondary btn-sm" disabled> <%= p %> </button>
				<% } else if(searchCondition == null) { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/list?currentPage=<%= p %>'"> <%= p %> </button>
				<% } else { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/search?currentPage=<%= p %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로(>) -->
			<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
			<button class="btn btn-secondary btn-sm" disabled> &gt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/list?currentPage=<%= pi.getCurrentPage() + 1 %>'"> &gt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/notice/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &gt; </button>
			<% } %>
		</div>
		
				
		<div class="searchArea">
			<form action="<%= request.getContextPath()%>/notice/search" method="get"
			onsubmit="return checkSearchCondition();">
				<select id="searchCondition" name="searchCondition" style="background:#F2F2F2; color:black;">
					<option>----</option>
					<option value="title" <%= searchSelected[0] %>>제목</option>
					<option value="content" <%= searchSelected[1] %>>내용</option>
				</select>
				<input type="search" name="search" class="search" style="background:#F2F2F2; color:black;" value="<%= search %>">
				<button type="submit" id="searchBtn" class="btn btn-secondary btn-sm">&nbsp;검색&nbsp;</button>
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
		
		<div class="noticeInsertArea">
			<% if(loginUser != null && loginUser.getAuth() == 3) { %>
			<button class="btn btn-secondary btn-sm" id="noticeInsert">등록하기</button>
			<script>
			const noticeInsert = document.getElementById('noticeInsert');
			noticeInsert.addEventListener('click', function(){
				location.href='<%= request.getContextPath() %>/views/notice/noticeInsertForm.jsp';
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
				var noticeNo = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/notice/detail?noticeNo=" + noticeNo;
			});
		});
	</script>
</body>
</html>