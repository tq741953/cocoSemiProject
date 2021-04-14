package account.model.dao;

import static common.JDBCTemplate.close;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import account.model.vo.QnA;
import account.model.vo.PageInfo;

public class AccountQnADao {
	private Properties query = new Properties();
	
	public AccountQnADao() {
		String fileName = AccountQnADao.class.getResource("/sql/account/account-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public List<QnA> selectList(Connection conn, String accountId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<QnA> list = new ArrayList<>();
		String sql = query.getProperty("selectQnAList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accountId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QnA(rset.getInt("qna_no"),
								 rset.getString("account_id"),
								 rset.getInt("hotel_id"),
								 rset.getString("qna_title"),
								 rset.getString("qna_content"),
								 rset.getString("qna_answer"),
								 rset.getDate("create_date"),
								 rset.getString("status"),
								 rset.getInt("qnacount"),
								 rset.getInt("qna_status"),
								 rset.getDate("modify_date"),
								 rset.getString("hotel_name"),
								 rset.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public int increaseCount(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public QnA selectQnA(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		QnA q = null;
		String sql = query.getProperty("selectQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new QnA(rset.getInt("qna_no"),
							rset.getString("account_id"),
							rset.getInt("hotel_id"),
							rset.getString("qna_title"),
							rset.getString("qna_content"),
							rset.getString("qna_answer"),
							rset.getDate("create_date"),
							rset.getString("status"),
							rset.getInt("qnacount"),
							rset.getInt("qna_status"),
							rset.getDate("modify_date"),
							rset.getString("hotel_name"),
							rset.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}

	public int insertQnA(Connection conn, QnA q) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getAccount_id());
			pstmt.setInt(2, q.getHotel_id());
			pstmt.setString(3, q.getQna_title());
			pstmt.setString(4, q.getQna_content());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	public int updateQnA(Connection conn, QnA q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = query.getProperty("updateQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getQna_title());
			pstmt.setString(2, q.getQna_content());
			pstmt.setInt(3, q.getQna_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteQnA(Connection conn, int qnaNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = query.getProperty("deleteQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getAccountQnAListCountByAccountId(Connection conn, String accountId) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getAccountQnAListCountByAccountId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accountId);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
	}

	public List<QnA> getAccountQnAListByAccountId(Connection conn, String accountId, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<QnA> list = new ArrayList<>();
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		String sql = query.getProperty("getAccountQnAListByAccountId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accountId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QnA(rset.getInt("qna_no"),
								rset.getString("account_id"),
								rset.getInt("hotel_id"),
								rset.getString("qna_title"),
								rset.getString("qna_content"),
								rset.getString("qna_answer"),
								rset.getDate("create_date"),
								rset.getString("status"),
								rset.getInt("qnacount"),
								rset.getInt("qna_status"),
								rset.getDate("modify_date"),
								rset.getString("hotel_name"),
								rset.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
