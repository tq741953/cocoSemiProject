<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, hotel.model.vo.*, admin.model.vo.*"%>
   
<%
	ArrayList<Hotel> list = (ArrayList<Hotel>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	String searchCondition = request.getParameter("searchCondition");
	String search = request.getParameter("search") != null ? request.getParameter("search") : "";
	String[] searchSelected = new String[2];
	if(searchCondition != null){
		if(searchCondition.equals("title"))
			searchSelected[0] = "selected";
		else
			searchSelected[1] = "selected";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
<style>
	#listTable {
	width: 70%;
	text-align: center;
	margin:auto;
}
h2,
table tr{
	color:white;
}
table th{
	color:#B3B3B3;
}
table td{
	line-height:30px;
}
.table {
	background:#343A40;
}
.modal-body img {
	width:600px;
	height:700px;
}

.modal-body{
	width:600px;
	height:800px;
	margin : auto;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	
	<div class="outer">
		<h2>가입대기 호텔 목록</h2>
			<br>
		<div class="QnAArea">
	<table class="table table-striped table-hover" style="table-layout:fixed" id="listTable">
				<tr>
					<th>호텔명</th>
					<th>호텔주소</th>
					<th>전화번호</th>
					<th>승인</th>
					<th>사업자번호</th>
				</tr>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="5">가입대기 호텔이 없습니다.</td>
				</tr>
				<% } else { %>
				<% for(int i = 0; i < list.size(); i++) { %>
				
				<tr>
					<td style="width:50px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%=list.get(i).getHotel_name() %></td>
					<td><%=list.get(i).getHotel_address() %></td>
					<td><%=list.get(i).getHotel_phone() %></td>
					<td><button class="noCheck btn btn-secondary btn-sm" onclick="approval(<%= list.get(i).getHotel_id() %>);">승인</button></td>
					<td><button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#myModal<%= i %>">사진확인</button></td>
				</tr>
			
				<% } 
				} %>
			</table>
	</div>
			<div class="pagingArea">
			<!-- 이전 페이지로(<) -->
			<% if(pi.getCurrentPage() == 1) { %>
			<button class="btn btn-secondary btn-sm" disabled> &lt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/admin/approvalList?currentPage=<%= pi.getCurrentPage() - 1 %>'"> &lt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= pi.getCurrentPage() - 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &lt; </button>
			<% } %>
			<!-- 숫자로 된 페이지 목록 (최대 10개) -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<% if(p == pi.getCurrentPage()) { %>
				<button  class="btn btn-secondary btn-sm" disabled> <%= p %> </button>
				<% } else if(searchCondition == null) { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/admin/approvalList?currentPage=<%= p %>'"> <%= p %> </button>
				<% } else { %>
				<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= p %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로(>) -->
			<% if(pi.getCurrentPage() == pi.getMaxPage()) { %>
			<button class="btn btn-secondary btn-sm" disabled> &gt; </button>
			<% } else if(searchCondition == null) { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/admin/approvalList?currentPage=<%= pi.getCurrentPage() + 1 %>'"> &gt; </button>
			<% } else { %>
			<button class="btn btn-secondary btn-sm" onclick="location.href='<%= request.getContextPath() %>/hotelQnA/search?currentPage=<%= pi.getCurrentPage() + 1 %>&searchCondition=<%= searchCondition %>&search=<%= search %>'"> &gt; </button>
			<% } %>
		</div>
			</div>
			<% for(int i = 0; i < list.size(); i++) { %>
			<!-- Modal --> 
			<div class="modal fade" id="myModal<%= i %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"> 
				<div class="modal-dialog modal-lg" role="document"> 
					<div class="modal-content"> 
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> 
								<div class="modal-body">
									<img src="<%=list.get(i).getFile_url()%><%=list.get(i).getFile_rename()%>">
						</div>
					</div>
				</div>
			</div>
			<% } %>
			<script>
			function approval(num){
				if(confirm("가입을 승인하시겠습니까?")){
					location.href="<%= request.getContextPath()%>/admin/approval?num="+num;
				} else {
					console.log('실패')
				}
			}
			
		$(function(){
			$("#listTable td").mouseenter(function(){
				$(this).parent().css({"color":"#B3B3B3"});
			}).mouseout(function(){
				$(this).parent().css({"background" : "#343A40","color":"white"});
			});
		});
		
	</script>
	
</body>
</html>