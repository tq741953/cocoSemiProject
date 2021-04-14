<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, hotel.model.vo.*"%>
<%
	ArrayList<Hotel> list = (ArrayList<Hotel>) request.getAttribute("list");
	int hotelId = Integer.parseInt(request.getParameter("hotelId"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.outer {
	width : 1300px;
	height : 500px;
	margin : auto;
	position : relative;
}

	.btn {
		margin: 10px;
	}
	
	.btnOuter {
		margin : auto;
	}
	
	.info1{
	width : 200px;
	height : 200px;
	background-color : white;
	border-radius : 40px;
	margin : 20px;
	display : inline-block;
}

img {
	width: 130px;
  	height: 130px;
  	background-color : rgb(141, 145, 149);
  	border-radius: 30px;
  	margin-top: 20px;
}
</style>
<body>
	<%@ include file="../common/mainMenubar.jsp"%>

	<div class="outer">
		<div class="btnOuter">
		<%if(list.get(0).getStatus().equals("Y")){ %>
			<div class="icons">
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon4.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id=hNoticeBtn>공지사항 관리</button>
            </div>
          </div>
          
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon7.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="hotelQNABtn">Q&A 관리</button>
            </div>
          </div>
          
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon6.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="hotelReservationBtn">예약/결제내역 조회</button>
            </div>
          </div>
          
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/Tilda_Icons_1ed_book.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="hotelReviewBtn">리뷰 조회</button>
            </div>
          </div>
          
         	<div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon5.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="facilitiesBtn">객실등록</button>
            </div>
          </div>
         </div>
         </div>

			<input type="hidden" name="hotelId" value="<%=hotelId%>">
				
			<script>
			
			const hotelQNABtn = document.getElementById('hotelQNABtn');
			const hotelId = <%=loginUser.getHotelId()%>
			hotelQNABtn.addEventListener('click', function(){
				location.href="<%=request.getContextPath()%>/qna/list?hotelId=" + <%=hotelId%>;
			});
			
			const hNoticeBtn = document.getElementById('hNoticeBtn');
			hNoticeBtn.addEventListener('click', function(){
				location.href="<%=request.getContextPath()%>/hnotice/list?hotelId="+<%=hotelId%>;
			});
			
			const hotelReservationBtn = document.getElementById('hotelReservationBtn');
			hotelReservationBtn.addEventListener('click', function(){
				location.href="<%=request.getContextPath()%>/reservation/list?hotelId="+<%=hotelId%>;
			});
			
			const hotelReviewBtn = document.getElementById('hotelReviewBtn');
			hotelReviewBtn.addEventListener('click', function(){
				location.href="<%= request.getContextPath() %>/review/list2?hotelId="+<%=hotelId%>;
			});
			
			const facilitiesBtn = document.getElementById('facilitiesBtn');
			facilitiesBtn.addEventListener('click', function(){
				location.href="<%= request.getContextPath() %>/facilities/list?hotelId="+<%= hotelId %>;
			});
			</script>
			
			<% } else { %>
				<script>
					alert('가입 미승인 상태입니다.\n문의사항이 있으시다면 우측 하단 채널톡 이용 부탁드립니다.');
					document.location.href="<%= request.getContextPath() %>/myhotel/list";
				</script>
				
			<% } %>
		</div>
	</div>
</body>
</html>