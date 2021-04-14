package hotel.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;

/**
 * Servlet implementation class SearchHotelServlet
 */
@WebServlet("/hotel/search")
public class SearchHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		String searchValue = request.getParameter("searchValue");	// 호텔 이름
		String searchValue2 = request.getParameter("searchValue");	// 호텔 주소 근데 생각해보니 변수하나만 선언해도 쿼리문 작성엔 문제없는데...
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		int searchAdult = Integer.parseInt(request.getParameter("searchAdult"));
		int searchChild = Integer.parseInt(request.getParameter("searchChild"));
		
		
		
		// 기본적으로 게시판은 1페이지부터 시작
		int currentPage = 1;
		
		// 페이지 전환 시 전달 받은 currentPage parameter가 있을 경우 적용
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelService HService = new HotelService();
		
		// 1. 게시글 총 갯수 구하기(검색 기준에 따라)
		int listCount = HService.getSearchListCount(searchValue, searchValue2);
		
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
		// 페이징 처리한 값 + 검색에대한 조건 조회하러 감
		List<Hotel> list = HService.selectSearchList(pi, searchValue, searchValue2, searchAdult, searchChild);
		
		// 방이 다찼는지 유효성 검사
		for(int i = 0; i < list.size(); i++) {
		int result = HService.checkRoomCount(checkIn, checkOut, list.get(i).getRoom_no());
		list.get(i).setCheckedRoom(result);
		// System.out.println(result);
		}
		// System.out.println(list);
		
		
		HttpSession session = request.getSession();
		request.setAttribute("listCount", listCount);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("searchAdult", searchAdult);	// 빼도 되는데 jsp 수정하기 귀찮아서 안바꿨어오..
		request.setAttribute("searchChild", searchChild);	// 얘두...
		
		// 세션에 보낼 객체들
		session.setAttribute("searchAdult", searchAdult);
		session.setAttribute("searchChild", searchChild);
		session.setAttribute("checkIn", checkIn);
		session.setAttribute("checkOut", checkOut);
		
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
