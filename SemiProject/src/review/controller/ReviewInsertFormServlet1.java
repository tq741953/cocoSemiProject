package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;


import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReservationInsertServlet
 */
@WebServlet("/review/insertForm")
public class ReviewInsertFormServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertFormServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 넘어온 한글 값 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		//System.out.println("no : " + no);
		
		
		Review r = new ReviewService().reviewInsertForm(no);
		
		
		
		String page = "";
		if(r != null) {
			request.setAttribute("r", r);
			page="/views/review/reviewInsertForm.jsp";
		} else {
			request.setAttribute("msg", "리뷰조회에 실패했습니다.");
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
