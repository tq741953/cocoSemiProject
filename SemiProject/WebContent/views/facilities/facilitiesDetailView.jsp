<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="facilities.model.vo.*, java.util.*, account.model.vo.Account"%>
<%
	List<Facilities> f = (List<Facilities>)request.getAttribute("facilities");
	List<Room_file> room_file = (List<Room_file>)request.getAttribute("room_file");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 바깥 영역 */
	.outer{
		width:600px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1{
		color : white;
	}
	
	.galleryArea{
		width:600px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		background: white;
		margin:auto;
	}
	
	.fcilities_title{
		width : 600px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	
	.fcilities_content {
		width : 600px;
		height : 60px;
	    background : white;
	    padding-top : 10px;
	    display : inline-block;
	}
	
	.fcilities_content input {
		width : 600px;
		height : 60px;
		border: 0px;
		text-align : center;
	}	
	.thumbnailImgArea {
		width : 600px;
		min-height : 60px;
		background : white;
		text-align:center;
	}
	.thumbnailImg {
		width:550px;
		height:300px;
	}
	.detailImgAreaOuter {
		text-align:center;
	}
	.detailImgArea {
		display:inline-block;
		text-align:center;
	}
	.detailImg {
		width:300px;
		height:180px;
	} 
	
	.btnArea {
		width : 600px;
		text-align:center;
		background-color : #343A40;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>객실 상세 페이지</h1><br>
	<div class="outer">
		<div class="galleryArea">
				<div class="fcilities_title">호텔 관리자 ID</div>
				<div class="fcilities_content"><%= loginUser.getAccountId() %></div>
			
			<div class="fcilities_title">대표 이미지</div>
			<% if(room_file.size() != 0) { %>
			<div class="thumbnailImgArea">
				<img class="thumbnailImg" 
				src="<%= request.getContextPath() %><%= room_file.get(0).getFile_url() %><%= room_file.get(0).getFile_rename() %>">
			</div>
			<% } %>
			<div class="detailImgAreaOuter">
			<% for(int i = 1; i < room_file.size(); i++) { %>
				<div class="detailImgArea">
					<img id="detailImg" class="detailImg"
					src="<%= request.getContextPath() %><%= room_file.get(i).getFile_url() %><%= room_file.get(i).getFile_rename() %>">
					<br>
				</div>
			<% } %>
			</div>
			

				<div class="fcilities_title">객실 수량</div>
				<div class="fcilities_content"><%= f.get(0).getRoom_count() %></div>

			

				<div class="fcilities_title">객실 이용금액</div>
				<div class="fcilities_content"><%= f.get(0).getRoom_price() %></div>
			
				<div class="fcilities_title">최대 이용 가능 인원</div>
				<div class="fcilities_content"><%= f.get(0).getRoom_maximum() %></div>
			
				<div class="fcilities_title">성인수</div>
				<div class="fcilities_content"><%= f.get(0).getAdult_count() %></div>
			
				<div class="fcilities_title">아동수</div>
				<div class="fcilities_content"><%= f.get(0).getChild_count() %></div>
			
				<div class="fcilities_title">침대 타입</div>
				<div class="fcilities_content"><%= f.get(0).getBed_type() %></div>
			
				<div class="fcilities_title">객실 타입</div>
				<div class="fcilities_content"><%= f.get(0).getRoom_type() %></div>
			
				<div class="fcilities_title">호텔 서비스</div>
				<div class="fcilities_content"><%= f.get(0).getHotel_service() %></div>
		</div>
		
		<div class="btnArea">
			<button type="button" class="btn btn-secondary" onclick="javascript:history.back();">목록으로</button>
		</div>
	</div>
</body>
</html>