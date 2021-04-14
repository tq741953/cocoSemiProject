package account.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import account.model.vo.Account;
import account.model.vo.BusinessLicensePhoto;

import static common.JDBCTemplate.close;

public class AccountDao {
	private Properties query = new Properties();
	
	public AccountDao() {
		String fileName = AccountDao.class.getResource("/sql/account/account-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Account loginMember(Connection conn, Account m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Account loginUser = null;
		String sql = query.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getAccountId());
			pstmt.setString(2, m.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Account(rset.getString("account_id"),
									   rset.getString("password"),
									   rset.getString("name"),
									   rset.getString("email"),
									   rset.getString("phone"),
									   rset.getInt("auth"),
									   rset.getString("status"),
									   rset.getInt("email_auth"),
									   rset.getString("business_license"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	// 2_1. 일반회원 가입(회원인증가입)
	public int insertMember1(Connection conn, Account m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertMember1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getAccountId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 2_2. 기업회원 가입(회원인증가입)
		public int insertMember2(Connection conn, Account m) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = query.getProperty("insertMember2");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getAccountId());
				pstmt.setString(2, m.getPassword());
				pstmt.setString(3, m.getName());
				pstmt.setString(4, m.getEmail());
				pstmt.setString(5, m.getPhone());
				pstmt.setString(6, m.getbLicense());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		
	
	public int insertMember2nd(Connection conn, List<BusinessLicensePhoto> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertMember2nd");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				BusinessLicensePhoto blp = fileList.get(i);
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, blp.getAccountId());
				pstmt.setString(2, blp.getFileName());
				pstmt.setString(3, blp.getFileRename());
				pstmt.setString(4, blp.getFileUrl());
				
				result += pstmt.executeUpdate();
				System.out.println(blp);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	// 3. 회원 탈퇴
	public int deleteMember(Connection conn, String accountId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accountId);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 4. 회원 정보 수정
	public int updateMember(Connection conn, Account m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			//pstmt.setString(4, m.getbLicense());
			pstmt.setString(4, m.getAccountId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 5. 회원 한명 조회
	public Account selectMember(Connection conn, String accountId) {
		Account member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accountId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Account(rset.getString("account_id"),
								    rset.getString("password"),
								    rset.getString("name"),
								    rset.getString("email"),
								    rset.getString("phone"),
								    rset.getInt("auth"),
								    rset.getString("status"),
								    rset.getString("business_license"),
								    rset.getInt("email_auth"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	// 비밀번호 수정
	public int updatePwd(Connection conn, String accountId, String password, String newPassword) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPassword);
			pstmt.setString(2, accountId);
			pstmt.setString(3, password);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 아이디 찾기
	public Account findId(Connection conn, String name, String email) {
		Account member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("findId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Account(rset.getString("account_id"),
					    rset.getString("name"),
					    rset.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	// 아이디 중복체크
	public int idCheck(Connection conn, String accountId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = query.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	// 비밀번호 찾기
	public Account findPwd(Connection conn, String accountId, String name, String email) {
		Account member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("findPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Account(rset.getString("account_id"),
					    rset.getString("password"),
					    rset.getString("name"),
					    rset.getString("email"),
					    rset.getString("phone"),
					    rset.getInt("auth"),
					    rset.getString("status"),
					    rset.getString("business_license"),
					    rset.getInt("email_auth"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
	// 임시비밀번호 암호화해서 DB에 바꾸기
		public int tempPassword(Connection conn, Account m) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = query.getProperty("tempPwd");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getPassword());
				pstmt.setString(2, m.getAccountId());
				
				
				result = pstmt.executeUpdate();
				
				System.out.println(m);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}

	public int updateDownloadCount(Connection conn, int fileId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("updateDownloadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fileId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public BusinessLicensePhoto selectBusinessLicensePhoto(Connection conn, int fileId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BusinessLicensePhoto blp = null;
		String sql = query.getProperty("selectBusinessLicensePhoto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fileId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				blp = new BusinessLicensePhoto(rset.getInt("fileId"),
									rset.getString("accountId"),
									rset.getString("fileName"),
									rset.getString("fileRename"),
									rset.getString("fileUrl"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return blp;
	}

	public int updateEmail(Connection conn, Account m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("updateEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getAccountId());
			pstmt.setString(2, m.getEmail());
			
			result = pstmt.executeUpdate();
			
			System.out.println(m);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
