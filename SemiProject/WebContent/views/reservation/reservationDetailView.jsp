<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="reservation.model.vo.Reservation"%>
<%
	Reservation r = (Reservation)request.getAttribute("reservation");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 바깥 영역 */
	.outer{
		width:700px;

		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
	}
	
	h1 {
		color : white;
	}
	
	.reservation_no{
		width : 700px;
		height : 50px;
		color:#B3B3B3; 
		background-color : #343A40;	
		padding-top : 10px;	
	}
	
	/* 공지사항 목록 영역 */
	.tableArea{
		width : 700px;
		background: white;
		margin : auto;
	}
	
	/* span 태그 */
	.input_area {
		width : 700px;
		height : 60px;
	    background : white;
	    display : inline-block;
	}
	
	/* textarea */ 
	textarea {
		width : 700px;
		height : 300px;
		border: none;
	}
	/* 버튼 영역 */
	.btnArea {
		width : 700px;
		text-align:center;
		color:#B3B3B3; 
		background-color : #343A40;
	}
</style>
</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<h1>예약 / 결제 상세 페이지</h1><br>
	<div class="outer">
		<div class="tableArea">

				<input type="hidden" name="no" value="<%= r.getReservation_no() %>" readonly>
		
			<h4 class="reservation_no">투숙객이름</h4>
			<span class="input_area">
			<input type="text" name="ID" value="<%=r.getGuest_name()%>" readonly>
			</span>
			<h4 class="reservation_no">투숙객연락처</h4>
			<span class="input_area">
			<input type="text" name="phone" value="<%= r.getGuest_phone() %>" readonly>
			</div>
			<div class="reservation_no">객실번호</div>
			<div class="input_area">
			<input type="text" name="room" value="<%= r.getRoom_no() %>" readonly>
			</div>
			
			
			<h4 class="reservation_no">입실일</h4>
			<span class="input_area">
			<input type="text" name="in" value="<%= r.getCheck_in() %>" readonly>
			</span>
			<h4 class="reservation_no">퇴실일</h4>
			<span class="input_area">
			<input type="text" name="out" value="<%= r.getCheck_out() %>" readonly>
			</span>
						
			<h4 class="reservation_no">요청사항</h4>
			<%if(r.getRemark() != null) { %>
			<textarea name="content" style="resize:none;" readonly><%= r.getRemark() %></textarea>
			<% } else { %>
			<textarea name="content" style="resize:none;" readonly></textarea>
			<% } %>
			
			
			<h4 class="reservation_no">결제금액</h4>
			<span class="input_area">
			<input type="text" name="money" value="<%= r.getPay_price() %>" readonly>
			</span>
			<h4 class="reservation_no">결제여부</h4>
			<span class="input_area">
			<input type="text" name="pay" value="<%= r.getPay_status() %>" readonly>
			</span>
			<h4 class="reservation_no">예약상태</h4>
			<span class="input_area">
			<input type="text" name="reservation" value="<%= r.getStatus() %>" readonly>
			</span>
			
			
			<h4 class="reservation_no">인원수(성인)</h4>
			<span class="input_area">
			<input type="text" name="adult" value="<%= r.getAdult_count() %>" readonly>
			</span>
			<h4 class="reservation_no">인원수(아동)</h4>
			<span class="input_area">
			<input type="text" name="child" value="<%= r.getChild_count() %>" readonly>
			</span>
			
			<div class="btnArea">
				<button type="button" onclick="javascript:history.back();">이전으로</button>
			</div>
		</div>
	</div>

</body>
</html>