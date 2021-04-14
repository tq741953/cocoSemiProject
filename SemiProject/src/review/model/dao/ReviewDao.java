package review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static common.JDBCTemplate.close;
import hnotice.model.dao.HNoticeDao;
import review.model.vo.Review;

public class ReviewDao {
	private Properties query = new Properties();
	
	public ReviewDao() {
		// System.out.println("입력 값 : " + HNoticeDao.class.getResource("/sql/hnotice/hnotice-query.xml"));
		String fileName = HNoticeDao.class.getResource("/sql/review/review-query.xml").getPath();
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 리뷰 게시판 페이지 리스트 확인
	public List<Review> selectList(Connection conn,int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		String sql = query.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("review_no"),
									rset.getString("account_id"),
									rset.getInt("reservation_no"),
									rset.getString("review_title"),
									rset.getString("review_content"),
									rset.getInt("review_grade"),
									rset.getDate("create_date"),
									rset.getDate("modify_date"),
									rset.getString("status"),
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
	// 리뷰 페이지에서 search 기능
	public List<Review> searchBoard(Connection conn, String searchCondition, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		String sql = "";
		
		if(searchCondition.equals("booking number")) {
			sql = query.getProperty("selectSearchTitleList");
		} else {
			sql = query.getProperty("selectSearchContentList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("Review_no"),
									rset.getString("Account_id"),
									rset.getInt("Reservation_no"),
									rset.getString("Review_title"),
									rset.getString("Review_content"),
									rset.getInt("Review_grade"),
									rset.getDate("Create_date"),
									rset.getDate("Modify_date"),
									rset.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	// 리뷰 페이지 디데일 뷰
	public Review selectDetailList(Connection conn, int review_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		String sql = query.getProperty("selectDetailList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, review_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(rset.getInt("Review_no"),
						rset.getString("Account_id"),
						rset.getInt("Reservation_no"),
						rset.getString("Review_title"),
						rset.getString("Review_content"),
						rset.getInt("Review_grade"),
						rset.getDate("Create_date"),
						rset.getDate("Modify_date"),
						rset.getString("status"),
						rset.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}
	// 작성전에 reservationNO 조회해오기
	
	public Review reviewInsertForm(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		String sql = query.getProperty("reviewInsertForm");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Review(rset.getInt("reservation_no"),
											rset.getString("hotel_name"),
											rset.getInt("room_no"),
											rset.getString("guest_name"),
											rset.getDate("check_in"),
											rset.getDate("check_out"),
											rset.getInt("adult_count"),
											rset.getInt("child_count"),
											rset.getString("status"),
											rset.getString("account_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}
	
	


	// 리뷰 작성 넣기
	public int reviewInsert(Connection conn, Review r) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("reviewInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getAccount_id());
			pstmt.setInt(2, r.getReservation_no());
			pstmt.setString(3, r.getReview_title());
			pstmt.setString(4, r.getReview_content());
			pstmt.setInt(5, r.getReview_grade());
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		
		
		
		return result;
	}
	// 리스트
	public List<Review> selectList(Connection conn, String accounId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		String sql = query.getProperty("selectList1");
		String Id = accounId;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Id);
			
			rset = pstmt.executeQuery();
			
			
			
		
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("Review_no"),
									rset.getString("Account_id"),
									rset.getInt("Reservation_no"),
									rset.getString("Hotel_name"),
									rset.getString("Review_title"),
									rset.getString("Review_content"),
									rset.getInt("Review_grade"),
									rset.getDate("Create_date"),
									rset.getDate("Modify_date"),
									rset.getString("status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	
	}

	// 예약한거 외부조인해서 가져오기
	public List<Review> rCheckList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		
		String sql = query.getProperty("rCheckList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("reservation_no"),
											rset.getString("hotel_name"),
											rset.getInt("room_no"),
											rset.getString("guest_name"),
											rset.getDate("check_in"),
											rset.getDate("check_out"),
											rset.getInt("adult_count"),
											rset.getInt("child_count"),
											rset.getString("status"),
											rset.getString("account_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		

		return list;
		
	
	}

	// 리뷰 상세보기
	public Review reviewDetail(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review list = null;
		
		String sql = query.getProperty("reviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list = new Review(rset.getInt("Review_no"),
									rset.getString("Account_id"),
									rset.getInt("Reservation_no"),
									rset.getString("Hotel_name"),
									rset.getString("Review_title"),
									rset.getString("Review_content"),
									rset.getInt("Review_grade"),
									rset.getDate("Create_date"),
									rset.getDate("Modify_date"),
									rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// 리뷰 수정하기
	public int reviewUpdate(Connection conn, Review r) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = query.getProperty("reviewUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReview_title());
			pstmt.setString(2, r.getReview_content());
			pstmt.setInt(3, r.getReview_grade());
			pstmt.setInt(4, r.getReview_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	// 리뷰삭제
	public int reviewDelete(Connection conn, int no) {
		int result = 0;

		PreparedStatement pstmt = null;
		
		String sql = query.getProperty("reviewDelete");
		
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


	// 리뷰작성 버튼 활성화 비활성화
	public int reviewChecked(Connection conn, int reservation_no) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = query.getProperty("reviewChecked");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reservation_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return result;
	}

}
