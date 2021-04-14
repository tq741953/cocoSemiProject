package facilities.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facilities.model.service.FacilitiesService;
import facilities.model.vo.Facilities;
import facilities.model.vo.Room_file;

/**
 * Servlet implementation class FacilitiesDetailServlet
 */
@WebServlet("/facilities/detail")
public class FacilitiesDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilitiesDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Room_no = Integer.parseInt(request.getParameter("Room_no"));
		
		List<Facilities> facilities = new FacilitiesService().selectRoomBoard(Room_no);
		List<Room_file> room_file = new FacilitiesService().selectRoom_fileBoard(Room_no);
		
		request.setAttribute("room_file", room_file);
		
		if(facilities != null) {
			request.setAttribute("facilities", facilities);
			request.getRequestDispatcher("/views/facilities/facilitiesDetailView.jsp").forward(request, response);
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
