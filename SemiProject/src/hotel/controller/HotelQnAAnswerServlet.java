package hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.service.HotelQnAService;
import hotel.model.vo.QnA;


/**
 * Servlet implementation class HotelQnAAnswerServlet
 */
@WebServlet("/qnaAnswer/insert")
public class HotelQnAAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelQnAAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String answer = request.getParameter("answer");
		
		QnA q = new QnA(qnaNo, id, hotelId, content, answer);
		
		int result = new HotelQnAService().insertQnAAnswer(q);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/qna/detail?qnaNo="+qnaNo);
		} else {
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
