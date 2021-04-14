<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.Review" 
    import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
%>
    <!doctype html>
<html lang="ko">
  <head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<style>
h1, p {
	color : white;
}
	.outer{
		width : 1200px;
		min-width : 200px;
		background: rgb(248, 249, 250);
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1{
		color : white;
	}
	
	/* 공지사항 목록 영역 */
	.tableArea{
		width : 1200px;
	}
	
	/* 공지사항 테이블 */
	#listTable{
		width : 1200px;
		border:1px solid white;
	 	text-align:center;
		margin:auto; 
	}
	
	table th{
		height : 50px;
		color:#B3B3B3;
		background-color : #343A40;
	}
	
	table td{
		height : 50px;
		background-color : white;
	}
	.tableArea {
		width : 1200px;
	}
	
	#listTable th:nth-child(1) {
		width : 100px;
	}
	
	#listTable th:nth-child(2) {
		width : 100px;
	}
	
	#listTable th:nth-child(3) {
		width : 300px;
	}
	
	#listTable th:nth-child(4) {
		width : 300px;
	}
	
	#listTable td:nth-child(4) {
		  overflow: hidden;
		  text-overflow: ellipsis;
		  white-space: nowrap;
	}
	
	#listTable th:nth-child(5) {
		width : 100px;
	}

	#listTable th:nth-child(6) {
		width : 150px;
	}
	
	#listTable th:nth-child(7) {
		width : 150px;
	}	
</style>

  
</head>
  <body>
	<%@ include file="../common/menubar.jsp" %>
	<h1>리뷰작성</h1>
    <p>작성한 리뷰를 확인합니다.</p>
	
    <div class="outer">
      <div class="tableArea">

            <table border="1" id="listTable">
              <thead>
                <tr>
                  <th>리뷰번호</th>
                  <th>예약번호</th>
                  <th>제목</th>
                  <th>호텔이름</th>
                  <th>작성ID</th>
                  <th>내가준점수</th>
                  <th>작성일</th>
                  
                </tr>
              <% for(Review r : list) { %>
              </thead>
              <tbody class="faqlist">
                <tr>
                  <td><%= r.getReview_no()  %></td>
                  <td><%= r.getReservation_no() %></td>
                  <td><%= r.getReview_title() %></td>
                  <td><%= r.getHotelName() %></td>
                  <td><%= r.getAccount_id() %></td>
                  <td><%= r.getReview_grade() %>
                  <td><%= r.getCreate_date() %></td>
                  
                </tr>
               <% } %>
              </tbody>
            </table>
         </div>
      </div>
            
            
            <script>
      $(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor" : "pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "rgb(248, 249, 250)");
			}).click(function(){
				// 쿼리 스트링을 이용하여 get 방식(url 노출)으로 글번호를 parameter로 전달
				var no = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/review/detail?no=" + no;
				
			});
		});
      
      
      
      </script>