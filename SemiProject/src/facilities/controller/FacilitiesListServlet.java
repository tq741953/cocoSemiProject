package facilities.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.vo.Account;
import facilities.model.service.FacilitiesService;

/**
 * Servlet implementation class FacilitiesListServlet
 */
@WebServlet("/facilities/list")
public class FacilitiesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilitiesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		Map<String, Object> map = new FacilitiesService().boardListRoom(hotelId);

		if(map.get("fList") != null && map.get("rList") != null) {
			request.setAttribute("fList", map.get("fList"));
			request.setAttribute("rList", map.get("rList"));
			request.getSession().setAttribute("hotelId", hotelId);
			request.getRequestDispatcher("/views/facilities/facilitiesnewListView.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "시설등록 목록 조회를 실패하였습니다.");
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
