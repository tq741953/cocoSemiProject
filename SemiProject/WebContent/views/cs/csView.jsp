<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{
		color:white;
	}
	
	.outer {
	width : 600px;
	height : 500px;
	margin : auto;
	position : relative;
}

.adminInside {
	margin : auto;
	
}

.title{
	color : white;
	text-align : center;
}

.info1{
	width : 250px;
	height : 250px;
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

.btnArea {
	margin : 20px;
}
</style>
</head>
<body>
	<%@ include file="../common/mainMenubar.jsp"%>
	<h2>코코넨네 고객센터</h2>
		
	<div class="outer">
        
        <div class="csInside">
        
        <div class="icons">
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon4.svg" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id=hotelNoticeBtn>공지사항</button>
            </div>
          </div>

          <div class="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon7.svg" class="ic6">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="FAQBtn">자주 묻는 질문</button>
            </div>
          </div>
        </div>
        </div>
      </div>			
		
			<script>
				const hotelNoticeBtn = document.getElementById('hotelNoticeBtn');
				hotelNoticeBtn.addEventListener('click', function(){
					location.href="<%=request.getContextPath()%>/notice/list";
				});
				
				const FAQBtn = document.getElementById('FAQBtn');
				FAQBtn.addEventListener('click', function(){
					location.href="<%=request.getContextPath()%>/faq/list";
				});
			</script>
</body>
</html>