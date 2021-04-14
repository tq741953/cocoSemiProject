package hnotice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnotice.model.service.HNoticeService;
import hnotice.model.vo.HNotice;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/hnotice/detail")
public class HNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hnno = Integer.parseInt(request.getParameter("hnno"));
		
		HNotice notice = new HNoticeService().selectdetailList(hnno);
		
		String page = "";
		if(notice != null) {
			request.setAttribute("notice", notice);
			page = "/views/hnotice/hnoticeDetailView.jsp";
		} else {
			request.setAttribute("msg", "공지사항 게시글 조회에 실패했습니다.");
			page = "/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
