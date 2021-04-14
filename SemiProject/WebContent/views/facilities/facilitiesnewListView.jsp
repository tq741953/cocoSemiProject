<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, facilities.model.vo.*, account.model.vo.Account"%>
<%
   ArrayList<Facilities> fList = (ArrayList<Facilities>)request.getAttribute("fList");
   ArrayList<Room_file> rList = (ArrayList<Room_file>)request.getAttribute("rList");
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
      width:600px;
      background: white;
      box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
      margin:auto;

   }
   
   h1{
   	color : white;
   }
   
   .galleryArea {
      width:600px;
      margin:auto;
   }
   
   .gallery_list {
      width:250px;
      max-height : 400px;
      display:inline-block;
      margin:10px;
      text-align:center;
   }
   
   img {
   	width : 230px;
   	height : 230px;
   }
   
   .gallery_list:hover {
      opacity:0.8;
      cursor:pointer;
   }

   .gallery_title {
      height : 42px;
      overflow:hidden;
   }
   
   .btnArea {
		width : 600px;
		text-align:center;
		background-color : #343A40;
   }
   
</style>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
   <h1>객실등록 게시판</h1><br>
   <div class="outer">
      <div class="galleryArea">
         
         <% if(fList == null && rList == null) { %>
         <p> 등록된 객실이 없습니다.</p>
         <% } %>
         <% for(Facilities f : fList) { %>
         <div class="gallery_list">
            <input type="hidden" value="<%= f.getRoom_no() %>">
            <div>
               <% for(Room_file r : rList) { %>
               <% if(f.getRoom_no() == r.getRoom_no()) { %>
               <img src="<%= request.getContextPath() %><%= r.getFile_url() %><%= r.getFile_rename() %>"
               width="200px" height="150px">
               <% } %>
               <% } %>   
            </div>
            <div class="gallery_title">객실 이름: <%= f.getHotel_name() %></div>
            <div class="gallery_title">관리자 : <%= f.getAccount_id() %></div>
            <div class="gallery_title">객실 수 : <%= f.getRoom_count() %></div>
         </div>
         <% } %>
      </div>
      <% if(loginUser != null) { %>
      <div class="btnArea">
         <button class="btn btn-secondary" onclick="location.href='<%= request.getContextPath() %>/views/facilities/facilitiesInsertVIew.jsp'">등록하기</button>
      </div>
      <% } %>
   </div>
   
   <script>
      $(function(){
         $(".gallery_list").click(function(){
            var Room_no = $(this).children().eq(0).val();
            location.href='<%= request.getContextPath() %>/facilities/detail?Room_no=' + Room_no;
         });
      });
   
   </script>
</body>
</html>