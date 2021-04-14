package facilities.controller;

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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import account.model.vo.Account;
import common.MyFileRenamePolicy;
import facilities.model.service.FacilitiesService;
import facilities.model.vo.Facilities;
import facilities.model.vo.Room_file;
import oracle.net.aso.f;

/**
 * Servlet implementation class FacilitiesInsertServlet
 */
@WebServlet("/facilities/insert")
public class FacilitiesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilitiesInsertServlet() {
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
			// 웹 서버 컨테이너 경로(WebContent)
			String root = request.getSession().getServletContext().getRealPath("/");
			
			// 파일이 실제로 정장되는 위치
			String savePath = root + "resources\\uploadFiles\\";
			
			MultipartRequest multiRequest
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			int hotelId = Integer.parseInt(multiRequest.getParameter("hotelId"));
			int Room_count = Integer.parseInt(multiRequest.getParameter("Room_count"));
			int Room_price = Integer.parseInt(multiRequest.getParameter("Room_price"));
			int Room_maximum = Integer.parseInt(multiRequest.getParameter("Room_maximum"));
			int Adult_count = Integer.parseInt(multiRequest.getParameter("Adult_count"));
			int Child_count = Integer.parseInt(multiRequest.getParameter("Child_count"));
			String Bed_type = multiRequest.getParameter("Bed_type");
			String Room_type = multiRequest.getParameter("Room_type");
			String Hotel_service = multiRequest.getParameter("Hotel_service");
			String Account_id = ((Account)request.getSession().getAttribute("loginUser")).getAccountId();
			
			Facilities f = new Facilities();
			f.setHotel_id(hotelId);
			f.setRoom_count(Room_count);
			f.setRoom_price(Room_price);
			f.setRoom_maximum(Room_maximum);
			f.setAdult_count(Adult_count);
			f.setChild_count(Child_count);
			f.setBed_type(Bed_type);
			f.setRoom_type(Room_type);
			f.setHotel_service(Hotel_service);
			f.setAccount_id(Account_id);
			
			List<String> originFiles = new ArrayList<>();

			List<String> changeFiles = new ArrayList<>();
			
			Enumeration<String> files =  multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				if(multiRequest.getFilesystemName(name) != null) {
					String changeName = multiRequest.getFilesystemName(name);
					String originName = multiRequest.getOriginalFileName(name);
					
					changeFiles.add(changeName);
					originFiles.add(originName);
				}
			}

			List<Room_file> room_file = new ArrayList<>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Room_file r = new Room_file();
				r.setFile_name(originFiles.get(i));
				r.setFile_rename(changeFiles.get(i));
				r.setFile_url("/resources/uploadFiles/");
				
				room_file.add(r);
			}
			
			int result = new FacilitiesService().roomInformationInsert(f, room_file);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/facilities/list?hotelId="+hotelId);
			} else {
				for(int i = 0; i < changeFiles.size(); i++) {
					File failedFile = new File(savePath + changeFiles.get(i));
					failedFile.delete();
				}
				request.setAttribute("msg", "객실을 등록 실패 하였습니다.");
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
