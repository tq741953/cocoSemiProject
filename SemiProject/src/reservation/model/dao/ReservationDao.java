package reservation.model.dao;

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

import reservation.model.vo.Reservation;

public class ReservationDao {
	
private Properties query = new Properties();
	
	public ReservationDao() {
		String fileName = ReservationDao.class.getResource("/sql/reservation/reservation-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	// 예약 결제 게시판 리스트 확인
	public List<Reservation> selectList(Connection conn, int hotelId) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      List<Reservation> list = new ArrayList<>();   
	      String sql = query.getProperty("selectList");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, hotelId);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            list.add(new Reservation(rset.getInt("Reservation_no"),
	                               rset.getString("Account_id"),
	                               rset.getString("Room_no"),
	                               rset.getDate("Check_in"),
	                               rset.getDate("Check_out"),
	                               rset.getString("Request"),
	                               rset.getString("Pay_type"),
	                               rset.getString("Pay_price"),
	                               rset.getString("Pay_code"),
	                               rset.getString("Pay_status"),
	                               rset.getString("status"),
	                               rset.getInt("Adult_count"),
	                               rset.getInt("Child_count"),
	                               rset.getString("Guest_name"),
	                               rset.getString("Guest_phone")));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return list;
	   }
	// 예약 결제 게시판에서 회원 ID와 객실 번호로 search
	public List<Reservation> searchReservation(Connection conn, String searchCondition, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Reservation> list = new ArrayList<>();
		String sql = "";
		
		if(searchCondition.equals("number")) {
			sql = query.getProperty("selectSearchReservationList");
		} else {
			sql = query.getProperty("selectSearchRoomList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reservation(rset.getInt("Reservation_no"),
										 rset.getString("Account_id"),
										 rset.getString("Room_no"),
										 rset.getDate("Check_in"),
										 rset.getDate("Check_out"),
										 rset.getString("Request"),
										 rset.getString("Pay_type"),
										 rset.getString("Pay_price"),
										 rset.getString("Pay_code"),
										 rset.getString("Pay_status"),
										 rset.getString("status"),
										 rset.getInt("Adult_count"),
										 rset.getInt("Child_count"),
										 rset.getString("Guest_name"),
										 rset.getString("Guest_phone")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	// 예약 및 결제 게시판 내용 상세 페이지
	public Reservation selectDetailList(Connection conn, int reservationNo) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      Reservation r = null;
	      String sql = query.getProperty("selectDetailList");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, reservationNo);
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            r = new Reservation(rset.getInt("Reservation_no"),
	                               rset.getString("Account_id"),
	                               rset.getString("Room_no"),
	                               rset.getDate("Check_in"),
	                               rset.getDate("Check_out"),
	                               rset.getString("Request"),
	                               rset.getString("Pay_type"),
	                               rset.getString("Pay_price"),
	                               rset.getString("Pay_code"),
	                               rset.getString("Pay_status"),
	                               rset.getString("status"),
	                               rset.getInt("Adult_count"),
	                               rset.getInt("Child_count"),
	                               rset.getString("Guest_name"),
	                               rset.getString("Guest_phone"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return r;
	   }
	public int deleteReservation(Connection conn, int rNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("deleteReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
