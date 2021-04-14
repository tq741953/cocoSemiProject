package faq.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static common.JDBCTemplate.*;
import faq.model.vo.Faq;



public class FaqDao {
	private Properties query = new Properties();
	
	public FaqDao () {
		String fileName = FaqDao.class.getResource("/sql/faq/faq-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 조회
	public List<Faq> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Faq> list = new ArrayList<>();
		String sql = query.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(rset.getInt("FAQ_NO"),
								 rset.getString("ACCOUNT_ID"),
								 rset.getString("FAQ_TITLE"),
								 rset.getString("FAQ_CONTENT"),
								 rset.getString("FAQ_ANSWER"),
								 rset.getDate("CREATE_DATE"),
								 rset.getDate("MODIFY_DATE"),
								 rset.getString("STATUS")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	// faq 작성
	public int insertFaq(Connection conn, Faq f) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getAccountId());
			pstmt.setString(2, f.getFaqTitle());
			pstmt.setString(3, f.getFaqContent());
			pstmt.setString(4, f.getFaqAnswer());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	// no로  faq상세보기
	public Faq faqDetail(Connection conn, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Faq f = null;
		String sql = query.getProperty("faqDetail");

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Faq(rset.getInt("FAQ_NO"),
						 	rset.getString("ACCOUNT_ID"),
						 	rset.getString("FAQ_TITLE"),
						 	rset.getString("FAQ_CONTENT"),
						 	rset.getString("FAQ_ANSWER"),
						 	rset.getDate("CREATE_DATE"),
						 	rset.getDate("MODIFY_DATE"),
						 	rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return f;
	}

	// faq 삭제
	public int deleteFaq(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = query.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	
	public List<Faq> faqlist(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Faq> faqlist = new ArrayList<>();
		
		String sql = query.getProperty("faqDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				faqlist.add(new Faq(rset.getInt("FAQ_NO"),
						 	rset.getString("ACCOUNT_ID"),
						 	rset.getString("FAQ_TITLE"),
						 	rset.getString("FAQ_CONTENT"),
						 	rset.getString("FAQ_ANSWER"),
						 	rset.getDate("CREATE_DATE"),
						 	rset.getDate("MODIFY_DATE"),
						 	rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return faqlist;
	}

	// 수정하기
	public int updateFaq(Connection conn, Faq f) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = query.getProperty("updateFaq");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getAccountId());
			pstmt.setString(2, f.getFaqTitle());
			pstmt.setString(3, f.getFaqContent());
			pstmt.setString(4, f.getFaqAnswer());
			pstmt.setInt(5, f.getFaqNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	// 검색으로 faq찾기
	public List<Faq> searchFaq(Connection conn, String searchCondition, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Faq> searchList = new ArrayList<>();
		String sql = "";
		
		if(searchCondition.equals("title")) {
			sql = query.getProperty("selectSearchTitleList");
		} else {
			sql = query.getProperty("selectSearchContentList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				searchList.add(new Faq(rset.getInt("FAQ_NO"),
										 rset.getString("ACCOUNT_ID"),
										 rset.getString("FAQ_TITLE"),
										 rset.getString("FAQ_CONTENT"),
										 rset.getString("FAQ_ANSWER"),
										 rset.getDate("CREATE_DATE"),
										 rset.getDate("MODIFY_DATE"),
										 rset.getString("STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return searchList;
		
	}

		
	
}
