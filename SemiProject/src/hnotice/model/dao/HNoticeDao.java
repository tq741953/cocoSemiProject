package hnotice.model.dao;

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

import hnotice.model.vo.HNotice;


public class HNoticeDao {
	private Properties query = new Properties();
	
	public HNoticeDao() {
		// 호텔 게시판 쿼리 연결 부분
		String fileName = HNoticeDao.class.getResource("/sql/hnotice/hnotice-query.xml").getPath();
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 호텔 게시판 리스트 조회 페이지
	public List<HNotice> selectList(Connection conn, int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<HNotice> list = new ArrayList<>();
		String sql = query.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelId);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				list.add(new HNotice(rset.getInt("hnNo"),
									 rset.getInt("hotel_id"),
									 rset.getString("account_id"),
									 rset.getString("hnTitle"),
									 rset.getString("hnContent"),
									 rset.getDate("create_date"),
									 rset.getDate("modify_date"),
									 rset.getString("status"),
									 rset.getString("hotel_name")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	// 호텔 게시판에서 search한다(제목, 내용)
	public List<HNotice> searchBoard(Connection conn, String searchCondition, String search, int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<HNotice> list = new ArrayList<>();
		String sql = "";
		
		if(searchCondition.equals("title")) {
			sql = query.getProperty("selectSearchTitleList");
		} else {
			sql = query.getProperty("selectSearchContentList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			pstmt.setInt(2, hotelId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new HNotice(rset.getInt("hnNo"),
									 rset.getInt("hotel_id"),
									 rset.getString("account_id"),
									 rset.getString("hnTitle"),
									 rset.getString("hnContent"),
									 rset.getDate("create_date"),
									 rset.getDate("modify_date"),
									 rset.getString("status"),
									 rset.getString("hotel_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	// 호텔 게시글 삭제 기능
	public int deleteNotice(Connection conn, HNotice n) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = query.getProperty("deleteNotice");
		System.out.println(n.getHnNo());
		System.out.println("dao");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, n.getHnNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	// 호텔 게시판 게시들 수정하기
	public int updateNotice(Connection conn, HNotice n) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = query.getProperty("updateNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getHnTitle());
			pstmt.setString(2, n.getHnContent());
			pstmt.setInt(3, n.getHnNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public List<HNotice> updateNotice(Connection conn, int hnno) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      List<HNotice> nlist = new ArrayList<>();
	      String sql = query.getProperty("updateNoticeForm");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, hnno);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            nlist.add(new HNotice(rset.getInt("HnNo"),
	                         rset.getInt("Hotel_id"),
	                         rset.getString("Account_id"),
	                         rset.getString("HnTitle"),
	                         rset.getString("HnContent"),
	                         rset.getDate("Create_date"),
	                         rset.getDate("Modify_date"),
	                         rset.getString("Status"),
	                         rset.getString("hotel_name")));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }
	      return nlist;
	   }
	// 호텔 게시판 게시글 작성하기 기능
	public int insertNotice(Connection conn, HNotice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertNotice");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n.getHotel_id());
			pstmt.setString(2, n.getAccount_id());
			pstmt.setString(3, n.getHnTitle());
			pstmt.setString(4, n.getHnContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 호텔 게시판 게시글 상세 페이지
	public HNotice selectdetailList(Connection conn, int hnno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HNotice n = null;
		String sql = query.getProperty("selectdetailList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hnno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new HNotice(rset.getInt("HnNo"),
						 		rset.getInt("Hotel_id"),
						 		rset.getString("Account_id"),
						 		rset.getString("HnTitle"),
						 		rset.getString("HnContent"),
						 		rset.getDate("Create_date"),
						 		rset.getDate("Modify_date"),
						 		rset.getString("Status"),
						 		rset.getString("hotel_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}


}
