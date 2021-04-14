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
import hotel.model.vo.Review;
import hotel.model.vo.RoomFile;

/**
 * Servlet implementation class HotelDetailServlet
 */
@WebServlet("/hotel/detail")
public class HotelDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("room_no"));
		List<Hotel> HList = new HotelService().selectHotel(rNo);
		// System.out.println(HList.get(0).getRoom_no());
		// 리뷰 가져 오기
		List<Review> LList = new ArrayList<>();
		int hId = HList.get(0).getHotel_id();
		LList = new HotelService().selectReview(hId);
		// System.out.println(LList);
		// 리뷰 평점 평균 내기
		int avg = new HotelService().getAvgGrade(hId);
		
		// 객실 사진 가져오기
		List<RoomFile> rList = new HotelService().selectRoomFile(hId);
		// System.out.println(LList);
		
		// 리뷰 평점
		request.setAttribute("avg", avg);
		if(rList != null) {
			request.setAttribute("rList", rList);
		}

		if(LList != null) {
			request.setAttribute("LList", LList);
		}
		if(HList != null) {
			request.setAttribute("HList", HList);
			request.getRequestDispatcher("/views/hotel/hotelDetail.jsp").forward(request, response);
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
