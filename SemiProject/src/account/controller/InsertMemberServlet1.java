package account.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.model.service.AccountService;
import account.model.vo.Account;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet(name="InsertMemberServlet1", urlPatterns="/account/insert1")
public class InsertMemberServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String accountId = request.getParameter("accountId");
		String password = request.getParameter("password");
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String bLicense = request.getParameter("bLicense");
		
		Account m = new Account(accountId, password, name, email, phone, bLicense);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("checkEmail", m.getEmail());
		session.setAttribute("checkId", m.getAccountId());
		
		int result = new AccountService().insertMember1(m);
		
		//DB에 저장했으니 google email 인증 페이지로 이동
				response.sendRedirect(request.getContextPath() +"/views/account/emailSendAction.jsp?email=" + email);
		
//		if(result > 0) {
//			request.getSession().setAttribute("msg", "회원 가입이 완료 되었습니다!");
//			response.sendRedirect(request.getContextPath());
//		} else {
//			request.setAttribute("msg", "회원 가입에 실패하였습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
