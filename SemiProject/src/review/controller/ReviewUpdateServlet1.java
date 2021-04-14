package review.controller;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/review/update")
public class ReviewUpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int star = Integer.parseInt(request.getParameter("star-input"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		Review r = new Review(title, content, star, no);
		
		int result = new ReviewService().reviewUpdate(r);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "리뷰 수정이 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review/detail?no="+ no);
			
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
