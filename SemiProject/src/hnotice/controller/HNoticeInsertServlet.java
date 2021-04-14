package hnotice.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnotice.model.service.HNoticeService;
import hnotice.model.vo.HNotice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/hnotice/insert")
public class HNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String hnTitle = request.getParameter("title");
		String hnContent = request.getParameter("content");
		String accountId = request.getParameter("accountId");
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		HNotice n = new HNotice(hotelId,accountId, hnTitle, hnContent);
		
		
		int result = new HNoticeService().insertNotice(n);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "공지사항이 성공적으로 등록 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/hnotice/list?hotelId="+hotelId);
		} else {
			request.setAttribute("msg", "공지사항 작성에 실패했습니다.");
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
