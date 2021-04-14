package Hotelinsert.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotelinsert.model.service.HotelService;
import Hotelinsert.model.vo.Hotel;
import Hotelinsert.model.vo.Hotel_file;

/**
 * Servlet implementation class HotelDetailServlet
 */
@WebServlet("/hotelinsert/detail")
public class HotelinsertDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelinsertDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Hotel_id = Integer.parseInt(request.getParameter("Hotel_id"));
		
		// 호텔등록 되어있는 정보 확인
		List<Hotel> hotel = new HotelService().hotlecheckboard(Hotel_id);
		// 호텔등록 되어있는 파일 정보 확인
		List<Hotel_file> hotel_file = new HotelService().hotel_filecheckboard(Hotel_id);
		
		request.setAttribute("hotel_file", hotel_file);
		
		if(hotel != null) {
			request.setAttribute("hotel", hotel);
			request.getRequestDispatcher("/views/Hotelinsert/hotelDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "사진 게시판 목록 조회 실패하였습니다.");
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
