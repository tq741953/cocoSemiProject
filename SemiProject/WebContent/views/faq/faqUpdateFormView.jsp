<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* , faq.model.vo.Faq" import="java.util.Date, java.text.SimpleDateFormat"%>
<%
 	  List<Faq> faqlist = (List<Faq>)request.getAttribute("faqlist"); 	

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>
<% if(session.getAttribute("msg") != null) { %>
<script>
	alert('<%= session.getAttribute("msg") %>');
</script>
<% 
	session.removeAttribute("msg");
} %>
<!doctype html>
<html lang="ko">
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../views/css/faqDetailView.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  </head>
  <body>
  	<%@ include file="../common/menubar.jsp"%>
    <div class="wrap">
       <div class="intro_bg" style="background-image:url('<%= request.getContextPath() %>/resources/images/intro.png');">

        <div class="intro_text">
          
            <div class="main_text0">
                <h1>FAQ 수정</h1>
                <p>고객님들의 자주 하는 질문을 모아봤습니다.</p>
                <div class="faqdetail">
                <form action="<%= request.getContextPath() %>/faq/update" method="post">
				<!-- 공지사항 글 번호를 화면에는 보이지 않게 request의 parameter로 넘긴다 -->
               		<%for(Faq f : faqlist) { %>
               		
                    <input type="hidden" name="title" value="<%= f.getFaqTitle()%>">
                                        <div class="textarea1">
                    <h4>자주묻는질문</h4>
                        <textarea name="ask" id="askt" ><%= f.getFaqContent() %></textarea>
                      </div>
                    <h4>작성자</h4>
                    <span class="input_area">
                        <input type="text" name="id" value="<%= f.getAccountId()%>" readonly>
                    </span><br>
                    <h4>작성일</h4>
                    <span class="input_area">
                        <input type="text" name="createDate" value="<%= f.getCreateDate() %>" readonly>
                    </span><br>
                    <h4>수정일</h4>
                    <span class="input_area">
                        <input type="text" name="modifyDate" value="<%= today %>" readonly>
                    </span><br>
                    <div class="textarea2">
                      <h4>답변</h4>
                      <textarea name="answer" id="answert" ><%= f.getFaqAnswer() %></textarea>
                    </div>
                   	<input type="hidden" name="no" value="<%= f.getFaqNo() %>">
                    <div class="btnArea">
					<button type="button" onclick="javascript:history.back();">취소</button>
					<button type="submit" id="updateBtn">수정완료</button>
					</div>
		
           
                   </form>
                    
                          <% } %>
                    </div>    
                    
                </div>


            </div>
            
            <script>
            
			
			// 수정하기 버튼 이벤트
			
			</script>
            
            
           </dody>
           </html>