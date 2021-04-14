package hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.vo.Account;
import hotel.model.service.HotelService;
import hotel.model.vo.Reservation;

/**
 * Servlet implementation class kakaoPayGetUid
 */
@WebServlet("/payments/complete")
public class kakaoPayGetUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kakaoPayGetUid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("imp_uid");	// 寃곗젣 肄붾뱶
		String pg = request.getParameter("pg");
		String pay_method = request.getParameter("pay_method");	// 寃곗젣 �닔�떒
		int amount = Integer.parseInt(request.getParameter("amount"));	// 寃곗젣 湲덉븸
		String guestName = request.getParameter("buyer_name");
		String guestPhone = request.getParameter("buyer_tel");
		String askIn = request.getParameter("askIn");	// �슂泥� �궗�빆
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");	// �븘�씠�뵒
		String checkIn = (String)request.getSession().getAttribute("checkIn");
		String checkOut = (String)request.getSession().getAttribute("checkOut");
		int searchAdult = (Integer)request.getSession().getAttribute("searchAdult");
		int searchChild = (Integer)request.getSession().getAttribute("searchChild");
		int roomCount = Integer.parseInt(request.getParameter("roomCount"));		// �삁�빟�븳 諛⑹쓽 �닔
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		Reservation r = new Reservation();
		r.setAccount_id(loginUser);
		r.setCheck_in(checkIn);
		r.setCheck_out(checkOut);
		r.setAskIn(askIn);
		r.setPay_type(pay_method);
		r.setPay_price(amount);
		r.setPay_code(uId);
		r.setAdult_count(searchAdult);
		r.setChild_count(searchChild);
		r.setGuest_name(guestName);
		r.setGuest_phone(guestPhone);
		r.setRoom_count(roomCount);
		r.setRoom_no(rNo);
		
		int result = new HotelService().insertReservation(r);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
		// �꽦怨� �뻽�쓣 �븣
			out.print(1);
		} else {
			out.print(0);
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
