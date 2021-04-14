package Hotelinsert.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotelinsert.model.service.HotelService;
import account.model.vo.Account;

/**
 * Servlet implementation class HotelInsertServlet
 */
@WebServlet("/hotel/list")
public class HotelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		String account_id = loginUser.getAccountId();
		
		
		Map<String, Object> map = new HotelService().boardList(account_id);
		
		
		if(map.get("hList") != null && map.get("fList") != null) {
			request.setAttribute("hList", map.get("hList"));
			request.setAttribute("fList", map.get("fList"));
			request.getRequestDispatcher("/views/Hotelinsert/hotelListView.jsp").forward(request, response);
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
