package reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.vo.Account;
import reservation.model.service.ReservationService;

/**
 * Servlet implementation class ReservationDeleteServlet
 */
@WebServlet("/reservation/delete")
public class ReservationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("no"));
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		String userId = loginUser.getAccountId();
		
		int result = new ReservationService().deleteReservation(rNo);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "예약 삭제가 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/reservation/check?userId="+userId);
		} else {
			request.setAttribute("msg", "예약 삭제에 실패 하였습니다.");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
