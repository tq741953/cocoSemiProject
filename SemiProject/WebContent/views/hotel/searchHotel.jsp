<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, hotel.model.vo.*"%>
<%
	ArrayList<Hotel> list = (ArrayList<Hotel>) request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	String searchValue = request.getParameter("searchValue");
	int searchAdult = Integer.parseInt(request.getParameter("searchAdult"));
	int searchChild = Integer.parseInt(request.getParameter("searchChild"));
	String checkIn = (String)request.getSession().getAttribute("checkIn");
	String checkOut = (String)request.getSession().getAttribute("checkOut");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>코코넨네</title>
<style>
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

h3{
	color : #343A40;
}

.hotelimg{
	width : 500px;
	height : 400px;
	margin-top : 20px;
	text-align : center;
}

.right_side {
	background-color: #B3B3B3;
	display : inline-block;
	float: left;
	width: 35%;
}
.title {
	color: #B3B3B3;
	background-color: #343A40;
	font-size : 35px;
}
.contentBack {
	background-color : white;
}
.input-group {
	width: 90% !important;
	margin : auto;
}

.input-group-re {
	width: 90% !important;
	margin : auto;
}

.input-group>.form-control {
	width: 100% !important;
	margin : auto;
	
}


.card-title{
	font-size  : 30px;
	border-style: dashed;
}

.service{
	background : lightgray;
	opacity : 70%;
	color : #343A40;
}


.cardheader {
	height : 50px;
	padding-top : 10px;
	color: #B3B3B3;
	background-color: #343A40;
}

.card-right{
	margin : 0px;
}

#sortBtnGroup>button {
	margin: 5px;
}
.detailHotel:hover{
	opacity:0.8;
    cursor:pointer;
}
.cardright-body{
	background : #B3B3B3;
}
#noticeP{
	color : red;
}
a:link { color: black; text-decoration: none;}

a:visited { color: black; text-decoration: none;}
 
a:hover { color: black; text-decoration : none;}

.list-unstyled{
	margin : auto;
}

</style>
</head>

<body>

	<%@ include file="../common/menubar.jsp" %>

	<!-- Page Content -->
	<div class="outer">
		<div class="row">
			<!-- Blog Entries Column -->
			<div class="left_side">
				<div class="title">
					맞춤 검색 결과
				</div>
				<!-- 검색 결과 조회 -->
				<div class="cardouter">
					<!-- 검색 결과가 없을 경우 -->
					<%
						if (list.isEmpty()) {
					%>
					<div class="card-body">
						<h3>존재하는 검색 결과가 없습니다.</h3>
					</div>
					<%
						} else {
							for (Hotel h : list) {
								
					%><!-- 검색 결과가 있을 경우 -->
					<img class="hotelimg" src="<%= h.getFile_url() %><%= h.getFile_rename() %>" alt="Card image cap">
					<div class="card-body detailHotel">
						<div class="card-title"><%=h.getHotel_name()%></div>
						<hr>
						<div>
							<div class="service">제공되는 서비스 : <%= h.getHotel_service() %></div>
							 <h3><%= h.getRoom_price() %>원 <small><small><small>**tax 비 포함 **</small></small></small></h3>
						</div>
						<% if(h.getCheckedRoom() == h.getRoom_count()||h.getCheckedRoom() >= h.getRoom_count()) { %>
						<p style="color :red">해당 숙소는 예약이 완료 되었습니다. 다른 호텔을 이용해 주세요.</p>
						<% } %>
						<% if(loginUser != null && h.getCheckedRoom() < h.getRoom_count()) { %>
						<a id="cardA" href='<%= request.getContextPath() %>/hotel/detail?room_no=<%= h.getRoom_no() %>'>		
						<button type="button" class="btn btn-secondary" id="goDetail">호텔 상세정보 보러가기 &rarr;</button>
						</a>
						<% } %>
						<%if(loginUser == null){ %>
							<button type="button" class="btn btn-secondary goLogin" id="goLogin">호텔 상세정보 보러가기 &rarr;</button>
						<% } %>
					</div>
					<div class="card-footer text-muted">
						Posted on January 1, 2020 by <a href="<%= request.getContextPath() %>">(주) 코코넨네</a>
					</div>
					<%
						}
						}
					%>
				</div>
					<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>	
					<p style='color : gray; text-align : center;'>마지막 검색 결과 입니다.</p>
					<% } %>
				<script>
					$(function(){
						$(".goLogin").click(function(){
							alert('로그인후 다시 이용해주세요.');
							location.href='<%= request.getContextPath() %>/views/account/loginForm.jsp';
						})
					})
				</script>
				<!-- 페이징 바 -->
				<ul class="pagination justify-content-center mb-4 pagingbar">
					<% if(pi.getCurrentPage() == 1) { %>
					<li class="page-item disabled"><button class="page-link" disabled>&larr; 이전페이지</button></li>
					<% }else{ %>
					<li class="page-item"><button class="page-link" onclick="location.href='<%= request.getContextPath() %>/hotel/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchValue=<%= searchValue %>&searchAdult=<%= searchAdult %>&searchChild=<%= searchChild %>'">&larr; 이전페이지</button></li>
					<%  } %>
					<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
					<li class="page-item disabled"><button class="page-link" disabled>다음페이지 &rarr;</button></li>
					<% }else{ %>
					<li class="page-item"><button class="page-link" onclick="location.href='<%= request.getContextPath() %>/hotel/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchValue=<%= searchValue %>&searchAdult=<%= searchAdult %>&searchChild=<%= searchChild %>'">다음페이지 &rarr;</button></li>
					<% } %>
				</ul>
			</div>

			<!-- 사이드바 -->
			<div class="right_side">
				<!-- 정렬 기준-->
				<div class="card-right">
					<h5 class="cardheader">정렬 기준</h5>
					<div class="cardright-body">
						<div class="input-group-re" id="sortBtnGroup">
							<button class="btn btn-secondary" type="button" id="sortPayment1">요금오름차순</button>
						</div>
					</div>
				</div>
				<!-- 다시 검색하기 -->
				<div class="card-right">
					<h5 class="cardheader">다시 검색하기</h5>
					<div class="cardright-body">
						<div class="input-group-re">
							<form id="retrySearchForm" method="post" action="<%=request.getContextPath()%>/hotel/search">
								<input type="text" class="form-control" id="searchValue" name="searchValue" placeholder="지역/호텔명">
									 <input type="date" class="form-control" id="checkin" name="checkIn" onchange="return checkInValidation(value);"> 
									 <input type="date" class="form-control" id="checkout" name="checkOut" onchange="return checkOutValidation(value);">
								 <select id="searchAdult" name="searchAdult">
									<option value='0'>-성인-</option>
									<option value='1'>성인 1인</option>
									<option value='2'>성인 2인</option>
									<option value='3'>성인 3인</option>
									<option value='4'>성인 4인</option>
									<option value='5'>성인 5인</option>
								</select> 
								<select id="searchChild" name="searchChild">
									<option value='0'>-아동-</option>
									<option value='1'>아동 1인</option>
									<option value='2'>아동 2인</option>
									<option value='3'>아동 3인</option>
									<option value='4'>아동 4인</option>
									<option value='5'>아동 5인</option>
								</select>
								<button class="btn btn-secondary" type="submit" id="retrySearchBtn" onclick="return checkSearch();">검색!</button>
							</form>
						</div>
					</div>
				</div>
				<script>
					document.getElementById('checkin').value = new Date()
							.toISOString().substring(0, 10);

					function checkInValidation(value) { /* 체크인  / 오늘 이전날짜 클릭시 alert */
						/* console.log(new Date(value) , new Date(new Date().toISOString().substring(0, 10))) 날짜 출력확인*/

						if (new Date(value) < new Date(new Date().toISOString()
								.substring(0, 10))) {
							alert(new Date().toISOString().substring(0, 10)
									+ " 이후 날짜만 선택이 가능합니다.");
							document.getElementById('checkin').value = new Date()
									.toISOString().substring(0, 10);
						};

						if (document.getElementById('checkout').value != null) {
							if (new Date(
									document.getElementById('checkout').value) <= new Date(
									document.getElementById('checkin').value)) {
								var later = new Date(document
										.getElementById('checkin').value);
								later.setDate(later.getDate() + 1);

								document.getElementById('checkout').value = later
										.toISOString().substring(0, 10);
							}
						}

					};

					function checkOutValidation(value) { /* 체크아웃 / 체크인 이전날짜 클릭시 alert */

						if (new Date(document.getElementById('checkout').value) <= new Date(
								document.getElementById('checkin').value)) {
							alert("체크아웃 날짜는 체크인날짜 이후만 선택이 가능합니다.");

							var later = new Date(document
									.getElementById('checkin').value);
							later.setDate(later.getDate() + 1);

							document.getElementById('checkout').value = later
									.toISOString().substring(0, 10);
						}
					};

					function checkSearch() {
						if ($("#searchValue").val().length == 0
								|| $("#checkin").val().length == 0
								|| $("#checkout").val().length == 0
								|| $("#searchAdult").val() == 0) {
							alert('모든 검색 조건을 입력후에 실행해주세요.');
							return false;
						}
						return true;
					};
				</script>
				<!-- Side Widget -->
				<div class="card-right">
					<h5 class="cardheader">
						요금범위<small>(1박당)</small>
					</h5>
					<div class="cardright-body">
						<div class="input-group-re">
							<form>
								<ul class="list-unstyled mb-0" style="width:130px">
									<li><input type="radio" id="payment1" name="payment" value="30000" style="margin-left:-8px;"> 30000~50000
									</li>
									<li><input type="radio" id="payment2" name="payment" value="50000"> 50000~100000
									</li>
									<li><input type="radio" id="payment3" name="payment" value="100000" style="margin-left:-30px;"> 100000++
									</li>
									<br>
									<button type="button" name="payment" id="paymentBtn" class="btn btn-secondary" style="margin-left:-25px">검색하기</button>
								</ul>
							</form>
						</div>
					</div>
				</div>
				<!-- Side Widget -->
				<div class="card-right">
					<h5 class="cardheader">
						추가 필터링
					</h5>
					<div class="cardright-body">
						<div class="input-group-re">
							<form action="<%= request.getContextPath() %>/hotel/sortFilter?searchAdult=<%= searchAdult %>&searchChild=<%= searchChild %>&searchValue=<%= searchValue %>&currentPage=<%= pi.getCurrentPage() %>" method="post">
								<ul class="list-unstyled mb-0">
									<li><input type="checkbox" name="filter" value="흡연가능"> 흡연가능객실</li>
									<li><input type="checkbox" name="filter" value="무료wifi" style="margin-left:-33px;"> 무료WIFI</li>
									<li><input type="checkbox" name="filter" value="조식" style="margin-left:-32px;"> 조식제공</li>
									<li><input type="checkbox" name="filter" value="피트니스 센터"> 피트니스센터</li>
									<li><input type="checkbox" name="filter" value="텐트제공" style="margin-left:-32px;"> 텐트제공</li>
									<li><input type="checkbox" name="filter" value="충전기" style="margin-left:-16px;"> 충전기대여</li>
									<li><input type="checkbox" name="filter" value="룸서비스" style="margin-left:-32px;"> 룸서비스</li>
									<br>
									<button type="submit" id="filterBtn" class="btn btn-secondary" style="margin-left:-25px">검색하기</button>
								</ul>
							</form>
						</div>
					</div>
				</div>
				<script>
					var searchAdult = <%= searchAdult %>;
					var searchChild = <%= searchChild %>;
					var searchValue = "<%= searchValue %>";
					var context = "<%= request.getContextPath() %>";
					var DESC = "DESC";
					var ASC = "ASC";
					var ROOM_PRICE = "ROOM_PRICE";
					
					// 가격 범위 정렬
					function sortPriceRange(currentPage, payment){
						// var payment = $("input[name='payment']:checked").val();
						var prev = (currentPage-1)+','+payment;
						var next = (currentPage+1)+','+payment;
						$.ajax({
							url : "<%=request.getContextPath() %>/hotel/sortPrice",
							type : "post",
							data : {currentPage : currentPage,
									searchValue : searchValue,
								 	searchAdult : searchAdult,
								 	searchChild : searchChild,
									payment : payment
							},
							dataType : "json",
							success : function(data){
								hotelList(data, prev, next, "sortPriceRange");
								
							},
							error : function(e){
								console.log(e);
							}
						});
					};
					// 가격 오름/내림 차순 정렬
				function sortPage(currentPage, order, sort) {
						// SORT- 정렬방식 ORDER- 테이블
					var prev = (currentPage-1)+','+order+','+sort;
					var next = (currentPage+1)+','+order+','+sort;
					$.ajax({
						url : "<%= request.getContextPath() %>/hotel/sortPayment",
						type : "post",
						data : { searchValue : searchValue,
								 searchAdult : searchAdult,
								 searchChild : searchChild,
								 currentPage : currentPage,
								 order : order,
								 sort : sort },
						dataType : "json",
						success : function(data){
							hotelList(data, prev, next, "sortPage");
						},
						error : function(e){
							console.log(e);
						}
					});
				}
					// 클릭 이벤트
					$(function(){
						$(document).on('click',"#sortPayment1",function(){
							sortPage(1, ROOM_PRICE,ASC);
							$("#sortPayment1").html('요금내림차순');
							$("#sortPayment1").attr('id','sortPayment2');
						});
						$(document).on('click',"#sortPayment2",function(){
							sortPage(1, ROOM_PRICE, DESC);
							$("#sortPayment2").html('요금오름차순');
							$("#sortPayment2").attr('id','sortPayment1');
						});
						$(document).on('click',"#paymentBtn",function(){
							var payment = $("input[name='payment']:checked").val();
							sortPriceRange(1, payment);
						});
						
					});
					
		               // ajax에 넣을것
		               function hotelList(data, prev, next, fn){
		                  console.log(data);
		                  $(".left_side").empty();
		                  $.each(data["slist"], function(i, value){
		                     var str = "<img class='hotelimg' src='"+value.file_url + value.file_rename+"' alt='Card image cap'>"
		                      + "<div class='card-body detailHotel'>"
		                      + "<div class='card-title'>"+value.hotel_name+"</div>"
		                      + "<hr>"
		                      + "<div class='service'>제공되는 서비스 : "+value.hotel_service+" </div>"
		                       + "<h3>"+value.room_price+"원 <small><small><small>**tax 비 포함 **</small></small></small></h3>"
		                      + "</div>";
		                      if(value.checkedRoom == value.room_count) {
		                     str+="<p style='color :red'>해당 숙소는 예약이 완료 되었습니다. 다른 호텔을 이용해 주세요.</p>"
		                      } 
		                     if(data["loginUser"] != null) {
		                     if(value.checkedRoom != value.room_count) {
		                     str+="<a id='cardA' href='"+context+"/hotel/detail?room_no="+value.room_no+"'>"
		                     }
		                     str+="<button type='button' class='btn btn-secondary' id='goDetail'>호텔 상세정보 보러가기 &rarr;</button>"
		                     str+="</a>"
		                      } 
		                     if(data["loginUser"] == null){ 
		                     str+="<button type='button' class='btn btn-secondary goLogin' id='goLogin'>호텔 상세정보 보러가기 &rarr;</button>"
		                      } 
		                     str+="</div>"
		                     str+="<div class='card-footer text-muted'>"
		                     str+="Posted on January 1, 2020 by <a href='"+context+"'>(주) 코코넨네</a>"
		                     str+="</div>"
		                     $(".left_side").append(str);
		                  });
		                  var paging = "";
		                  paging = "<ul class='pagination justify-content-center mb-4 pagingbar'>";
		                  if(data["pi"].currentPage == 1) { 
		                  paging+="<li class='page-item disabled'><button class='page-link' disabled>&larr; 이전페이지</button></li>"
		                   }else{ 
		                  paging+="<li class='page-item'><button class='page-link' onclick='javascript:"+fn+"("+prev+");'>&larr; 이전페이지</button></li>"
		                    } 
		                  if(data["pi"].currentPage ==data["pi"].maxPage) { 
		                  paging+="<li class='page-item disabled'><button class='page-link' disabled>다음페이지 &rarr;</button></li>"
		                   }else{ 
		                      paging+="<li class='page-item'><button class='page-link' onclick='javascript:"+fn+"("+next+");'>다음페이지 &rarr;</button></li>"
		                   }
		                  paging+="</ul>";
		                  $(".left_side").append(paging);
		                  $('html').scrollTop(0);
		               };
				</script>
			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; COCONENNE
				2021</p>
		</div>
		<!-- /.container -->
	</footer>

</body>

</html>
