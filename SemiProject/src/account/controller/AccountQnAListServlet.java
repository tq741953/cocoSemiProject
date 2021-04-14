package account.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountQnAService;
import account.model.vo.QnA;
import account.model.vo.PageInfo;

/**
 * Servlet implementation class hotelQnA
 */
@WebServlet("/qna/mylist")
public class AccountQnAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountQnAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("accountId");
		List<QnA> list = new AccountQnAService().selectList(accountId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		AccountQnAService aService = new AccountQnAService();
		
		int listCount = aService.getAccountQnAListCountByAccountId(accountId);
		
		int pageLimit = 5;		
		int boardLimit = 8;	
		int maxPage;			
		int startPage;			
		int endPage;			
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit,
				maxPage, startPage, endPage);
		
		List<QnA> qList = aService.getAccountQnAListByAccountId(accountId, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("qList", qList);
		request.setAttribute("accountId", accountId);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/account/accountQnAListView.jsp");
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
