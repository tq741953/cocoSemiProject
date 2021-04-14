package reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import account.model.vo.Account;


import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReservationCheckServlet
 */
@WebServlet("/reservation/check")
public class ReservationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		List<Review> rlist = new ReviewService().rCheckList(userId);
		// System.out.println("rlist: " + rlist);
		request.setAttribute("rlist", rlist);
		
		
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			
			userId = loginUser.getAccountId();
		}
		
		for(int i = 0; i < rlist.size(); i++) {
			int result = new ReviewService().reviewChecked(rlist.get(i).getReservation_no());
			rlist.get(i).setCheckReservation(result);
			
		}
	
		
		if(rlist != null ) {
			request.setAttribute("rlist", rlist);
			
			RequestDispatcher view = request.getRequestDispatcher("/views/reservation/reservationCheck.jsp");
			view.forward(request, response);
			
		} else {
			
			request.setAttribute("msg", "로그인시 확인가능합니다");
			RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
			view.forward(request, response);
			
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
