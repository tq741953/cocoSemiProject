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
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/hnotice/delete")
public class HNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeDeleteServlet() {
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
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		HNotice n = new HNotice();
		n.setHnTitle(hnTitle);
		n.setHnContent(hnContent);
		n.setHnNo(hnNo);
		
		System.out.println(hnTitle);
		System.out.println(hnContent);
		System.out.println(hnNo);
		
		int result = new HNoticeService().deleteNotice(n);
		System.out.println("result : " + result);
		
		if(result != 0) {
			System.out.println("이쪽으로 오나?1");
			request.getSession().setAttribute("msg", "공지사항 삭제가 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/hnotice/list?hotelId="+hotelId);
		} else {
			System.out.println("이쪽으로 오나?0");
			request.setAttribute("msg", "공지사항 삭제에 실패하였습니다.");
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
