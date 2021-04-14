package reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;
import reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReservationDetailView
 */
@WebServlet("/reservation/detail")
public class ReservationDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
	      
	      Reservation reservation = new ReservationService().selectDetailList(reservationNo);
	      
	      String page = "";
	      if(reservation != null) {
	         request.setAttribute("reservation", reservation);
	         page = "/views/reservation/reservationDetailView.jsp";
	      } else {
	         request.setAttribute("msg", "예약 및 결제를 내용이 없습니다." );
	         page = "/views/common/errorPage.jsp";
	      }
	      request.getRequestDispatcher(page).forward(request, response);
	   } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
