package faq.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
@WebServlet("/faq/updateForm")
public class FaqUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
		
		List<Faq> faqlist = new FaqService().faqlist(no);
		// 상세보기에서 작성했으므로 다시 만들 필요 없이 호출 // 아니지 수정이지
//		Faq faq = new FaqService().faqDetail(no);
//		

		String page = "";
		if(faqlist != null) {
			request.setAttribute("faqlist", faqlist);
			page = "/views/faq/faqUpdateFormView.jsp";
		} else {
			request.setAttribute("msg", "공지사항 수정 화면을 불러오는데 실패했습니다.");
			page = "/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
