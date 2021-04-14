package hnotice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnotice.model.service.HNoticeService;
import hnotice.model.vo.HNotice;

/**
 * Servlet implementation class HNoticeSearchServlet
 */
@WebServlet("/hnotice/search")
public class HNoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		List<HNotice> list = new HNoticeService().searchBoard(searchCondition, search, hotelId);
		
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/hnotice/hnoticeListView.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
