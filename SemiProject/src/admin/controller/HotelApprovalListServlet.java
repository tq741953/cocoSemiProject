package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.vo.HotelLicensePhoto;
import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;

/**
 * Servlet implementation class AdminApproval
 */
@WebServlet("/admin/approvalList")
public class HotelApprovalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelApprovalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		HotelService hService = new HotelService();
		
		int listCount = hService.getListCount();
		
		int pageLimit = 5;		// 하단 페이징바 수
		int boardLimit = 6;	// 표시될 공지사항 개수
		int maxPage;			// ��ü ���������� ���� ������ ������
		int startPage;			// �� ������ �ϴܿ� ������ ���� ������
		int endPage;			// �� ������ �ϴܿ� ������ �� ������
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit,
				maxPage, startPage, endPage);
		
		List<Hotel> list = new HotelService().selectList(pi);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/adminView.jsp");
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
