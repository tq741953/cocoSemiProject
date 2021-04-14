<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!doctype html>
<html lang="ko">
  <head>
  <% if(session.getAttribute("msg") != null) { %>
<script>
	alert('<%= session.getAttribute("msg") %>');
</script>
<% 
	session.removeAttribute("msg");
} %>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<style>
	
*{
  font-family: 'Noto Sans KR', sans-serif;
  list-style: none;
  text-decoration: none;
  border-collapse: collapse;
  margin:0px;
  padding: 0px;
/*  color: #000;*/
}

h1 {
  font-size: 48px;
  font-weight: 100;
  color : white;
}
.contents1{
  height : 390px;
  font-size: 20px;
  color : black;
  margin-top:20px;
  margin : auto;
  font-weight: lighter;
}
.contents2{
  height : 53px;
  font-size: 18px;
  
}

.contents1_bold{
  font-size: 18px;
  font-weight: bold;
  margin-top: 15px;
  
}
/* --- */



.intro_bg{
  
  width: 100%;
  height: 714px;
}

.header{
  width:1280px;
  margin:auto;
  display:flex;
  height: 86px;
}
.searchArea{
  width:300px;
  height:40px;
  background: rgba(0, 0, 0, 0.5);
  border-radius: 5px;
  margin-top:24px;
}
.searchArea > form > input{
  border:none;
  width:250px;
  height:40px;
  background: rgba(0, 0, 0, 0.0);
  color:#fff;
  padding-left:10px;
}
.searchArea > form > span{
  width:50px;
  color:#fff;
}
.nav{
  display: flex;
  justify-content: flex-end;
  width:calc(1280px - 300px);
  line-height: 86px;
}
.nav > li {
  margin-left:84px;
}

.nav > li > a {
  color: #fff;
}

.amount{
  position: relative;
  top:-66px;
  display: flex;
  width:1280px;
  background: #fff;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  margin: auto;
}
.amount > li {
  flex: 1;
  height: 132px;
}
.amount > li > div {
  text-align: center;
  margin-top:37px;
  height:57px;
}

.amount > li:not(:last-child) > div{
  border-right:1px solid #E1E1E1;
}
.intro_text{
  width:100%;
  margin:231px auto 231px auto;
  text-align: center;
}
.intro_text > h1,
.intro_text > h4{
  color:#fff;
}

/* main_text0 */

.main_text0{
  width: 1300px;
  height:400px;
/*  margin-top:-132px; */
  margin : auto;
/*  background: #f1f2f3;*/
}
.title{
/*  padding-top:116px; */
  text-align: center;
}
.main_text0 > .contents1 {
  text-align: center;
}

.icons{
  display: flex;
  width:1280px;
  height: 340px;
  /* background: orange; */
  padding : 0px 0px 0px 0px;
  margin-top : 20px;
  margin:auto;
  
}
.icons > li {
  flex: 1;
  background: white;
  margin-top:0px;
/*  height:302px; */
  height:330px;
  text-align: center;
  border-radius: 20px;
  cursor: pointer;
  
}
.icons > li > .icon_img{
  margin-top:18px;
  
}

.icons > li:not(:last-child){
  margin-right: 20px;
  
}

.icons .contents2 {
  width:280px;
  margin:auto;
  letter-spacing: -1px;
  
}
.more{
  width:100px;
  height: 30px;
/*  background: #2F7AF4; */
  background : #6c757d;
  color: #fff;
  font-size: 12px;
  line-height: 30px;
  margin:25px auto;
 
}

/* main_text1*/
img {
  width: 130px;
  height: 130px;
/*  background-color: #2F7AF4;*/
  background-color : rgb(141, 145, 149);
  border-radius: 30px;
  margin-top: 20px;
  
}



	
	</style>
  </head>
  <body>
 
 	<%@ include file= "../common/menubar.jsp" %>
	<h1 class="title">MYPAGE</h1><br>
      <div class="main_text0">
        
        <div class="contents1">
        
        <ul class="icons">
          <li id="accountInfo">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon5.svg" class="ic5">
            </div>
            <div class="contents1_bold">회원정보</div>
            <div class="contents2">
                회원정보 변경 
            </div>
            <div class="more">
              MORE
            </div>
          </li>

          <li id="rvCheckBtn">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon6.svg" class="ic6">
            </div>
            <div class="contents1_bold">예약확인</div>
            <div class="contents2">
                예약된 객실을 확인합니다.
                <input type="hidden" name="userId" id="userId" value="<%= loginUser.getAccountId()%>">
            </div>
            <div class="more">
              MORE
            </div>
          </li>

          <li id="myQNABtn">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon7.svg" class="ic7">
            </div>
            <div class="contents1_bold">Q&A</div>
            <div class="contents2">
              Q&A 문의내역을 확인합니다.
            </div>
            <div class="more">
              MORE
            </div>
          </li>

          <li id="reviewbtn">
            <div class="icon_img">
              <img src="<%= request.getContextPath() %>/resources/images/icon4.svg" class="ic4">
            </div>
            <div class="contents1_bold">리뷰</div>
            <div class="contents2">
                리뷰확인
            </div>
            <div class="more">
              MORE
            </div>
          </li>
        </ul>
        </div>
      </div>
<!-- 여기까지 마이페이지 메인-->
  
     
    
    <!-- 여기는 스크립트만 -->
    <script>
    // accountInfo li
    const accountInfo = document.getElementById('accountInfo');
    accountInfo.addEventListener('click', function(){
		location.href="<%= request.getContextPath() %>/views/account/accountChange.jsp";
	});
    
    // reservationCheckBtn li
    const rvCheckBtn = document.getElementById('rvCheckBtn');
    rvCheckBtn.addEventListener('click', function(){
    	const userId = document.getElementById("userId").value;
		location.href="<%= request.getContextPath() %>/reservation/check?userId="+userId;
	});
    
    
    // review li
    const reviewbtn = document.getElementById('reviewbtn');
    reviewbtn.addEventListener('click', function(){
		location.href="<%= request.getContextPath() %>/review/insertlist";
	});
    
    // Q&A
    const myQNABtn = document.getElementById('myQNABtn');
	myQNABtn.addEventListener('click', function(){
		location.href="<%=request.getContextPath()%>/qna/mylist?accountId=<%=loginUser.getAccountId()%>";
	});
    
    </script>
  </body>
</html>