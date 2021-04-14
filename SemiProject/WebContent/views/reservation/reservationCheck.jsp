<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.Review, java.util.Date, java.text.SimpleDateFormat"
     import="account.model.vo.Account" %>
<%
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist");
%>

<!doctype html>
<html lang="ko">
  <head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<style>
h1, p {
	color : white;
}

.outer {
	width : 1200px;
	 margin : auto;
}
.tableArea{
	width: 1200px;
	min-height : 99px;
	padding : 0px;
	background : white;
}
#reservationCheckList{
	 	text-align:center;
		margin:auto; 
}
	table tr{
	color:black;
	}
	table th{
		height : 45px;
		color:#B3B3B3; 
		background-color : #343A40;
	}
	
	table td{
	height : 45px;
	background-color : white;
	}
	
	#reservationCheckList th:nth-child(1) {
		width : 100px;
	}
	
	#reservationCheckList th:nth-child(2) {
		width : 300px;
	}
	
	#reservationCheckList th:nth-child(3) {
		width : 100px;
	}
	
	#reservationCheckList th:nth-child(4) {
		width : 150px;
	}
	
	#reservationCheckList th:nth-child(5) {
		width : 150px;
	}
	#reservationCheckList th:nth-child(6) {
		width : 150px;
	}
	#reservationCheckList th:nth-child(7) {
		width : 80px;
	}
	#reservationCheckList th:nth-child(8) {
		width : 80px;
	}
	#reservationCheckList th:nth-child(9) {
		width : 100px;
	}
	#reservationCheckList th:nth-child(10) {
		width : 200px;
	}
	#reservationCheckList th:nth-child(11) {
	width : 200px;
	}
</style>
  
  </head>
  <body>
 	 <%@ include file="../common/menubar.jsp"%>
    <h1>예약확인</h1>
    <p>예약한 객실을 확인합니다.</p>
    <div class="outer">
      <div class="table_area">
 
        <table border="2" id="reservationCheckList">
            <caption>예약리스트</caption>
            <thead>
               <tr>
                    <th>예약번호</th>
                    <th>호텔명</th>
                    <th>객실번호</th>
                    <th>예약한이름</th>
                    <th>입실일</th>
                    <th>퇴실일</th>
                    <th>인원수(성인)</th>
                    <th>인원수(아동)</th>
                    <th>예약상태(Y/N)</th>
                    <th>리뷰</th>
                    <th>예약취소상태</th>
                </tr>
            </thead>
            <tbody>
            
            <% if(rlist.size() == 0 || loginUser.getAccountId().isEmpty())  { %>
				<tr>
					<td colspan="100%">존재하는 list가 없습니다.</td>
				</tr>
				<% } else if(rlist.size()!= 0 && loginUser != null){ 
				for(Review r : rlist) { 
					
					if(r.getAccount_id().equals(loginUser.getAccountId())) { %>
				 <tr>
                    <td><%= r.getReservation_no() %></td>
                    <td><%= r.getHotelName() %></td>
                    <td><%= r.getRoomNo() %></td>
                    <td><%= r.getGuestName() %></td>
                    <td><%= r.getCheckIn() %></td>
                    <td><%= r.getCheckOut() %></td>
                    <td><%= r.getAdultCount() %>명</td>
                    <td><%= r.getChildCount() %>명</td>
                    <td><%= r.getStatus() %></td> 
                    <% if(r.getCheckReservation() > 0 || r.getStatus().equals("N")) { %>                     
                    <td><button id="review_btn" cols="3" disabled>작성완료</button></td>
                    <% } else if(r.getCheckReservation() == 0 || r.getStatus().equals("Y")) { %>
                    
                     <td><button id="review_btn" cols="3">작성하기</button></td>
                            	
				<% 	}%>
				<% if(r.getStatus().equals("Y")){ %>
					<td><a id="cancel_btn" cols="3">예약취소</a></td>
					<% } else if(r.getStatus().equals("N")){ %>
					<td><button id="review_btn" cols="3" disabled>취소완료</button></td>
					<% } %>
                </tr>
				
               
                <% }
				}
				
		}%>
        
            </tbody>
            </div>
        </div>
    </table>
   
    <script>
    $(function(){
		$("#reservationCheckList td button").mouseenter(function(){
			$(this).css({"color":"tomato", "cursor" : "pointer"});
		}).mouseout(function(){
			$(this).css("color", "black");
		}).click(function(){
			var no = $(this).parent().parent().children().eq(0).text();
			location.href="<%=request.getContextPath() %>/review/insertForm?no=" + no; 
		});
		
		$("#reservationCheckList td a").mouseenter(function(){
			$(this).css({"color":"tomato", "cursor" : "pointer"});
		}).mouseout(function(){
			$(this).css("color", "black");
		}).click(function(){
			var no = $(this).parent().parent().children().eq(0).text();
			location.href="<%=request.getContextPath() %>/reservation/delete?no=" + no; 
		});
	});
    </script>
        
      </div>
    </div>
  </body>
</html>