package hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import account.model.vo.Account;

/**
 * Servlet implementation class sortPaymentServlet
 */
@WebServlet("/hotel/sortPayment")
public class sortPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sortPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchAdult = Integer.parseInt(request.getParameter("searchAdult"));
		int searchChild = Integer.parseInt(request.getParameter("searchChild"));
		String searchValue = request.getParameter("searchValue");
		String checkIn = (String)request.getSession().getAttribute("checkIn");
		String checkOut = (String)request.getSession().getAttribute("checkOut");
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		String orderby = order +" "+ sort;
		// 기본적으로 게시판은 1페이지부터 시작
		int currentPage = 1;
		
		// 페이지 전환 시 전달 받은 currentPage parameter가 있을 경우 적용
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelService HService = new HotelService();
		
		// 1. 게시글 총 갯수 구하기(검색 기준에 따라)
		int listCount = HService.getSearchListCount(searchValue, searchValue);
		
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
		
		// 정렬하러 페이징바 값과 같이 감
		List<Hotel> slist = new HotelService().sortPayment(pi, searchAdult, searchChild, searchValue, orderby);
		
		for(int i = 0; i < slist.size(); i++) {
		int result = HService.checkRoomCount(checkIn, checkOut, slist.get(i).getRoom_no());
		slist.get(i).setCheckedRoom(result);
		}
		
		JSONObject map = new JSONObject();
		map.put("slist", slist);
		map.put("loginUser", loginUser);
		map.put("pi", pi);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(map, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
