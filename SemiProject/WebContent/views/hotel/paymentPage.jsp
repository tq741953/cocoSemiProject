<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.*,java.util.*,java.text.*"%>
 <%
 	List<Hotel> list = (List<Hotel>)request.getAttribute("list");
 	String[] str= list.get(0).getHotel_service().split(",");
 	int searchAdult = (Integer)session.getAttribute("searchAdult");
 	int searchChild = (Integer)session.getAttribute("searchChild");
 	String checkIn = (String)session.getAttribute("checkIn");
 	String checkOut = (String)session.getAttribute("checkOut");
 	
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");	// 날짜 차이 계산
 	long calDateDays = 0;
 	try{
 	Date dCheckIn = sdf.parse(checkIn);
 	Date dCheckOut = sdf.parse(checkOut);
 	long calDate = dCheckOut.getTime() - dCheckIn.getTime();
 	calDateDays = calDate / (24*60*60*1000);
 	// System.out.println("날짜 차이 : " + calDateDays);
 	}
 	catch(ParseException e){
 		
 	}
 	int setReservation = list.get(0).getRoom_count() - list.get(0).getCheckedRoom();
 	int RoomCount = 0;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	width : 900px;
	height : 900px;
	display : inline-block;
}
.calc p {
	float: left;
}

.left_side{
	background-color: white;
	height : 750px;
	display : inline-block;
	float: left;
	width: 65%;
}

.right_side {
	height : 750px;
	background-color: white;
	display : inline-block;
	float: left;
	width: 35%;
}

form{
	width : 900px;
	height : 750px;
	display : inline-block;
}

.titlename {
	height: 50px;
	font-size: 25px;
	color: #B3B3B3;
	background-color: #343A40;
	text-align: center;
}

.input_area {
	width: 200px;
	height: 50px;
	background-color: white;
	margin : auto;
	display: inline-block;
	border: lightblue;
}

.info {
	width: 380px;
	height: 55px;
	margin : auto;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

.info_title {
	width: 180px;
	height: 40px;
	background-color: rgb(86, 88, 90);
	border: none;
	text-align: center;
	text-size: 13px;
	float: left;
	margin: 0px auto;
	display: inline-block;
	color: white;
	/*color : rgb(52, 152, 219);*/
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}

#info {
	width: 350px;
	margin: auto;
	padding-top: 20px;
}

#name, #phone {
	width: 200px;
	height: 40px;
	margin: 0px;
	padding-left: 10px;
	font-size: 13px;
	background-color: rgb(141, 145, 149);
	border: lightblue;
	font-size: 13px;
	display: inline-block;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

 #infoArea {
            width : 400px;
            height : 350px;
            margin : auto;
            text-align : center;
            background-color: white;
            border : none;
            border-radius: 20px;
        }
.title {
   margin : auto;
   padding-top : 5px;
   text-size : 13px;
   color : white;
   }
  
.leftInside{
	margin : auto;
}
#finalPay {
	width:100px;
	text-align:center;
}
</style>

</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<div class="outer">
			<form action="<%=request.getContextPath()%>/hotel/kakaopay" method="Post">

		<div class="left_side">
			<div class="leftInside">
			<input type="hidden" name="rNo" value="<%=list.get(0).getRoom_no()%>">
			<div class="titlename">고객님의 정보를 입력 해주세요</div>
			<p>**투숙객과 정보가 일치해야합니다!!</p>
			<div class="infoArea">
				<div class="info">
					<div class="info_title"><div class="title">이름(Name)</div></div>
					<div class="input_area">
					<input type="text" id="name" name="guestName"><br>
					</div>
				</div>
				<div class="info">
					<div class="info_title"><div class="title">전화번호(-빼고 입력)</div></div>
					<div class="input_area">
					<input type="tel" id="phone" name="guestPhone">
					</div>
				</div>
			</div>
			</div>
			<div class="card mb-4">
			<div class="titlename" style="text-align : center;">특별요청하기</div>
			<p>**특별 요청 사항 반영 여부는 숙소 여건에 따라 달라질 수 있습니다. <br>
			예약완료 즉시 요청 사항을 숙소/호스트에게 전달하겠습니다.**</p><hr>			
				<p style="font-weight : bold;">특별 요청사항 추가하기</p>
				<textarea style="width : 400px; height : 100px; resize : none; margin : auto;" name="specialrq"></textarea>
			</div>
			<div class="card mb-4">
			<p style="font-weight : bold;">&lt;&lt;예약 객실 수&gt;&gt;</p>
				<label for="RoomCount"><%= list.get(0).getRoom_type() %></label>
				<select id="RoomCount" name="roomCount" style="width:200px; height:30px; margin : auto;">
				<% for(int i = 1; i <= setReservation;i++){ %>
					<option value="<%= i %>"><%= i %></option>
					<% } %>
				</select>
			<p>** 객실 최대인원 - 객실 1개당 성인<%= list.get(0).getAdult_count() %>명 아동(0~5세) <%= list.get(0).getChild_count() %>명</p>
			<p>현재인원 : 성인<%= searchAdult %> 명, 어린이<%= searchChild %>명</p>
			</div>
		</div>
		
		
		 <!-- 사이드바 -->
		 <div class="right_side">
		        <!-- 정렬 기준-->
			        <div class="card my-4">
			          <h5 class="card-header-2nd" name="hotelName"><%= list.get(0).getHotel_name() %></h5>
			          <p name="hotelAddress"><%= list.get(0).getHotel_address() %></p>
			          <p name="hotelPhone"><%= list.get(0).getHotel_phone() %></p>
			          <div class="card-body">
			            <img class="card-img-top" src="<%= list.get(0).getFile_url() %><%= list.get(0).getFile_rename() %>" alt="Card image cap">
			            <h5><small name="checkIn"><%= checkIn %>~</small></h5>
			            <h5><small name="checkOut"><%= checkOut %></small></h5>
			            <p><small name="roomType"><%= list.get(0).getRoom_type() %></small></p>
			            <br>
			            <div class="calc">
			            <p><%= calDateDays %> 박 =</p>
			            <p id="originPay"> <%= calDateDays * list.get(0).getRoom_price() %></p>
			            <p>원</p>
			            </div>
			            <br>
			            <hr>
			            	<p>최종 요금 : </p><input type="text" id="finalPay" name="finalPay" size='3' value='<%= (int)((calDateDays * list.get(0).getRoom_price()) + (calDateDays * list.get(0).getRoom_price()*0.1)) %>' readonly style="border : none;">
			            	<span id='paymentRoomCount' style="display : inline-block;"></span>
			            <p><small>포함 tax : 요금의 10%</small></p>
			            <button type="submit" class="btn btn-secondary">결제하기</button>
			
			          
			        	</div>
	       			</div>
	       		
	       		</div>
	        </form> 	
	   </div>		
	       		
	       		
	       		
			<script>
				var RoomCount = document.getElementById('RoomCount').value;
				var originPay = document.getElementById('originPay').innerHTML;
				var finalPay = document.getElementById('finalPay');
				$("#RoomCount").on('change', function(){
					var fees = originPay * 0.1;
					$("#finalPay").empty();
					$("#finalPay").val(parseInt($("#RoomCount").val()) * (parseInt(originPay)+parseInt(fees)));
					// console.log(fees);
				});
			</script>
			



</body>
</html>