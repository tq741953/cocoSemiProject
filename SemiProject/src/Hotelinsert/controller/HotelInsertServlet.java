package Hotelinsert.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import Hotelinsert.model.service.HotelService;
import Hotelinsert.model.vo.Hotel;
import Hotelinsert.model.vo.Hotel_file;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class HotelInsertServlet
 */
@WebServlet("/hotelinsert/insert")
public class HotelInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			
			String savePath = root + "resources\\uploadFiles\\";
			
			MultipartRequest multiRequest
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String Account_id = multiRequest.getParameter("Account_id");
			String Hotel_name = multiRequest.getParameter("Hotel_name");
			String Hotel_address = multiRequest.getParameter("Hotel_address");
			String Hotel_phone = multiRequest.getParameter("Hotel_phone");
			String Business_license = multiRequest.getParameter("Business_license");
			
			Hotel h = new Hotel();
			h.setAccount_id(Account_id);
			h.setHotel_name(Hotel_name);
			h.setHotel_address(Hotel_address);
			h.setHotel_phone(Hotel_phone);
			h.setBusiness_license(Business_license);
			
			Hotel_file f1 = new Hotel_file();
			Hotel_file f2 = new Hotel_file();
			
			// 호텔 대표 사진
			String changeName1 = multiRequest.getFilesystemName("thumbnailImg");
			String originName1 = multiRequest.getOriginalFileName("thumbnailImg");
			
			// 사업자 등록증 
			String changeName2 = multiRequest.getFilesystemName("contentImg1");
			String originName2 = multiRequest.getOriginalFileName("contentImg1");
			
			f1.setFile_name(originName1);
			f1.setFile_rename(changeName1);
			
			f2.setFile_name(originName2);
			f2.setFile_rename(changeName2);
			
			f1.setFile_url("/SemiProject/resources/uploadFiles/");
			f2.setFile_url("/SemiProject/resources/uploadFiles/");
			
			int result = new HotelService().hotelBoardInsert(h, f1 ,f2);
			
			if(result > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "호텔 추가가 완료되었습니다. 관리자 승인 후 호텔 조회 및 기타기능이 가능합니다.");
				response.sendRedirect(request.getContextPath() + "/hotel/list");
			} else {
				request.setAttribute("msg", "호텔을 등록 실패 하였습니다.");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
				
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
