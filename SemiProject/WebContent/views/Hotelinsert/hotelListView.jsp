<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Hotelinsert.model.vo.*, java.util.*, account.model.vo.Account"%>
<%
	ArrayList<Hotel> hList = (ArrayList<Hotel>)request.getAttribute("hList");
	ArrayList<Hotel_file> fList = (ArrayList<Hotel_file>)request.getAttribute("fList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 바깥 영역 */
	.outer{
		width:900px;
		margin-top:20px;
		background: rgb(248, 249, 250);
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1{
		color : white;
	}
	
	h4{
		overflow:hidden;
		text-overflow:ellipsis;
	}
	
	.galleryArea {
		width:900px;
		margin-top:20px;
		min-height:400px;
		margin:auto;
	}
	
	img {
		width : 250px;
		height : 200px
	}
	
	.imgArea{
		width : 250px;
		height : 200px;
	}
	
	.gallery_list {
		width:253px;
		border : 2px solid #B3B3B3; 
		display:inline-block;
		margin:10px;
		text-align:center;
	}
	
	.gallery_list:hover {
		opacity:0.8;
		cursor:pointer;
	}

	.gallery_title {
		height : 42px;
		overflow:hidden;
	}
	
	.title1{
		width : 250px;
		height : 50px;
		display : block;
		overflow:hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
	}
	.title2{
		width : 250px;
		height : 40px;
	}
	.title3{
		width : 250px;
		height : 30px;
		overflow:hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
	}
	
	.btnArea {
		width:900px;
		text-align:center;
		background : #343A40;
	}
	
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>호텔등록 게시판</h1><br>
	<div class="outer">
		<div class="galleryArea">
			
			<% if(hList == null && fList == null) { %>
			<p> 등록된 호텔이 없습니다.</p>
			<% } %>
			<% for(Hotel h : hList) { %>
			<div class="gallery_list">
				<input type="hidden" value="<%= h.getHotel_id() %>">
				<div class="imgArea">
					<% for(Hotel_file f : fList) { %>
					<% if(h.getHotel_id() == f.getHotel_id()) { %>
					<img src="<%= f.getFile_url() %><%= f.getFile_rename() %>"
					width="200px" height="150px">
					<% } %>
					<% } %>	
				</div>
				<div>
					<div class="title1"><h4>호텔 이름 : <%= h.getHotel_name() %></h4></div>
					<div class="title2"><h5 class="gallery_title">관리자 : <%= h.getAccount_id() %></h5></div>
					<div class="title3"><h6>호텔 연락처 : <%= h.getHotel_phone() %></h6></div>
				</div>
			</div>
			<% } %>
		</div>
		<% if(loginUser != null) { %>
		<div class="btnArea">
			<button class="btn btn-secondary" onclick="location.href='<%= request.getContextPath() %>/views/Hotelinsert/hotelinsertView.jsp'">호텔등록</button>
		</div>
		<% } %>
	</div>
	
		<script>
		$(function(){
			$(".gallery_list").click(function(){
				var Hotel_id = $(this).children().eq(0).val();
				location.href='<%= request.getContextPath() %>/hotelinsert/detail?Hotel_id=' + Hotel_id;
			});
		});
	
	</script>
</body>
</html>