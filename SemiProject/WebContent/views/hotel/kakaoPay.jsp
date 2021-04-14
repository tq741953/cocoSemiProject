<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,hotel.model.vo.*"%>
<%
	int finalPay = (int)(request.getAttribute("finalPay"));	// 1개의 방당 최종 요금
	List<Hotel> list = (List<Hotel>)request.getAttribute("list");
	String guestName = (String)request.getAttribute("guestName");
	String guestPhone = (String)request.getAttribute("guestPhone");
	int roomCount = (int)request.getAttribute("roomCount");	// 예약한 방 갯수
	int rNo = (int)request.getAttribute("rNo");
	String specialrq = (String)request.getAttribute("specialrq");
	// System.out.println(list +","+  finalPay +","+ guestName +","+ guestPhone);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp01985459'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : 'COCONENNE',
            askIn : '<%= specialrq %>',
            amount : <%= finalPay * roomCount %>,
            roomCount : <%= roomCount %>,
            rNo : <%= rNo %>,
            buyer_name : '<%= guestName %>',
            buyer_tel : '<%= guestPhone %>',
            buyer_postcode : '123-456',
            // m_redirect_url : 'www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                $.ajax({
                    url: "<%= request.getContextPath() %>/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,
                        pg : 'kakaopay',
                        pay_method : 'card',
                        roomCount : <%= roomCount %>,
                        askIn : '<%= specialrq %>',
                        amount : <%= finalPay * roomCount %>,
                        rNo : <%= rNo %>,
                        buyer_name : '<%= guestName %>',
                        buyer_tel : '<%= guestPhone %>'
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    console.log(data);
                location.href='<%=request.getContextPath()%>/views/hotel/completePayment.jsp';
                });
                //성공시 이동할 페이지
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>";
                alert(msg);
            }
        });
        
    });
    </script>
</body>
</html>