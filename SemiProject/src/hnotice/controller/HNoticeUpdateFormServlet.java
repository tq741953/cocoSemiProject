package hnotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnotice.model.service.HNoticeService;
import hnotice.model.vo.HNotice;

/**
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet("/hnotice/updateForm")
public class HNoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String hnTitle = request.getParameter("title");
		String hnContent = request.getParameter("content");
		int hnNo = Integer.parseInt(request.getParameter("hnno"));
		
		HNotice n = new HNotice();
		n.setHnTitle(hnTitle);
		n.setHnContent(hnContent);
		n.setHnNo(hnNo);
		
		int result = new HNoticeService().selectupdateHNotice(n);

		String page = "";
		if(result != 0) {
			request.getSession().setAttribute("msg", "게시글 수정이 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/hnotice/detail?hnno="+ hnNo);
		} else {
			request.setAttribute("msg", "공지사항 수정 화면을 불러오는데 실패했습니다.");
			page = "/views/common/errorPage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
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
