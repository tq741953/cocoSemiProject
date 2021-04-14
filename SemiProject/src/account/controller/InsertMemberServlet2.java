package account.controller;

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

import account.model.service.AccountService;
import account.model.vo.Account;
import account.model.vo.BusinessLicensePhoto;
import common.MyFileRenamePolicy;
import common.Utils;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet(name="InsertMemberServlet2", urlPatterns="/account/insert2")
public class InsertMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		String imgFile = request.getParameter("imgFile");
//        System.out.println(imgFile);
		
		if(ServletFileUpload.isMultipartContent(request)) {
			// 1_1. 전송파일 용량 제한 : 10Mbyte로 제한하는 경우
			int maxSize = 1024*1024*10;
			
			// 1_2. 웹 서버 컨테이너 경로(WebContent)
			String root = request.getSession().getServletContext().getRealPath("/");
//			System.out.println("root = " + root);
			
			// 1_3. 파일이 실제로 저장 될 경로
			String savePath = root + "resources\\insertJoinFile\\";
			
			MultipartRequest multiRequest
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			String accountId = multiRequest.getParameter("accountId");
//			System.out.println(accountId);
			String password = Utils.getSha512(multiRequest.getParameter("password"));
			String name = multiRequest.getParameter("userName");
			String email = multiRequest.getParameter("email");
			String phone = multiRequest.getParameter("phone");
			String bLicense = multiRequest.getParameter("bLicense");
			
			String imgFile = multiRequest.getFilesystemName("imgFile");
			
//			System.out.println(password);
			
			Account m = new Account(accountId, password, name, email, phone, bLicense);
//			System.out.println("m : " + m);
			
			// 회원가입인증 추가 시작 ------
			HttpSession session = request.getSession();
			
			
			session.setAttribute("checkEmail", m.getEmail());
			session.setAttribute("checkId", m.getAccountId());
			// 회원가입인증 추가 끝 ------
			
			
			List<String> originFiles = new ArrayList<>();
			List<String> changeFiles = new ArrayList<>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String fName = files.nextElement();  // files에 담겨있는 파일 리스트들의 name 값
//				System.out.println("name : " + fName);
				
				// 해당 file 태그에 첨부 된 파일이 있다면
				if(multiRequest.getFilesystemName(fName) != null) {
					// getFilesystemName()
					// -> MyFileRenamePolicy에서 작성한 대로 rename 된 파일명
					String fileRename = multiRequest.getFilesystemName(fName);
					// getOriginalFileName()
					// -> 실제 사용자가 업로드 할 때의 파일명
					String fileName = multiRequest.getOriginalFileName(fName);
					
					changeFiles.add(fileRename);
					originFiles.add(fileName);
//					System.out.println(fileName);
//					System.out.println(fileRename);
				}
			}
			
			List<BusinessLicensePhoto> fileList = new ArrayList<>();
			
			// 전송 순서가 화면의 element 순서와 역순이므로 반복문을 역으로 수행함
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				BusinessLicensePhoto blp = new BusinessLicensePhoto();
				blp.setFileName(originFiles.get(i));
				blp.setFileRename(changeFiles.get(i));
				blp.setFileUrl("/resources/insertJoinFile/");
				blp.setAccountId(accountId);

				
				fileList.add(blp);
			}
			
			System.out.println(fileList);
			
			
			int result = new AccountService().insertMember2(m, fileList);
			
			//DB에 저장했으니 google email 인증 페이지로 이동
			response.sendRedirect(request.getContextPath() +"/views/account/emailSendAction.jsp?email=" + email);
			
//			if(result > 0) {
//				request.getSession().setAttribute("msg", "회원 가입이 완료 되었습니다!");
//				response.sendRedirect(request.getContextPath());
//			} else {
//				request.setAttribute("msg", "회원 가입에 실패하였습니다.");
//				RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
//				view.forward(request, response);
//			}
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
