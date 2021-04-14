<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Hotelinsert.model.vo.*, java.util.*, account.model.vo.Account"%>
<%
	List<Hotel> h = (List<Hotel>)request.getAttribute("hotel");
	List<Hotel_file> Hotel_file = (List<Hotel_file>)request.getAttribute("hotel_file");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:700px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1 {
		color : white;
	}
	
	.fcilities_title{
		width : 700px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	
	.fcilities_content{
		width : 700px;
		height : 50px;
		padding-top : 10px;
	}
	
	
	.galleryArea{
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
	<%@ include file="../common/menubar.jsp" %>
	<h1>호텔 상세 페이지</h1><br>
	<div class="outer">
		<div class="galleryArea">
			<div class="inline">
				<div class="fcilities_title">호텔 관리자 ID</div>
				<div class="fcilities_content"><%= loginUser.getAccountId() %></div>
			</div>
			
			<div class="inline">
				<div class="fcilities_title">업체명</div>
				<div class="fcilities_content"><%= h.get(0).getHotel_name() %></div>
			</div>
			
			<div class="inline">
				<div class="fcilities_title">주소</div>
				<div class="fcilities_content"><%= h.get(0).getHotel_address() %></div>
			</div>
			
			<div class="inline">
				<div class="fcilities_title">연락처</div>
				<div class="fcilities_content"><%= h.get(0).getHotel_phone() %></div>
			</div>
			
			<div class="fcilities_title">대표 이미지</div>
			<div class="thumbnailImgArea">
				<img class="thumbnailImg" 
				src="<%= Hotel_file.get(0).getFile_url() %><%= Hotel_file.get(0).getFile_rename() %>">
			</div>
			
			<div class="detailImgAreaOuter">
			<% for(int i = 1; i < Hotel_file.size(); i++) { %>
				<div class="detailImgArea">
					<img id="detailImg" class="detailImg"
					src="<%= Hotel_file.get(i).getFile_url() %><%= Hotel_file.get(i).getFile_rename() %>">
					<br>
				</div>
			<% } %>
			</div>
			
		</div>
		<div class="btnArea">
			<button type="button" class="btn btn-secondary" onclick="javascript:history.back();">목록으로</button>
		</div>
	</div>
	
</body>
</html>