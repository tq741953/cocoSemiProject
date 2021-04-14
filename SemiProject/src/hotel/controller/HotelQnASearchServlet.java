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
import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import hotel.model.vo.QnA;

/**
 * Servlet implementation class HotelQnASearchServlet
 */
@WebServlet("/hotelQnA/search")
public class HotelQnASearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelQnASearchServlet() {
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
		int currentPage = 1;
		
		List<QnA> list = new HotelQnAService().selectList(hotelId);
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelQnAService qService = new HotelQnAService();
		
		int listCount = qService.getSearchHotelQnAListCount(searchCondition, search, hotelId);
		
		// 2. ����¡ ó���� ����
		int pageLimit = 5;		// �� ������ �ϴܿ� ������ ������ ��
		int noticeLimit = 6;	// �� �������� ������ �Խñ� �ִ� ��
		int maxPage;			// ��ü ���������� ���� ������ ������
		int startPage;			// �� ������ �ϴܿ� ������ ���� ������
		int endPage;			// �� ������ �ϴܿ� ������ �� ������
		
		maxPage = (int)Math.ceil((double)listCount / noticeLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, noticeLimit,
				maxPage, startPage, endPage);
		
		List<QnA> qList = qService.selectSearchHotelQnAList(pi, searchCondition, search ,hotelId);
		
		request.setAttribute("list", list);
		request.setAttribute("qList", qList);
		request.setAttribute("pi", pi);
		request.setAttribute("hotelId", hotelId);
		
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
