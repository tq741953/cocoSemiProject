<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>

<style>
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
	<%@ include file="mainMenubar.jsp"%>
	<div class="outer">
        
        <div class="adminInside">
        
        <div class="icons">
          <div class ="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/note-icon.png" class="ic5">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="noticeBtn">공지사항 등록</button>
            </div>
          </div>

          <div class="info1">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/question-mark-icon.png" class="ic6">
            </div>
            <div class="btnArea">
              <button class="btn btn-secondary" id="FAQBtn">FAQ 등록</button>
            </div>
          </div>
        </div>
        </div>
      </div>		
	
	<script>
		const noticeBtn = document.getElementById('noticeBtn');
		noticeBtn.addEventListener('click', function(){
			location.href="<%=request.getContextPath()%>/notice/list";
			});
		
		const FAQBtn = document.getElementById('FAQBtn');
		FAQBtn.addEventListener('click', function(){
			location.href="<%=request.getContextPath()%>/faq/list";
		});
		</script>
</body>
</html>