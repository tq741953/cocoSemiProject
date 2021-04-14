<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코넨네</title>
</head>
<style>
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
	<%@ include file="mainMenubar.jsp"%>

	<div class="outer">
		<form class="searchForm" method="post" action="<%= request.getContextPath() %>/hotel/search">
			<div class="search">
				<input id="searchValue" name="searchValue" type="text" placeholder="지역/호텔명"> <input type="date"
					id="checkin" name="checkIn" placeholder="체크인 날짜"
					onchange="checkInValidation(this.value);"> <input
					type="date" name="checkOut" id="checkout" placeholder="체크아웃 날짜"
					onchange="checkOutValidation(this.value);"> <br> <br>
				<h6 class="center" style="color: white;">성인 / 유아(5세이하)</h6>
				<select name="searchAdult" id="searchAdult">
					<option value="0">----</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select> <select name="searchChild">
					<option value="0">----</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<button class="btn btn-secondary" onclick="return checkSearch();">검색</button>
			</div>
		</form>
		<script>
		document.getElementById('checkin').value = new Date().toISOString().substring(0, 10);

		function checkInValidation(value) { /* 체크인  / 오늘 이전날짜 클릭시 alert */
			/* console.log(new Date(value) , new Date(new Date().toISOString().substring(0, 10))) 날짜 출력확인*/

			if (new Date(value) < new Date(new Date().toISOString().substring(0, 10))) {
				alert(new Date().toISOString().substring(0, 10) + " 이후 날짜만 선택이 가능합니다.");
				document.getElementById('checkin').value = new Date().toISOString().substring(0, 10);
			}

			if (document.getElementById('checkout').value != null) {
				if (new Date(document.getElementById('checkout').value) <= new Date(
						document.getElementById('checkin').value)) {
					var later = new Date(
							document.getElementById('checkin').value);
					later.setDate(later.getDate() + 1);

					document.getElementById('checkout').value = later
							.toISOString().substring(0, 10);
				}
			}

		}

		function checkOutValidation(value) { /* 체크아웃 / 체크인 이전날짜 클릭시 alert */

			if (new Date(document.getElementById('checkout').value) <= new Date(
					document.getElementById('checkin').value)) {
				alert("체크아웃 날짜는 체크인날짜 이후만 선택이 가능합니다.");

				var later = new Date(document.getElementById('checkin').value);
				later.setDate(later.getDate() + 1);

				document.getElementById('checkout').value = later.toISOString()
						.substring(0, 10);
			}
		}
		
		function checkSearch() {
			if ($("#searchValue").val().length == 0
					|| $("#checkin").val().length == 0
					|| $("#checkout").val().length == 0
					|| $("#searchAdult").val() == 0) {
				alert('모든 검색 조건을 입력후에 실행해주세요.');
				return false;
			}
			return true;
		};
	</script>
	</div>
</body>
</html>