<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="facilities.model.vo.*, java.util.*, account.model.vo.Account"%>
<%
	ArrayList<Facilities> facilities = (ArrayList<Facilities>)request.getAttribute("facilities");
	ArrayList<Room_file> room_file = (ArrayList<Room_file>)request.getAttribute("room_file");
	int hotelId = (Integer)(request.getSession().getAttribute("hotelId"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<style>
   /* 바깥 영역 */
   .outer{
      width:500px;

      box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
      margin:auto;
   }
   
   h1 {
      color : white;
   }
   
   #joinInfoArea{
      width : 500px;
      background: white;
      margin : auto;
   }
   
   .join_title{
      width : 500px;
      height : 50px;
      color:#B3B3B3; 
      background-color : #343A40;   
      padding-top : 10px;   
   }

   
   /* span 태그 */
   .input_area {
      width : 500px;
      height : 60px;
       background : white;
       display : inline-block;
   }
   
   .input_area_ck{
      width : 500px;
      height : 60px;
       background : white;
       display : inline-block;
       padding-top : 10px;
   }
   
   /* input 태그 */
   .input_area input:not([type=checkbox]) {
      width : 200px;
      height : 50px;
      border: 0px;
      text-align : center;
   }
   
   .firstinput{
      margin-left : 110px;
   }
   
   
   /* 버튼 영역 */
   .btnArea {
      width : 500px;
      text-align:center;
      color:#B3B3B3; 
      background-color : #343A40;
   }
</style>
</head>
<body>
		<%@ include file="../common/menubar.jsp" %>
	
	<h3>객실 등록 페이지</h3>
	<div class="outer">
		<div id="joinInfoArea">
			<form id="joinForm" action="<%= request.getContextPath() %>/facilities/insert"
			method="post" enctype="multipart/form-data">
				<div id="accountAll">
					<div class="info_title"><div class="title">호텔 관리자 ID</div></div>
					<div class="input_area">
					<input type="text" maxlength="13" class="inputText" name="accountId" value="<%=  loginUser.getAccountId() %>" readonly>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">객실 대표 이미지 첨부</div></div>
					<div class="input_area">
					<input type="file" class="inputFile" name="thumbnailImg" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">내용 이미지 첨부(최대 2개)</div></div>
					<div class="input_area">
					<input type="file" class="inputFile" name="contentImg1">
					<input type="file" class="inputFile" name="contentImg2">
					</div>
				</div>
				<div id="contentImgArea1">
					<img id="content1">
				</div>
				<div id="contentImgArea2">
					<img id="content2">
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">객실 수량</div></div>
					<div class="input_area">
					<input type="text"  class="inputText" maxlength="20" name="Room_count" placeholder="등록할 객실수량을 입력해주세요" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">객실 이용금액</div></div>
					<div class="input_area">
					<input type="text" class="inputText" maxlength="20" name="Room_price" placeholder="등록할 객실금액을 입력해주세요" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">최대 이용가능 인원</div></div>
					<div class="input_area">
					<input type="text" class="inputText" maxlength="20" name="Room_maximum" placeholder="최대 이용가능 인원을 입력해주세요" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">최대 성인수</div></div>
					<div class="input_area">
					<input type="text" class="inputText" maxlength="11" name="Adult_count" placeholder="객실의 최대 성인수를 입력해주세요" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">최대 아동수</div></div>
					<div class="input_area">
					<input type="text" class="inputText" maxlength="11" name="Child_count" placeholder="객실의 최대 아동수를 입력해주세요" required>
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">침대 타입</div></div>
					<div class="input_area">
					<span class="input_area">
					<input type="checkbox" id="ondel" name="Bed_type" value="온돌">
					<label for="ondel">온돌</label>
					<input type="checkbox" id="duble" name="Bed_type" value="배드(더블)">
					<label for="duble">배드(더블)</label>
					<input type="checkbox" id="twin" name="Bed_type" value="배드(트윈)">
					<label for="twin">배드(트윈)</label>
					<input type="checkbox" id="baby_bed" name="Bed_type" value="아기침대">
					<label for="baby_bed">아기침대</label>
				</span>
					</div>
				</div>
				
				
				<div id="accountAll">
					<div class="info_title"><div class="title">객실 타입</div></div>
					<div class="input_area">
					<span class="input_area">
					<input type="checkbox" id="suite" name="Room_type" value="스위트룸">
					<label for="suite">스위트룸</label>
					
					<input type="checkbox" id="business" name="Room_type" value="비즈니스룸">
					<label for="business">비즈니스룸</label>
					
					<input type="checkbox" id="standard" name="Room_type" value="스탠다드룸">
					<label for="standard">스탠다드룸</label>
					</span>					
					</div>
				</div>
				
				<div id="accountAll">
					<div class="info_title"><div class="title">호텔 서비스</div></div>
					<div class="input_area">
					<span class="input_area">
					<input type="checkbox" id="smoking" name="Hotel_service" value="흡연가능 객실">
					<label for="smoking">흡연객실</label>
					
					<input type="checkbox" id="wifi" name="Hotel_service" value="무료 WIFI">
					<label for="wifi">무료 WIFI</label>
					
					<input type="checkbox" id="breakfast" name="Hotel_service" value="조식제공">
					<label for="breakfast">조식제공</label>
					
					<input type="checkbox" id="pool" name="Hotel_service" value="피트니스센터">
					<label for="pool">피트니스센터</label>
				</span>			
					</div>
				</div>
					<input type="hidden" name="hotelId" value="<%= hotelId %>">
				<div class="btnArea">
					<button type="button" class="btn btn-secondary" onclick="javascript:history.back();">취소하기</button>
					<button id="joinBtn" class="btn btn-secondary" type="submit">객실등록</button>
				</div>
				
			</form>
		</div>
	</div>
	
	<script>
	// 파일 첨부시 이벤트 설정하기
	$(function(){
		$("[type=file]").change(function(){
			loadImg(this);
		});
	});
	
	function loadImg(element){
		if(element.files && element.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				
				var selector;
				var size;
				
				switch(element.name) {
				case "thumbnailImg" :
					selector = "#thumbnail";
					size = {width : "550px", height : "300px", border : "solid 1px #dadada"};
					break;
				case "contentImg1" :
					selector = "#content1";
					size = {width : "150px", height : "150px", border : "solid 1px #dadada"};
					break;
				case "contentImg2" :
					selector = "#content2";
					size = {width : "150px", height : "150px", border : "solid 1px #dadada"};
					break;
				}
				console.log(e.target);
				console.log(e.target.result);
				
				$(selector).attr("src", e.target.result).css(size);
			}
			reader.readAsDataURL(element.files[0]);
		}
	}
	</script>
</body>
</html>