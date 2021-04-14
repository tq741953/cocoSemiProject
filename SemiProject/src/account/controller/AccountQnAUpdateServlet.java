package account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountQnAService;
import account.model.vo.QnA;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class QnAUpdateServlet
 */
@WebServlet("/qna/update")
public class AccountQnAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountQnAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		QnA q = new QnA();
		q.setQna_title(title);
		q.setQna_content(content);
		q.setQna_no(qnaNo);
		
		int result = new AccountQnAService().updateQnA(q);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/qna/mydetail?qnaNo=" + qnaNo);
		} else {
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
