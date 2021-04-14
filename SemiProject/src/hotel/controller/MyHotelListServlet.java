package hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import notice.model.service.NoticeService;
import account.model.vo.Account;
import hotel.model.vo.PageInfo;

/**
 * Servlet implementation class MyHotelListServlet
 */
@WebServlet("/myhotel/list")
public class MyHotelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHotelListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = ((Account)request.getSession().getAttribute("loginUser")).getAccountId();
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelService hService = new HotelService();
		
		int listCount = hService.getHotelListCountByAccountId(accountId);
		
		int pageLimit = 5;		// 하단 페이징바 수
		int hotelLimit = 8;	// 표시될 수
		int maxPage;			// ��ü ���������� ���� ������ ������
		int startPage;			// �� ������ �ϴܿ� ������ ���� ������
		int endPage;			// �� ������ �ϴܿ� ������ �� ������
		
		maxPage = (int)Math.ceil((double)listCount / hotelLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, hotelLimit,
				maxPage, startPage, endPage);
		
		List<Hotel> list = hService.getHotelListByAccountId(accountId, pi);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		RequestDispatcher view = request.getRequestDispatcher("/views/common/hotelMainPage.jsp");
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
