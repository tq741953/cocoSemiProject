<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.*, java.util.*"%>
<%
	List<Hotel> HList = (List<Hotel>)request.getAttribute("HList");
	List<Review> LList = (List<Review>)request.getAttribute("LList");
	int avg = (Integer)request.getAttribute("avg");
	List<RoomFile> rList = (List<RoomFile>)request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#roomImg{
	 width : 300px;
  	height : 150px;
    display: inline-block;
    vertical-align: top;
}
#roomImgDiv{
     margin: 0 auto;
     text-align: center; 
     font-size: 0;
}
.outer {
	width : 900px;
	display : inline-block;
}
.left_side{
	background-color: white;
	display : inline-block;
	float: left;
	width: 65%;
}
.hotelimg{
	width : 500px;
	height : 400px;
	margin-top : 20px;
	text-align : center;
}
.mdi-star {
   color : yellow;
}

.right_side {
	background-color: #B3B3B3;
	display : inline-block;
	float: left;
	width: 35%;
}
.cardheader {
	height : 52px;
	padding-top : 10px;
	color: #B3B3B3;
	background-color: #343A40;
}
.contentBack {
	background-color : white;
}
.title {
	color: #B3B3B3;
	background-color: #343A40;
	font-size : 35px;
}
.card-title{
	font-size  : 30px;
	border-style: dashed;
}
.card-body-2nd{
	box-shadow: 0px 0px 5px 3px #000;
	margin : 5px;
	border : none;
	background-color: white;
}

.aclass {
	font-size : 20px;
	color : #343A40;
	font-weight : bold;
}

.left-title{
	width : 50px;
	display : inline-block;
}

.right-side{
	width : 240px;
	display : inline-block;
}
.lineArea{
	width : 300px;
	display : inline-block;
}

.linkArea{
	width : 150px;
	margin : auto;
	background :#B3B3B3; 
}

</style>

</head>
<body>
	<%@ include file= "../common/menubar.jsp" %>
	<!-- Page Content -->
	<div class="outer">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="left_side">

				<div class="title">
					숙소 상세 보기
				</div>

				<!-- Blog Post -->
				<div class="cardouter">
					<img class="hotelimg" src="<%= HList.get(0).getFile_url() %><%= HList.get(0).getFile_rename() %>"
						alt="Card image cap">
						<div id="roomImgDiv">
					<% for(int i = 0; i < rList.size(); i++) { %>
					<% if(rList.size() != 0) { %>
							<img id="roomImg" src="<%= request.getContextPath() %><%= rList.get(i).getFile_url() %><%= rList.get(i).getFile_rename() %>">
					<% }
						}%>
						</div>
						<div class="card-body">
							<h2 class="card-title">
								<%= HList.get(0).getHotel_name() %>
							</h2>
							<p class="card-text">
							<%= HList.get(0).getHotel_address() %><br>
							<%= HList.get(0).getHotel_phone() %>
							</p>
							<hr>
							<h5>숙소 시설</h5>
							<p class="card-text"><%= HList.get(0).getHotel_service() %></p>
							<input type="hidden" id="payment" value="<%= HList.get(0).getRoom_no() %>">
							<h4><%=HList.get(0).getRoom_price() %>원</h4>
							<button onclick="goPayment();" class="btn btn-secondary">이 상품 결제하러가기 &rarr;</button>
						</div>
						<div class="card-footer text-muted">
							Posted on March 10, 2021 by COCONENNE
						</div>
					</div>
				</div>
			<script>
				function goPayment(){
					var rNo = document.getElementById('payment').value;
					// console.log(rNo);
					location.href='<%= request.getContextPath() %>/hotel/payment?rNo=' + rNo;
				};
			</script>

			<!-- 사이드바 -->
			<div class="right_side">
				<!-- 정렬 기준-->
				<div class="cardouter">
					<h5 class="cardheader">지도에서 보기</h5>
					<div class="card-body">
						<div class="input-group">
						<div id="map" style="width:500px;height:400px;"></div>
						<p>&uarr;카카오 맵에서 보기</p>
						</div>
					</div>
				</div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=181adfdd452e4bb2bbe7762f0cd19d34&libraries=services"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('<%= HList.get(0).getHotel_address() %>', function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%= HList.get(0).getHotel_name() %></div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
    } 
});    
</script>
				<!-- 후기 -->
				<div class ="cardouter">
					<button class="btn btn-secondary" id="HotelQnA">호텔에 문의하기</button>
					<button class="btn btn-secondary" id="HotelNotice"><%= HList.get(0).getHotel_name() %> 공지사항</button>
				</div>
				<div class="cardouter">
					<h5 class="cardheader">이용자 후기</h5>
					<div class="card-body-2nd">
					<% if(LList.size() != 0) {%>
						<div>
						<div class="lineArea">
							<div class="left-title">이름 : </div> <div class="right-side"><%= LList.get(0).getName() %></div>
						</div>
						<div class="lineArea">	
							<div class="left-title">제목 : </div> <div class="right-side"><%= LList.get(0).getReview_title() %></div>
							<div><%= LList.get(0).getReview_content() %></div>
							<div class="linkArea"><a class="aclass" href="<%= request.getContextPath() %>/hotel/reviewDetail?hId=<%= HList.get(0).getHotel_id() %>"><small>후기 더 보기</small></a></div>
						</div>
						</div>
					<% } else { %>
					<p>리뷰가 없습니다.. 이 호텔을 사용하고 리뷰를 달아주세요</p>
					<% } %>
					</div>
				</div>
				<!-- 평균 평점 -->
				<div class="cardouter">
					<h5 class="cardheader">평균 평점</h5>
					<div class="card-body">
						<div class="input-group">
						평점 : <% for(int i = 1; i <= avg; i++){ %><i class="mdi mdi-star"></i><% } %> <%= avg %>점
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" class="hotelId" value=<%for(int i = 0; i < HList.size(); i++) { %><%= HList.get(i).getHotel_id()%><%} %>>
		</div>
		<script>
			const HotelQnA = document.getElementById('HotelQnA');
			const hotelId = $(".hotelId").val();
			HotelQnA.addEventListener('click', function(){
				location.href="<%=request.getContextPath()%>/qna/list?hotelId=" + hotelId;
			});
			
			HotelNotice.addEventListener('click', function(){
	            location.href="<%=request.getContextPath()%>/hnotice/list?hotelId=" + hotelId;
	         });
		</script>
	</div>
</body>
</html>