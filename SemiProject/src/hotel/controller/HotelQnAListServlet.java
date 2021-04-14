package hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelQnAService;
import hotel.model.vo.PageInfo;
import hotel.model.vo.QnA;

/**
 * Servlet implementation class hotelQnA
 */
@WebServlet("/qna/list")
public class HotelQnAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelQnAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		List<QnA> list = new HotelQnAService().selectList(hotelId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelQnAService hService = new HotelQnAService();
		
		int listCount = hService.getHotelQnAListCountByHotelId(hotelId);
		
		int pageLimit = 5;		
		int boardLimit = 8;	
		int maxPage;			
		int startPage;			
		int endPage;			
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit,
				maxPage, startPage, endPage);
		
		List<QnA> qList = hService.getHotelQnAListByHotelId(hotelId, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("qList", qList);
		request.setAttribute("pi", pi);
		request.setAttribute("hotelId", hotelId);
		request.getSession().setAttribute("hotelId", hotelId);
		RequestDispatcher view = request.getRequestDispatcher("/views/hotel/hotelQnAListView.jsp");
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
