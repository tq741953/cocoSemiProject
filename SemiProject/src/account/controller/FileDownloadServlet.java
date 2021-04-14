package account.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.model.service.AccountService;
import account.model.vo.BusinessLicensePhoto;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/account/download")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileId = Integer.parseInt(request.getParameter("fileId"));

		BusinessLicensePhoto file = new AccountService().selectBusinessLicensePhoto(fileId);
		
		// 다운로드 수 증가한 file 객체 출력
		// System.out.println("file : " + file);
		
		// 다운로드 하고자 하는 파일 객체 생성
		String root = request.getSession().getServletContext().getRealPath("/");
		File downFile = new File(root + file.getFileUrl() + file.getFileRename());
		
		// 강제적으로 다운로드 처리
		// (response header 영역에 다운 받을 파일 이름에 대한 정보들을 달아주는 과정)
		// 파일명의 경우 changeName이 아니라 originName으로 다운 받을 수 있도록 처리
		// => 네트워크로 전달할 설정들을 헤더라는 설정 공간에 등록
		
		// 1. 한글명 인코딩 처리
		String FileName = new String(file.getFileName().getBytes("UTF-8"), "ISO-8859-1");
		
		// 2. Content-Disposition : 파일 다운로드를 처리하는 HTTP 헤더
		// 웹 서버 응답에 이 헤더를 포함하면 그 내용(파일 데이터)을 웹 브라우저라도 바로 보내거나
		// 내려받도록 설정할 수 있음
		response.setHeader("Content-Disposition", "BusinessLicensePhoto; filename=\"" + FileName + "\"");
		// -> 해당 파일명대로 사용자에게 보여짐
		
		// 3. 전송할 크기만큼 사용자 컴퓨터에게 공간 확보 요청
		response.setContentLength((int)downFile.length());
		
		// 4. 클라이언트로 내보낼 출력 스트림 생성
		ServletOutputStream downOut = response.getOutputStream();
		
		// 5. 폴더에서 파일 읽을 스트림 생성
		BufferedInputStream buf = new BufferedInputStream(new FileInputStream(downFile));
		
		// 6. 폴더에서 파일을 읽어와 클라이언트로 출력
		int readBytes = 0;
		while((readBytes = buf.read()) != -1) {
			downOut.write(readBytes);
		}
		
		// 7. 스트림 닫기
		downOut.close();
		buf.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
