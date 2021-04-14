<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="account.model.vo.Account"%>
<%
	Account loginUser = (Account) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="<%=request.getContextPath()%>/views/common/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/SemiProject/resources/MaterialDesign-Webfont-master/css/materialdesignicons.css">
<% if(session.getAttribute("msg") != null) { %>
<script>
   alert('<%= session.getAttribute("msg") %>');
</script>
<% 
   session.removeAttribute("msg");
} %>
</head>
<style>
* {
font-family: 'Noto Sans KR', sans-serif;
}
body {
	min-height: 800px;
	weight: 100%;
	background:
		url('<%=request.getContextPath()%>/resources/images/main.png');
	background-repeat: no-repeat;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	padding-top: 150px;
	text-align: center;
	}

	.btn {
		margin: 10px;
	}
	
	.btnOuter {
		padding-top: 100px;
	}
</style>
<body>
	<!-- 상단 메뉴바 -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<%if(loginUser == null || loginUser.getAuth() == 1) {  %>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/views/common/mainPage.jsp">COCONENNE</a>
			 <%} else if(loginUser.getAuth() == 2) {  %>
			 <a class="navbar-brand" href="<%=request.getContextPath()%>/myhotel/list">COCONENNE</a>
			 <%} else {%>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/views/common/adminMainPage.jsp">COCONENNE</a>
			 <%}%>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<%
						if (loginUser == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/views/cs/csView.jsp">고객센터</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/views/account/loginForm.jsp">로그인</a>
					</li>
					<%
						} else {
					%>

					<%
						if (loginUser.getAuth() == 1) {
					%>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/views/cs/csView.jsp">고객센터</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/views/common/myPage.jsp">마이페이지</a></li>
			
			<script>
			  (function() {
			    var w = window;
			    if (w.ChannelIO) {
			      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
			    }
			    var ch = function() {
			      ch.c(arguments);
			    };
			    ch.q = [];
			    ch.c = function(args) {
			      ch.q.push(args);
			    };
			    w.ChannelIO = ch;
			    function l() {
			      if (w.ChannelIOInitialized) {
			        return;
			      }
			      w.ChannelIOInitialized = true;
			      var s = document.createElement('script');
			      s.type = 'text/javascript';
			      s.async = true;
			      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
			      s.charset = 'UTF-8';
			      var x = document.getElementsByTagName('script')[0];
			      x.parentNode.insertBefore(s, x);
			    }
			    if (document.readyState === 'complete') {
			      l();
			    } else if (window.attachEvent) {
			      window.attachEvent('onload', l);
			    } else {
			      window.addEventListener('DOMContentLoaded', l, false);
			      window.addEventListener('load', l, false);
			    }
			  })();
			  ChannelIO('boot', {
			    "pluginKey": "ecffe7d5-1420-48bc-b861-e40ab95adcba"
			  });
			</script>
					<%
						} else if (loginUser.getAuth() == 2) {
					%>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/views/cs/csView.jsp">고객센터</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/views/account/accountChange.jsp">호텔관리자 정보수정</a></li>
			<script>
			  (function() {
			    var w = window;
			    if (w.ChannelIO) {
			      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
			    }
			    var ch = function() {
			      ch.c(arguments);
			    };
			    ch.q = [];
			    ch.c = function(args) {
			      ch.q.push(args);
			    };
			    w.ChannelIO = ch;
			    function l() {
			      if (w.ChannelIOInitialized) {
			        return;
			      }
			      w.ChannelIOInitialized = true;
			      var s = document.createElement('script');
			      s.type = 'text/javascript';
			      s.async = true;
			      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
			      s.charset = 'UTF-8';
			      var x = document.getElementsByTagName('script')[0];
			      x.parentNode.insertBefore(s, x);
			    }
			    if (document.readyState === 'complete') {
			      l();
			    } else if (window.attachEvent) {
			      window.attachEvent('onload', l);
			    } else {
			      window.addEventListener('DOMContentLoaded', l, false);
			      window.addEventListener('load', l, false);
			    }
			  })();
			  ChannelIO('boot', {
			    "pluginKey": "ecffe7d5-1420-48bc-b861-e40ab95adcba"
			  });
			</script>
					<%
						} else if (loginUser.getAuth() == 3) {
					%>
					<!-- 가입승인페이지로 넘어가게하기 -->
					<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/admin/approvalList">관리자 페이지</a></li>
					<%
						}
					%>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/views/account/logoutForm.jsp">로그아웃</a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>
	
</body>
</html>