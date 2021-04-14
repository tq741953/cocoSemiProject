package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminApprovalServlet
 */
@WebServlet("/admin/approval")
public class HotelApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int hotelId = Integer.parseInt(request.getParameter("num"));
		
		int result = new HotelService().selectApprovalHotel(hotelId);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "가입승인이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/admin/approvalList");
		} else {
			request.setAttribute("msg", "가입승인처리 실패 !");
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
