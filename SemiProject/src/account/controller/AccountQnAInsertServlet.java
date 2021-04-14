package account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountQnAService;
import account.model.vo.Account;
import account.model.vo.QnA;

/**
 * Servlet implementation class HotelQnAInsertServlet
 */
@WebServlet("/qna/insert")
public class AccountQnAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountQnAInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		QnA q = new QnA(id, title, content, writer, hotelId);
		int result = new AccountQnAService().insertQnA(q);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/qna/list?hotelId="+hotelId);
		} else {
			request.setAttribute("msg", "Q&A 작성실패");
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
