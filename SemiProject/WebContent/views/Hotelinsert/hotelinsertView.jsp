<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Hotelinsert.model.vo.*, java.util.*, account.model.vo.Account"%>
<%
	ArrayList<Hotel> hotel = (ArrayList<Hotel>)request.getAttribute("hotel");
	ArrayList<Hotel_file> hotel_file = (ArrayList<Hotel_file>)request.getAttribute("hotel_file");
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
   
   #joinInfoArea{
      width : 700px;
      background: white;
      margin : auto;
   }
   
   .join_title{
      width : 700px;
      height : 50px;
      color:#B3B3B3; 
      background-color : #343A40;   
      padding-top : 10px;   
   }

   
   /* span 태그 */
   .input_area {
      width : 700px;
      height : 60px;
       background : white;
       display : inline-block;
       margin : auto;
   }
   
   .input_area_ck{
      width : 700px;
      height : 60px;
       background : white;
       display : inline-block;
       padding-top : 10px;
   }
   
   .inputFile{
   		margin : auto;
   }
   
   /* input 태그 */
   .input_area input:not([type=checkbox]) {
      width : 700px;
      height : 60px;
      border: 0px;
      text-align : center;
   }
   
   input:first-child{
   	padding-top : 10px;
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
	<%@ include file="../common/menubar.jsp" %>
<h1>호텔 등록 페이지</h1><br>	
	<div class="outer">
		<div id="joinInfoArea">
			<form id="joinForm" action="<%= request.getContextPath() %>/hotelinsert/insert"
			method="post" enctype="multipart/form-data">
			<div id="insertArea">
				<div class="join_title">호텔 관리자 ID</div>
				<div class="input_area">
				<%= loginUser.getAccountId() %>
				<input type="hidden" name="Account_id" value="<%= loginUser.getAccountId() %>">
				</div>
			</div>
			<div id="insertArea">	
				<div class="join_title">업체명</div>
				<div class="input_area">
				<input type="text" maxlength="20" name="Hotel_name" required>
				</div>
			</div>	
			<div id="insertArea">
				<div class="join_title">주소</div>
				<div class="input_area">
				<input type="text" name="Hotel_address" class="postcodify_address" readonly>
				</div>
				<button class="btn btn-secondary" id="postcodify_search_button" type="button">검색</button>
			</div>
			<div id="insertArea">	
				<div class="join_title">연락처</div>
				<div class="input_area">
				<input type="text" maxlength="20" name="Hotel_phone" required>
				</div>
			</div>
			<div id="insertArea">	
				<div class="join_title">사업자 번호 등록</div>
				<div class="input_area">
				<input type="text" maxlength="20" name="Business_license" required>
				</div>
			</div>
			<div id="insertArea">	
				<div class="join_title">대표 이미지 업로드</div>
					<div class="input_area_2nd">
						<input type="file" class="inputFile" name="thumbnailImg" required>
					</div>
				<div id="thumbnailImgArea">
					<img id="thumbnail">
				</div>
			</div>
			<div id="insertArea">
				<div class="join_title">사업자 등록증 첨부</div>
					<div class="input_area_2nd">
						<input type="file" class="inputFile" name="contentImg1">
					</div>
				<div id="contentImgArea1">
					<img id="content1">
				</div>
			</div>	
				<div class="btnArea">
					<button type="button" class="btn btn-secondary" onclick="javascript:history.back();">취소하기</button>
					<button id="joinBtn" class="btn btn-secondary" type="submit">등록하기</button>
				</div>
			</form>
		</div>
	</div>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
	<script>
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
				
				switch(element.name){
				case "thumbnailImg" :
					selector = "#thumbnail";
					size = {width : "550px", height : "300px", border : "solid 1px #dadada"};
					break;
				case "contentImg1" :
					selector = "#content1";
					size = {width : "150px", height : "250px", border : "solid 1px #dadada"};
					break;
				}
				$(selector).attr("src", e.target.result).css(size);
			}
			reader.readAsDataURL(element.files[0]);
		}
	}
	</script>
</body>
</html>