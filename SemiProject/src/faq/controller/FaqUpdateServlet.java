package faq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;


/**
 * Servlet implementation class FaqUpdateServlet
 */
@WebServlet("/faq/update")
public class FaqUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String ask = request.getParameter("ask");
		String answer = request.getParameter("answer");
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		Faq f = new Faq();
		f.setFaqTitle(title);
		f.setAccountId(id);
		f.setFaqContent(ask);
		f.setFaqAnswer(answer);
		f.setFaqNo(no);
		
		int result = new FaqService().updateFaq(f);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "FaQ 수정이 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/faq/detail?no="+ no);
			
		}else {
			request.setAttribute("msg", "수정에 실패하였습니다.");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request,response);
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
