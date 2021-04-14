package hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;

/**
 * Servlet implementation class KakaoPayServlet
 */
@WebServlet("/hotel/kakaopay")
public class KakaoPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String guestName = request.getParameter("guestName");	// 투숙객 이름
		String guestPhone = request.getParameter("guestPhone");	// 투숙객 전화 번호
		String specialrq = request.getParameter("specialrq");	// 특별 요청 사항
		int roomCount = Integer.parseInt(request.getParameter("roomCount"));	// 예약한 방 갯수
		int finalPay = Integer.parseInt(request.getParameter("finalPay"));		// 최종 요금
		int rNo = Integer.parseInt(request.getParameter("rNo")); 		// 방 번호
		// System.out.println(guestName +","+ guestPhone +","+ specialrq +","+ roomCount +","+ finalPay);
		List<Hotel> list = new HotelService().hotelPayment(rNo);
		if(list != null) {
			request.setAttribute("guestName", guestName);
			request.setAttribute("guestPhone", guestPhone);
			request.setAttribute("finalPay", finalPay);
			request.setAttribute("roomCount", roomCount);
			request.setAttribute("list", list);
			request.setAttribute("specialrq", specialrq);
			request.setAttribute("rNo", rNo);
			request.getRequestDispatcher("/views/hotel/kakaoPay.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
