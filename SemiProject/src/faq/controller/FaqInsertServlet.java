package faq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;
import account.model.vo.Account;


/**
 * Servlet implementation class FaqInsertServlet
 */
@WebServlet("/faq/insert")
public class FaqInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 넘어온 한글 값 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// DB 저장에 필요한 데이터 parameter에서 추출
		String title = request.getParameter("title");	
		String accuontId = request.getParameter("accuontId");
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		
		Faq f = new Faq(accuontId, title, content1, content2);
		
		System.out.println("f: "+ f);
		
		// 비즈니스 로직 수행
		int result = new FaqService().insertFaq(f);
		
		if(result > 0) {
			
			// 직접 FaqListView.jsp로 forward하면 오류 발생
			request.getSession().setAttribute("msg", "FaQ가 성공적으로 등록 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/faq/list");
		} else {
			request.setAttribute("msg", "FaQ 작성에 실패했습니다.");
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
