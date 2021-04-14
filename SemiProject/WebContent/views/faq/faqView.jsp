<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, faq.model.vo.Faq" import="account.model.vo.Account"%>
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");

%>

<!doctype html>
<html lang="ko">
  <head>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<style>
	
h1 {
  font-size: 48px;
  color : white;
  font-weight: 100;
}

p {
  color : white;
}

/* main_text0 */

.main_text0{
  width: 952px;
  min-height:180px;
  margin : auto;

  background: white;
}


/* main_text0 */

caption {
  display: none;
}

.faqlistwrap {
  margin : auto;
  width: 952px;
  
}

.faqlist > tr > td > a {
  text-decoration: none;
  color: inherit;
}


.faqlistwrap th{
	height : 50px;
	color:#B3B3B3; 
	background-color : #343A40;
}

.faqlistwrap th:nth-child(3){
	width : 200px;
}

.faqlistwrap th:nth-child(4){
	width : 200px;
}

.faqlistwrap th:nth-child(5){
	width : 170px;
}


.faqlistwrap td {
  background-color : white;
  font-size: 18px;
  border : none;
  padding: 10px;
}

table {
  border-collapse: collapse;
  margin: auto;
  text-align: center;
    
}

.faqlistwrap td {
  height : 50px;
  text-align: center;
}

.faqlistwrap tbody tr td:nth-child(2) {
  text-align: left;
}

.faqlist tr {

  
}

.faqlistwrap tbody tr td:nth-child(2):hover {
  text-decoration: underline;
  background-color: gainsboro;
}



.faqlistwrap tr th:nth-child(2) {
  width: 500px;
  color:#B3B3B3; 
  background-color : #343A40;
}

.searchwrap {
  height : 55px;
  margin : auto;
  margin-top: 30px;
  
}

.searcharea2 {
  width: 952px;
  background-color: #343A40;
  display : inline-block;
}

.paging{
	width: 952px;
	display : inline-block;
}

.total {
	height : 120px;
	
}

.btn {
	margin : 2px;
}
	</style>
  </head>
  <body>
	<%@ include file="../common/menubar.jsp"%>
    <h1>FAQ</h1>
    <p>고객님들의 자주 하는 질문을 모아봤습니다.</p>
    	

      <div class="main_text0">
        
          <div class="faqlistwrap">
            <table border="1" id="listTable">
              <caption>faq 목록</caption>
              <thead>
                <tr>
                  <th>글번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                </tr>
                <!-- 존재하지 않을수도 있으므로 list가 비어있는지 확인 -->
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr>
				<% } else { 
				for(Faq n : list) { %>
				<tr>
					<td><%= n.getFaqNo() %></td>
					<td><%= n.getFaqContent() %></td>
					<td><%= n.getAccountId() %></td>
					<td><%= n.getCreateDate() %></td>
				</tr>
				
				<% }
				} %>
              </thead>
              <tbody class="faqlist">
                
              </tbody>
            </table>
            </div>
            

			<div class="searchwrap">   
	          <form action="<%= request.getContextPath() %>/faq/search" method="get" class="searcharea2" onsubmit="return checkSearchCondition();">
	            <select id="searchCondition" name="searchCondition">
	              <option value="----">----</option>
	              <option value="title">제목</option>
	              <option value="content">내용</option>
	            </select>
	            <input type="search" name="search">
	            <button class="btn btn-secondary" type="submit">검색하기</button>
	            <!-- faq 관리자만 작성 -->
	            <% if(loginUser != null && (loginUser.getAuth() == 3)) { %>
	            <button class="btn btn-secondary" type="button" id="faqInsert">작성하기</button>
	           	<% } %>
	           	<script>
	         		// 작성하기 버튼 이벤트
				const faqInsert = document.getElementById('faqInsert');
				faqInsert.addEventListener('click', function(){
					location.href='<%= request.getContextPath() %>/views/faq/faqInsertView.jsp';
				});
	           	</script>         	
	           </form>
	        </div>
           
      </div>
      
      <!-- 스크립트 -->
      <script>
      $(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor" : "pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "rgb(248, 249, 250)");
			}).click(function(){
				// 쿼리 스트링을 이용하여 get 방식(url 노출)으로 글번호를 parameter로 전달
				var no = $(this).parent().children().eq(0).text(); 
				location.href="<%= request.getContextPath() %>/faq/detail?no=" + no;
				
			});
		});
      
      
      
      </script>
      
  </body>
</html>