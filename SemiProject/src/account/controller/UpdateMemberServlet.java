package account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.model.service.AccountService;
import account.model.vo.Account;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/account/update")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("changephone");
		//String bLicense = request.getParameter("bLicense");

		String accountId = request.getParameter("accountId");
		
		Account m = new Account(accountId, name, email, phone);
		System.out.println(m);
		Account updateMember = new AccountService().updateMember(m);
		
		if(updateMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMember);
			session.setAttribute("msg", "성공적으로 회원 정보를 수정했습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.getSession().setAttribute("msg", "회원 정보 수정에 실패했습니다.");
			response.sendRedirect(request.getContextPath() + "/views/account/accountChange.jsp");
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
