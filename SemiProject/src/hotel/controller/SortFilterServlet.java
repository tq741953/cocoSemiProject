package hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import account.model.vo.Account;

/**
 * Servlet implementation class SortFilterServlet
 */
@WebServlet("/hotel/sortFilter")
public class SortFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		int searchAdult = Integer.parseInt(request.getParameter("searchAdult"));
		int searchChild = Integer.parseInt(request.getParameter("searchAdult"));
		String searchValue = request.getParameter("searchValue");
		String checkIn = (String)request.getSession().getAttribute("checkIn");
		String checkOut = (String)request.getSession().getAttribute("checkOut");
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		String[] filter = request.getParameterValues("filter");
		
		// 기본적으로 게시판은 1페이지부터 시작
		int currentPage = 1;
		
		// 페이지 전환 시 전달 받은 currentPage parameter가 있을 경우 적용
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelService HService = new HotelService();
		
		// 1. 게시글 총 갯수 구하기(검색 기준에 따라)
		int listCount = 0;
		for(int i = 0; i < filter.length; i++) {
		listCount = HService.getfilterListCount(searchValue, searchValue, filter);
		};
		
		// 2. 페이지 처리용 변수
		int pageLimit = 10;		// 한 페이지 하단에 보여질 페이징바 갯수
		int boardLimit = 10;	// 한 페이지에 보여질 게시글 수
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage,
				startPage, endPage);
		
		List<Hotel> list = new ArrayList<>();
		
		list = new HotelService().FilterList(pi, searchAdult, searchChild, searchValue, filter);
		
		for(int i = 0; i < list.size(); i++) {
			int result = HService.checkRoomCount(checkIn, checkOut, list.get(i).getRoom_no());
			list.get(i).setCheckedRoom(result);
		}
		request.setAttribute("listCount", listCount);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/hotel/searchHotel.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
