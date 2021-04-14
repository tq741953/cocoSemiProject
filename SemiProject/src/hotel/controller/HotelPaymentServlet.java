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
 * Servlet implementation class HotelPaymentServlet
 */
@WebServlet("/hotel/payment")
public class HotelPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		String checkIn = (String)request.getSession().getAttribute("checkIn");
		String checkOut = (String)request.getSession().getAttribute("checkOut");
		List<Hotel> list = new HotelService().hotelPayment(rNo);
		
		// 예약한 방 갯수 검사
		for(int i = 0; i < list.size(); i++) {
			int result = new HotelService().checkRoomCount(checkIn, checkOut, list.get(i).getRoom_no());
			list.get(i).setCheckedRoom(result);
			}
		// System.out.println(list.get(0).getRoom_count() - list.get(0).getCheckedRoom());
		if(list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/hotel/paymentPage.jsp").forward(request, response);
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
