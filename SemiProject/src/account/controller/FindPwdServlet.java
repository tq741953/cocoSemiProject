package account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountService;
import account.model.vo.Account;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/account/findPwd")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String accountId = request.getParameter("accountId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Account member = new AccountService().findPwd(accountId, name, email);
		
		if(member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/views/account/findPwdResult.jsp").forward(request, response);
			
		} else {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/views/account/findPwdResult.jsp").forward(request, response);
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
