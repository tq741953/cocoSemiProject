package account.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountService;
import account.model.vo.Account;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet(name="UpdatePasswordServlet", urlPatterns="/account/updatePwd")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String accountId = ((Account)request.getSession().getAttribute("loginUser")).getAccountId();
		
		Account updateMember = new AccountService().updatePwd(accountId, password, newPassword);
		
		if(updateMember != null) {
			request.setAttribute("result", "success");
			request.getSession().setAttribute("loginUser", updateMember);
		} else {
			request.setAttribute("result", "fail");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/views/account/pwdUpdateForm.jsp");
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
