<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, faq.model.vo.Faq" import="account.model.vo.Account"
    import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Faq f = (Faq)request.getAttribute("faq");

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>    
<!doctype html>
<html lang="ko">
  <head>
    <link rel="stylesheet" type="text/css" href="../views/css/faqDetailView.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  </head>
  <body>
	<%@ include file="../common/menubar.jsp"%>
 	 <h1>FAQ 상세</h1>
     <p>고객님들의 자주 하는 질문을 모아봤습니다.</p>
    <div class="wrap">
          
            <div class="main_text0">
                
                <div class="faqdetail">
                    <div class="textarea1">
                    <div class="title">자주 묻는 질문</div>
                        <textarea name="ask" id="askt" readonly ><%= f.getFaqContent()%></textarea>
                      </div>
                    <div class="title">작성자</div>
                    <span class="input_area">
                        <input type="text" name="id" value=<%= f.getAccountId() %> readonly>
                    </span><br>

                    <div class="textarea2">
                      <div class="title">답변</div>
                      <textarea name="answer" id="answert" readonly><%= f.getFaqAnswer() %></textarea>
                    </div>
                    <div class="btnArea">
                        <button type="button" class="btn btn-secondary" id="listBtn">목록으로</button>
                         <!-- faq 관리자만 작성 -->
            			<% if(loginUser != null && (loginUser.getAuth() == 3)) { %>
                        <button type="button" class="btn btn-secondary" id="updateBtn">수정</button>
                        <button type="button" class="btn btn-secondary" id="deleteBtn">삭제</button>
                        <!-- form 태그를 post 방식으로 제출 -->
					<form id="noForm" method="post">
					<!-- nno를 화면에 드러내지 않고 form을 submit 하면서 넘길 수 있음 -->
					<input type="hidden" name="no" value="<%= f.getFaqNo() %>">
					</form>
                        <% } %>
                    </div>    
                    
                </div>

		</div>
       </div>    
            
            <script>
			// 목록으로 버튼 이벤트
			const listBtn = document.getElementById('listBtn');
			listBtn.addEventListener('click', function(){
			location.href="<%= request.getContextPath() %>/faq/list";
			});
			// 수정하기 버튼 이벤트
			const updateBtn = document.getElementById('updateBtn');
			updateBtn.addEventListener('click', function(){
				$("#noForm").attr("action", "<%= request.getContextPath() %>/faq/updateForm");
				$("#noForm").submit();
			});
			// 삭제하기 버튼 이벤트
			const deleteBtn = document.getElementById('deleteBtn');
			deleteBtn.addEventListener('click', function(){
				$("#noForm").attr("action", "<%= request.getContextPath() %>/faq/delete");
				$("#noForm").submit();
			});
			</script>
            
            
           </body>
           </html>