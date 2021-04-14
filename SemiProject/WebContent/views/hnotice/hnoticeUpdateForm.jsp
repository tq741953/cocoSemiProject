<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="hnotice.model.vo.HNotice, java.util.*"%>
<%
   List<HNotice> nlist = (List<HNotice>)request.getAttribute("nlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		min-width : 700px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1{
	color : white;
	}
	
	.tableArea{
		width : 700px;
		background: white;
		margin : auto;
		text-align:center;
	}
	
	.notice_title{
		width : 700px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
		text-align:center;
	}
	
	.input_area {
		width : 700px;
		height : 50px;
	    background : white;
	    display : inline-block;
	    text-align : center;
	}
	
	.input_area input {
		width : 700px;
		height : 50px;
		border: none;
		text-align:center;
	}
	
	textarea {
		width : 700px;
		height : 300px;
		border: none;
		text-align:center;
	}
	.btnArea {
		width : 700px;
		text-align:center;
		color:#B3B3B3; 
		background-color : #343A40;
	}
	
</style>
</head>
<body>
   <%@ include file = "../common/menubar.jsp" %>
	<h1>공지사항 수정 페이지</h1>
   <div class="outer">
      <div class="tableArea">

         <form action="<%= request.getContextPath() %>/hnotice/updateForm" method="post">
            <!-- 공지사항 글 번호를 화면에는 보이지 않게 request의 parameter로 넘긴다 -->
            <input type="hidden" name="hnno" value="<%= nlist.get(0).getHnNo() %>">
         
				<div class="notice_title">제목</div>
				<div class="input_area">
               <input type="text" name="title" value="<%= nlist.get(0).getHnTitle() %>">
				</div>
            
				<div class="notice_title">작성자</div>
				<div class="input_area">
               <input type="text" name="writer" value="<%= nlist.get(0).getHotelName() %>" readonly>
				</div>
            
				<div class="notice_title">작성일</div>
				<div class="input_area">
               <input type="date" name="date" value="<%= nlist.get(0).getCreate_date() %>" readonly>
				</div>
            
				<div class="notice_title">내용</div>
				<textarea name="content" style="resize:none;"><%= nlist.get(0).getHnContent() %></textarea>
            
            <div class="btnArea">
               <button type="button" class="btn btn-secondary" onclick="javascript:history.back();">취소</button>
               <button type="submit" class="btn btn-secondary" id="updateBtn">수정하기</button>
            </div>
         </form>
      </div>
   </div>
   
</body>
</html>