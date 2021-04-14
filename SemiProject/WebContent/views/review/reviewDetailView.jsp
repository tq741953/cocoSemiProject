<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="review.model.vo.*"%>
<%
	Review r = (Review)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:600px;
		background : white;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1 {
		color : white;
	}
	
	.reservation_no{
		width : 600px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	
	.input_title{
		width : 600px;
		height : 50px;
		padding-top : 10px;
	}
	
	
	.tableArea{
		width:600px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	.input_area {
		width : 600px;
		height : 60px;
	    background : white;
	    display : inline-block;
	}
	
	.input_area input {
		width : 600px;
		height : 60px;
		border: 0px;
		text-align : center;
	}
	
	textarea {
		width : 600px;
		height : 300px;
		border: none;
	}
	.btnArea {
		width : 600px;
		text-align:center;
		background-color : #343A40;
	}
</style>
</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<h1>리뷰 상세 페이지</h1><br>
	<div class="outer">
		<div class="tableArea">
			
			<div class="reservation_no">리뷰번호</div>
			<div class="input_area">
			<input type="text" class="input_title" name="no" value="<%= r.getReview_no() %>" readonly>
			</div>
			
			<div class="reservation_no">예약자</div>
			<div class="input_area">
			<input type="text" class="input_title" name="no" value="<%= r.getName() %>" readonly>
			</div>
			
			<div class="reservation_no">예약번호</div>
			<div class="input_area">
			<input type="text" class="input_title" name="no" value="<%= r.getReservation_no() %>" readonly>
			</div>
			
			<div class="reservation_no">리뷰 내용</div>
			<textarea name="content" style="resize:none;" readonly><%= r.getReview_content() %></textarea>
			
			<div class="reservation_no">작성일</div>
			<div class="input_area">
			<input type="text" class="input_title" name="no" value="<%= r.getCreate_date() %>" readonly>
			</div>
			
			<div class="reservation_no">평점</div>
			<div class="input_area">
			<input type="text" class="input_title" name="no"  value="<%= r.getReview_grade() %>점" readonly>
			</div>
			
			<div class="btnArea">
				<button type="button" class="btn btn-secondary" onclick="javascript:history.back();">이전으로</button>
			</div>
		</div>
	</div>
</body>
</html>