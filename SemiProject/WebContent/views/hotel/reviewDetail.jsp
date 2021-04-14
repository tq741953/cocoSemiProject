<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,hotel.model.vo.*"%>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int hId = Integer.parseInt(request.getParameter("hId"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer{
		width : 800px;
		background : white;		
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
}
.title{
	width : 800px;
	height : 60px;
	font-size : 20px;
	padding-top : 10px;
	color:#B3B3B3; 
	background-color : #343A40;
}
#historyback{
	left : 46%;
}
.reviewArea{
	width : 800px;
	min-height : 200px;
	background : white;
}
.sub{
	font-size : 30px;
} 
.sub_2nd{
	font-size : 20px;
}
.sub_3rd{
	font-size : 15px;
}
.insideArea{
	border : 2px solid #343A40;
	margin : 10px;
}
.pagingbar{
	width : 800px;
	color:#B3B3B3; 
	background-color : #343A40;
	margin : 0px;
}
	.btnArea {
		width : 800px;
		text-align:center;
		color:#B3B3B3; 
		background-color : #343A40;
	}
</style>
</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	
	<div class="outer">
		<div class="reviewArea">
			<div class="title">"<%= list.get(0).getHotel_name() %>"<small>의 리뷰</small></div>
			<% for(int i = 0; i < list.size(); i++) { %>
			<div class="insideArea">
			<div class="sub"><%= list.get(i).getReview_title() %></div>
			<div class="sub_2nd"> 평점 : <%= list.get(i).getReview_grade() %>/5 점</div><br>
			<div class="sub_3rd"><%= list.get(i).getName() %></div>
			<div class="sub_3rd"><%= list.get(i).getReview_content() %></div>
			<hr>
			</div>
			<% } %>
		</div>
		<!-- 페이징 바 -->
			<div class="pagingbar">
				<% if(pi.getCurrentPage() == 1) { %>
				<button class="btn btn-secondary" disabled>&larr; 이전페이지</button>
				<% }else{ %>
				<button class="btn btn-secondary" onclick="location.href='<%= request.getContextPath() %>/hotel/reviewDetail?currentPage=<%= pi.getCurrentPage() - 1 %>&hId=<%= hId %>'">&larr; 이전페이지</button>
				<%  } %>
				<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
				<button class="btn btn-secondary" disabled>다음페이지 &rarr;</button>
				<% }else{ %>
				<button class="btn btn-secondary" onclick="location.href='<%= request.getContextPath() %>/hotel/reviewDetail?currentPage=<%= pi.getCurrentPage() + 1 %>&hId=<%= hId %>'">다음페이지 &rarr;</button>
				<% } %>
			</div>
			<div class="btnArea">
			<button id="historyback" class="btn btn-secondary" onclick="location.href='javascript:history.back();'">이전으로</button>
			</div>
	</div>

</body>
</html>