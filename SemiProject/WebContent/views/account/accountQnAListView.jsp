<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="account.model.vo.*, java.util.ArrayList"%>
<%
	ArrayList<QnA> list = (ArrayList<QnA>) request.getAttribute("list");
	ArrayList<QnA> qList = (ArrayList<QnA>)request.getAttribute("qList");

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
.QnAArea {
	width: 900px;
	min-height : 99px;
	padding : 0px;
	background : white;
}
h3 {
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
	text-align:center;
	background-color : #343A40;
	height : 50px;
	margin-top : 10px;
	margin : auto;
		
}

.pagingInside{
	height : 40px;
	padding-top : 10px;
}
.pagingArea button {
		width:30px;
		margin:auto;
	}
.contentBack {
		padding-top:0px;
		padding-bottom:0px;

}
</style>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<body>

	<%@ include file= "../common/menubar.jsp" %>
	<h3> < <%=loginUser.getName()%>님의 Q&A 문의내역 > </h3><br>	
	<div class="outer">
		<div class="container contentBack">
	
		<div class="QnAArea">
			<table style="table-layout:fixed" class="table table-striped table-hover" id="listTable">
				<tr>
					<th>NO</th>
					<th>제목</th>
					<th>문의한 업체</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>답변여부<!-- (조회확인으로 변경해야함) --></th>
				</tr>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="6">등록된 Q&A가 없습니다.</td>
				</tr>
				<%
					} else { 
						for(QnA q : qList) {
				%>

				<tr>
					<td><%= q.getQna_no() %></td>
					<td><%= q.getQna_title() %></td>
					<td style="width:50px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%= q.getHotel_name() %></td>
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
			<div class="pagingInside">
			<!-- 이전 페이지로(<) -->
			<% if(pi.getCurrentPage() == 1) { %>
			<button class="btn btn-secondary btn-sm" disabled> &lt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/mylist?accountId=<%=loginUser.getAccountId() %>&currentPage=<%= pi.getCurrentPage() - 1 %>'"> &lt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &lt; </button>
			<% } %>
			<!-- 숫자로 된 페이지 목록 (최대 10개) -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<% if(p == pi.getCurrentPage()) { %>
				<button  class="btn btn-secondary btn-sm" disabled> <%= p %> </button>
				<% } else if(searchCondition == null) { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/mylist?accountId=<%=loginUser.getAccountId() %>&currentPage=<%= p %>'"> <%= p %> </button>
				<% } else { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/search?currentPage=<%= p %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로(>) -->
			<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
			<button class="btn btn-secondary btn-sm" disabled> &gt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/mylist?accountId=<%=loginUser.getAccountId() %>&currentPage=<%= pi.getCurrentPage() + 1 %>'"> &gt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/qna/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &gt; </button>
			<% } %>
			</div>
		</div>

		</div>
		</div>
		<script>
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"cursor" : "pointer"});
			}).click(function(){
				var qnaNo = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/qna/mydetail?qnaNo=" + qnaNo;
			});
		});
	</script>
</body>
</html>