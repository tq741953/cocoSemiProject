package hotel.model.dao;

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

import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import hotel.model.vo.QnA;
import notice.model.vo.Notice;

public class HotelQnADao {
	private Properties query = new Properties();
	
	public HotelQnADao() {
		String fileName = HotelQnADao.class.getResource("/sql/hotel/hotel-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public List<QnA> selectList(Connection conn, int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<QnA> list = new ArrayList<>();
		String sql = query.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QnA(rset.getInt("qna_no"),
								 rset.getString("account_id"),
								 rset.getInt("hotel_id"),
								 rset.getString("qna_title"),
								 rset.getString("qna_content"),
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

	public int getHotelQnAListCountByHotelId(Connection conn, int hotelId) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getHotelQnAListCountByHotelId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelId);
			
			
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

	public List<QnA> getHotelQnAListByHotelId(Connection conn, int hotelId, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<QnA> list = new ArrayList<>();
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		String sql = query.getProperty("getHotelQnAListByHotelId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelId);
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

	public int insertQnAAnswer(Connection conn, QnA q) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertQnAAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getQna_answer());
			pstmt.setInt(2, q.getQna_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<QnA> selectSearchHotelQnAList(Connection conn, PageInfo pi, String searchCondition, String search,
			int hotelId) {
		
		List<QnA> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(searchCondition.equals("title")) {
			sql = query.getProperty("selectSearchQnAtitleList");
		} else {
			sql = query.getProperty("selectSearchQnAContentList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, hotelId);
			pstmt.setString(2, search);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
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
		}
		
		return list;
	}

	public int getSearchHotelQnAListCount(Connection conn, String searchCondition, String search, int hotelId) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(searchCondition.equals("hotelName")) {
			sql = query.getProperty("getSearchHotelQnATitleListCount");
		} else {
			sql = query.getProperty("getSearchHotelQnAContentListCount");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			pstmt.setInt(2, hotelId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}





}

