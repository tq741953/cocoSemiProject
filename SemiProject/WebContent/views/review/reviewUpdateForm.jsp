<%@page import="javax.swing.plaf.basic.BasicBorders.RadioButtonBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.Review" 
    import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Review r = (Review)request.getAttribute("list");
	int grade = r.getReview_grade();
	
	System.out.println(grade);
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
	 

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
		width:600px;
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	.reviewwrite{
		width : 600px;
		background: white;
		margin : auto;
	}
	.review_title{
		width : 600px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	.input_area {
		width : 600px;
		height : 60px;
	    background : white;
	    display : inline-block;
	}
	
	.input{
		width : 600px;
		height : 60px;
		padding-top : 10px;
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
		text-align:center;
		background-color : #343A40;
	}
  </style>
  
  
  </head>
  <body>
  	<%@ include file= "../common/menubar.jsp" %>
  	
  	<h1>리뷰 작성</h1>
    <p>고객님들의 진솔한 후기를 들려주세요!!!</p>
    <div class="outer">
        <div class="reviewwrite">
                <form id="listwrap"action="" method="post">
                	
                	 <input type="hidden" id="reviewNo"name="no" value="<%= r.getReview_no()%>" readonly>
                	<div class="review_title">예약번호</div>
                	<div class="input_area">
                      <input type="number" name="reservationNo" value="<%= r.getReservation_no() %>" readonly>
                    </div>
                	<div class="review_title">다녀온 숙소</div>
                	<div class="input_area">
                      <input type="text" name="hotelname" value="<%= r.getHotelName() %>" readonly>
                    </div>
                    <div class="review_title">리뷰 제목</div>
                    <div class="input_area">
                        <input type="text" name="title" value="<%= r.getReview_title() %>" >
                    </div><br>
                    <div class="review_title">작성자</div>
                    <div class="input_area">
                        <input type="text" name="id" value="<%= r.getAccount_id() %>" readonly>
                    </div><br>
                    <div class="review_title">작성일</div>
                    <div class="input_area">
                        <input type="text" name="createDate" value="<%= r.getCreate_date() %>" readonly>
                    </div><br>
                    <div class="review_title">수정일</div>
                    <div class="input_area">
                        <input type="text" name="modifyDate" value="<%= today %>" readonly>
                    </div><br>
                    
                    <div class="textarea2">
                      <div class="review_title">리뷰내용</div>
                      <textarea name="content" id="answert"><%= r.getReview_content() %></textarea>
                    </div>
                    
                    <div class="star-input">
                      <div class="review_title">별점</div>
                      <div class="input">
                        
                          <input type="radio" name="star-input" value="1" id="p1">
                          <label for="p1">1</label>
                          <input type="radio" name="star-input" value="2" id="p2">
                          <label for="p2">2</label>
                          <input type="radio" name="star-input" value="3" id="p3">
                          <label for="p3">3</label>
                          <input type="radio" name="star-input" value="4" id="p4">
                          <label for="p4">4</label>
                          <input type="radio" name="star-input" value="5" id="p5">
                          <label for="p5">5</label>
                       <output for="star-input"><b></b>점</output>
                        </div>
                       
					</div>
					
                    <div class="btnArea">
                         <button type="button" class="btn btn-secondary" onclick="javascript:history.back();">뒤로</button>
                        <button type="button" class="btn btn-secondary" id="updateBtn">수정완료</button>
                    </div>    
                    </form>
                </div>
			</div>
         <script >
         // 체크된 상태로 가져오기 
   			$(function(){
				
      			var grade = '<%= r.getReview_grade() %>';
      			
       			$('input:radio[name="star-input"][value="' + grade + '"]').prop('checked', true);
       			
  		 	});
         
			   // 수정하기 버튼 이벤트
			   const updateBtn = document.getElementById('updateBtn');
			   updateBtn.addEventListener('click', function(){
				   $("#listwrap").attr("action", "<%= request.getContextPath() %>/review/update");
				   $("#listwrap").submit();
				});
			
        
  		</script>
           
 </body>
</html>
  