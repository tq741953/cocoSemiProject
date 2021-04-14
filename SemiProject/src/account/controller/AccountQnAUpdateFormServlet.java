package account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountQnAService;
import account.model.vo.QnA;

/**
 * Servlet implementation class QnAUpdateFormServlet
 */
@WebServlet("/qna/updateForm")
public class AccountQnAUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountQnAUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		QnA q = new AccountQnAService().selectQnA(qnaNo);
		
		String page = "";
		if(q != null) {
			request.setAttribute("qna", q);
			page = "/views/account/accountQnAUpdateForm.jsp";
		} else {
			request.setAttribute("msg", "�������� ���� ȭ�� �ҷ����⸦ �����Ͽ����ϴ�.");
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
