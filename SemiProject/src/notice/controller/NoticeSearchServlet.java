package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/notice/search")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchCondition = request.getParameter("searchCondition");
		String search = request.getParameter("search");
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		NoticeService nService = new NoticeService();
		
		// 1. �Խñ� �� ���� ���ϱ�(�˻� ���ؿ� ����)
		int listCount = nService.getSearchListCount(searchCondition, search);
		
		// 2. ����¡ ó���� ����
		int pageLimit = 5;		// �� ������ �ϴܿ� ������ ������ ��
		int noticeLimit = 7;	// �� �������� ������ �Խñ� �ִ� ��
		int maxPage;			// ��ü ���������� ���� ������ ������
		int startPage;			// �� ������ �ϴܿ� ������ ���� ������
		int endPage;			// �� ������ �ϴܿ� ������ �� ������
		
		maxPage = (int)Math.ceil((double)listCount / noticeLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, noticeLimit,
				maxPage, startPage, endPage);
		
		List<Notice> list = nService.selectSearchList(pi, searchCondition, search);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeListView.jsp");
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
