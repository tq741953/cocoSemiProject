package review.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/review/insert")
public class ReviewInsertServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet1() {
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
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		int star = Integer.parseInt(request.getParameter("star-input"));
		int no = Integer.parseInt(request.getParameter("no"));
System.out.println(title);
System.out.println(id);
System.out.println(content);
System.out.println(star);
System.out.println(no);
		
		Review r = new Review(id, no, title, content, star);
		
		int result = new ReviewService().reviewInsert(r);
	
		
		
		
		if(result > 0) {
			
			// 직접 FaqListView.jsp로 forward하면 오류 발생
			request.getSession().setAttribute("msg", "리뷰가 성공적으로 등록 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/review/insertlist");
		} else {
			request.setAttribute("msg", "리뷰작성에 실패했습니다.모두 입력해주세요!");
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
