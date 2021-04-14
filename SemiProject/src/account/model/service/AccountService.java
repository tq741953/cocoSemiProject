package account.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.tomcat.jdbc.pool.jmx.ConnectionPoolMBean;

import account.model.dao.AccountDao;
import account.model.vo.Account;
import account.model.vo.BusinessLicensePhoto;

import static common.JDBCTemplate.*;

public class AccountService {
	// 1. 로그인
	public Account loginMember(Account m) {
		Connection conn = getConnection();
		
		Account loginUser = new AccountDao().loginMember(conn, m);
		
		close(conn);
		
		return loginUser;
	}

	// 2_1. 일반회원 가입(회원인증가입)
	public int insertMember1(Account m) {
		Connection conn = getConnection();
		
		int result = new AccountDao().insertMember1(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
//	
//	// 회원인증가입
//	public int insertMember3(Account m) {
//		Connection conn = getConnection();
//		
//		int result = new AccountDao().insertMember3(conn, m);
//		
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		close(conn);
//		return result;
//	}
//	
	// 2_2. 기업회원 가입
//	public int insertMember2(Account m) {
//		Connection conn = getConnection();
//		
//		int result = new AccountDao().insertMember2(conn, m);
//		
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		close(conn);
//		return result;
//	}
	
	// 2_2. 기업회원 가입(회원인증가입)
	public int insertMember2(Account m, List<BusinessLicensePhoto> fileList) {
		Connection conn = getConnection();

		int result1 = new AccountDao().insertMember2(conn, m);
		int result2 = new AccountDao().insertMember2nd(conn, fileList);
		int result = 0;
		if(result1 > 0 && result2 == fileList.size()) {
			result = 1;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 3. 회원 탈퇴
	public int deleteMember(String accountId) {
		Connection conn = getConnection();
		
		int result = new AccountDao().deleteMember(conn, accountId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 4. 회원 정보 수정
	public Account updateMember(Account m) {
		Connection conn = getConnection();
		int result = new AccountDao().updateMember(conn, m);
		
		Account updateMember = null;
		if(result > 0) {
			commit(conn);
			updateMember = new AccountDao().selectMember(conn, m.getAccountId());
		} else {
			rollback(conn);
		}
		close(conn);
		
		return updateMember;
	}

	// 비밀번호 수정
	public Account updatePwd(String accountId, String password, String newPassword) {
		Connection conn = getConnection();
		
		int result = new AccountDao().updatePwd(conn, accountId, password, newPassword);
		
		Account updateMember = null;
		if(result > 0) {
			commit(conn);
			updateMember = new AccountDao().selectMember(conn, accountId);
		} else {
			rollback(conn);
		}
		close(conn);
				
		return updateMember;
		
	}

	// 아이디 찾기
	public Account findId(String name, String email) {
		Connection conn = getConnection();
		
		Account member = new AccountDao().findId(conn, name, email);
		
		close(conn);
		
		return member;
	}
	
	public int idCheck(String accountId) {
		Connection conn = getConnection();
		
		int result = new AccountDao().idCheck(conn, accountId);
		
		close(conn);
		
		return result;
	}

	// 비밀번호 찾기
	public Account findPwd(String accountId, String name, String email) {
		Connection conn = getConnection();
		
		Account m = new AccountDao().findPwd(conn, accountId, name, email);
		
		close(conn);
		
		return m;
	}
	
	// 암호화 비밀번호 바꾸기
	public int tempPassword(Account m) {
		Connection conn = getConnection();
		
		int result = new AccountDao().tempPassword(conn, m);
		
		close(conn);
		
		return result;
	}

	public BusinessLicensePhoto selectBusinessLicensePhoto(int fileId) {
		Connection conn = getConnection();
		
		int result = new AccountDao().updateDownloadCount(conn, fileId);
		
		BusinessLicensePhoto blp = null;
		
		if(result > 0) {
			blp = new AccountDao().selectBusinessLicensePhoto(conn, fileId);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return blp;
	}

	public int updateEmail(Account m) {
		Connection conn = getConnection();
		
		int result = new AccountDao().updateEmail(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	


}
