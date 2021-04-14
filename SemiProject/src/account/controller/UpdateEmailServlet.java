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
 * Servlet implementation class UpdateEmailServlet
 */
@WebServlet("/account/updateEmail")
public class UpdateEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = (String)request.getSession().getAttribute("checkEmail");
		String accountId = (String)request.getSession().getAttribute("checkId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String bLicense = request.getParameter("bLicense");
		
		Account m = new Account(accountId, password, name, email, phone, bLicense);
		
//		Account cm = new Account(email);
		
		int result = new AccountService().updateEmail(m);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "인증이 성공하여 로그인이 가능합니다!");
			response.sendRedirect(request.getContextPath());
		} else {
			request.getSession().setAttribute("msg", "로그인이 불가능합니다!");
			response.sendRedirect(request.getContextPath());
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
