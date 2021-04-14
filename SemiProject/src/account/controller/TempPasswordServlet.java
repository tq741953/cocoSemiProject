package account.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.model.service.AccountService;
import account.model.vo.Account;
import common.Utils;

/**
 * Servlet implementation class FindPwdServlet2
 */
@WebServlet(name = "TempPasswordServlet", urlPatterns = "/account/tempPwd")

public class TempPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TempPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String accountId = request.getParameter("accountId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Account m = new AccountService().findPwd(accountId, name, email);
		
		

		HttpSession session = request.getSession();

//		session.setAttribute("checkEmail", m.getEmail());
//		session.setAttribute("checkId", m.getAccountId());
		if (m == null || !m.getEmail().equals(email) || !m.getAccountId().equals(accountId) || !m.getName().equals(name)) {
//			request.setAttribute("msg", "일치하는 정보가 없습니다. 다시 확인해주세요.");
			request.getRequestDispatcher("/views/account/findPwdResult.jsp").forward(request, response);
		} else {

			// 먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
	
			// mail server 설정
			String host = "smtp.googlemail.com";
			String user = "semicocoad@gmail.com"; // 자신의 네이버 계정
			String pwd = "coconenne";// 자신의 네이버 패스워드
	
			// 메일 받을 주소
			/* String to_email = m.getEmail(); */
			String to_email = m.getEmail();
	
			// SMTP 서버 정보를 설정한다.
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
	
			// 인증 번호 생성기
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 10; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			String AuthenticationKey = temp.toString();
			System.out.println(AuthenticationKey);
	
			Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pwd);
				}
			});
			
		
			// email 전송
			try {
				MimeMessage msg = new MimeMessage(session1);
				msg.setFrom(new InternetAddress(user, pwd));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
	
				// 메일 제목
				msg.setSubject("안녕하세요! 코코넨네 인증 메일입니다.");
				// 메일 내용
				msg.setText("인증 번호는 : " + temp + " 입니다. 임시 비밀번호로 로그인 해주세요.");
	
				Transport.send(msg);
	
				String nPwd = Utils.getSha512(AuthenticationKey);
				
				m.setPassword(nPwd);
	
				int result = new AccountService().tempPassword(m);
				
				
	
				System.out.println("이메일 전송");
	
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			
			request.getSession().setAttribute("msg", "가입하신 이메일로 임시 비밀번호가 발송되었습니다. 메일을 확인해주세요.");
			response.sendRedirect(request.getContextPath() + "/views/account/loginForm.jsp");
		}
//		HttpSession saveKey = request.getSession();
//		saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
		// 패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
		/*
		 * req.setAttribute("id", memberId);
		 * req.getRequestDispatcher("/views/login_myPage/searchPasswordEnd.jsp").forward
		 * (req, resp);
		 */

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
