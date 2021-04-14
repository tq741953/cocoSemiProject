package account.controller;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.model.service.AccountService;
import account.model.vo.Account;
import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns="/account/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("accountId");
		String password = request.getParameter("password");
		
		Account loginUser = new AccountService().loginMember(new Account(accountId, password));
		
		if(loginUser != null && loginUser.getStatus().equals("Y") && loginUser.getEmailAuth() == 1) {

			HttpSession session = request.getSession();
			
			
			session.setAttribute("loginUser", loginUser);

			if(loginUser.getAuth() == 1) {
				RequestDispatcher view = request.getRequestDispatcher("/views/common/mainPage.jsp");
				view.forward(request, response);
			} else if(loginUser.getAuth() == 2) {
				response.sendRedirect(request.getContextPath() + "/myhotel/list");
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/views/common/adminMainPage.jsp");
				view.forward(request, response);
			}
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "일치하는 정보가 없습니다. 다시 시도해주세요.");
			request.getRequestDispatcher("/views/account/loginForm.jsp").forward(request, response);
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
