package hnotice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnotice.model.service.HNoticeService;
import hnotice.model.vo.HNotice;

/**
 * Servlet implementation class HNoticeUpdateServlet
 */
@WebServlet("/hnotice/update")
public class HNoticeUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");

      int hnno = Integer.parseInt(request.getParameter("hnno"));
      
      List<HNotice> nlist = new HNoticeService().updateNotice(hnno);
      
      if(!nlist.isEmpty()) {
         request.setAttribute("nlist", nlist);
         request.getRequestDispatcher("/views/hnotice/hnoticeUpdateForm.jsp").forward(request, response);
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