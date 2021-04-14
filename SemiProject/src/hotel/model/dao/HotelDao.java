package hotel.model.dao;

import static common.JDBCTemplate.close; 

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import admin.model.vo.HotelLicensePhoto;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import hotel.model.vo.Reservation;
import hotel.model.vo.Review;
import hotel.model.vo.Room;
import hotel.model.vo.RoomFile;
import notice.model.vo.Notice;

public class HotelDao {
	private Properties query = new Properties();
	
	public HotelDao() {
		String fileName = HotelDao.class.getResource("/sql/hotel/hotel-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 검색페이지 갯수 제한
	public int getSearchListCount(Connection conn, String searchValue, String searchValue2) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getSearchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue2);
			
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

	// 검색 리스트 조회
	public List<Hotel> selectSearchList(Connection conn, PageInfo pi, String searchValue, String searchValue2, int searchAdult, int searchChild) {
		List<Hotel> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("selectSearchList"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue2);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			pstmt.setInt(5, searchAdult);
			pstmt.setInt(6, searchChild);
			pstmt.setInt(7, searchAdult);
			pstmt.setInt(8, searchChild);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Hotel(rset.getInt("hotel_id"),
								   rset.getString("hotel_name"),
								   rset.getString("hotel_address"),
								   rset.getString("hotel_phone"),
								   rset.getDouble("hotel_x"),
								   rset.getDouble("hotel_y"),
								   rset.getString("file_url"),
								   rset.getString("file_rename"),
								   rset.getString("status"),
								   rset.getInt("room_no"),
								   rset.getInt("room_count"),
								   rset.getInt("room_price"),
								   rset.getInt("adult_count"),
								   rset.getInt("child_count"),
								   rset.getString("hotel_service"),
								   rset.getString("bed_type"),
								   rset.getString("room_type")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	// 호텔 상세 보기
	public List<Hotel> selectHotel(Connection conn, int rNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> HList = new ArrayList<>();
		String sql = query.getProperty("selectHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				HList.add(new Hotel(rset.getInt("hotel_id"),
						   rset.getString("hotel_name"),
						   rset.getString("hotel_address"),
						   rset.getString("hotel_phone"),
						   rset.getDouble("hotel_x"),
						   rset.getDouble("hotel_y"),
						   rset.getString("file_url"),
						   rset.getString("file_rename"),
						   rset.getString("status"),
						   rset.getInt("room_no"),
						   rset.getInt("room_count"),
						   rset.getInt("room_price"),
						   rset.getInt("adult_count"),
						   rset.getInt("child_count"),
						   rset.getString("hotel_service"),
						   rset.getString("bed_type"),
						   rset.getString("room_type"))); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return HList;
	}

	public List<Hotel> hotelPayment(Connection conn, int rNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> list = new ArrayList<>();
		String sql = query.getProperty("hotelPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				list.add(new Hotel(rset.getInt("hotel_id"),
						   rset.getString("hotel_name"),
						   rset.getString("hotel_address"),
						   rset.getString("hotel_phone"),
						   rset.getDouble("hotel_x"),
						   rset.getDouble("hotel_y"),
						   rset.getString("file_url"),
						   rset.getString("file_rename"),
						   rset.getString("status"),
						   rset.getInt("room_no"),
						   rset.getInt("room_count"),
						   rset.getInt("room_price"),
						   rset.getInt("adult_count"),
						   rset.getInt("child_count"),
						   rset.getString("hotel_service"),
						   rset.getString("bed_type"),
						   rset.getString("room_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public int checkRoomCount(Connection conn, String checkIn, String checkOut, int room_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = query.getProperty("checkRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkIn);
			pstmt.setString(2, checkOut);
			pstmt.setString(3, checkIn);
			pstmt.setString(4, checkOut);
			pstmt.setString(5, checkIn);
			pstmt.setInt(6, room_no);
			
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

	public int insertReservation(Connection conn, Reservation r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("insertReservation");
		String loginUser = r.getAccount_id().getAccountId();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser);
			pstmt.setInt(2, r.getRoom_no());
			pstmt.setString(3, r.getCheck_in());
			pstmt.setString(4, r.getCheck_out());
			pstmt.setString(5, r.getAskIn());
			pstmt.setString(6, r.getPay_type());
			pstmt.setInt(7, r.getPay_price());
			pstmt.setString(8, r.getPay_code());
			pstmt.setInt(9, r.getAdult_count());
			pstmt.setInt(10, r.getChild_count());
			pstmt.setString(11, r.getGuest_name());
			pstmt.setString(12, r.getGuest_phone());
			pstmt.setInt(13, r.getRoom_count());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 오름 차순
	public List<Hotel> sortPayment(Connection conn, PageInfo pi, int searchAdult, int searchChild, String searchValue, String orderby) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> list = new ArrayList<>();
		// String sql = query.getProperty("sortPayment");
		String sql = "SELECT \r\n" + 
				"RNUM\r\n" + 
				", HOTEL_ID\r\n" + 
				", HOTEL_NAME\r\n" + 
				", HOTEL_ADDRESS\r\n" + 
				", HOTEL_PHONE\r\n" + 
				", HOTEL_X\r\n" + 
				", HOTEL_Y\r\n" + 
				", FILE_RENAME\r\n" + 
				", FILE_URL\r\n" + 
				", STATUS\r\n" + 
				", ROOM_NO\r\n" + 
				", ROOM_COUNT\r\n" + 
				", ROOM_PRICE\r\n" + 
				", ADULT_COUNT\r\n" + 
				", CHILD_COUNT\r\n" + 
				", HOTEL_SERVICE\r\n" + 
				"	              , BED_TYPE\r\n" + 
				"	              , ROOM_TYPE\r\n" + 
				"			FROM (SELECT \r\n" + 
				"							ROWNUM RNUM\r\n" + 
				"						  , A.*\r\n" + 
				"	   				   FROM \r\n" + 
				"							(SELECT \r\n" + 
				"									HOTEL_ID\r\n" + 
				"	                               , HOTEL_NAME\r\n" + 
				"						           , HOTEL_ADDRESS\r\n" + 
				"						           , HOTEL_PHONE\r\n" + 
				"						           , HOTEL_X\r\n" + 
				"						           , HOTEL_Y\r\n" + 
				"						           , FILE_RENAME\r\n" + 
				"						           , FILE_URL\r\n" + 
				"						           , STATUS\r\n" + 
				"						           , ROOM_NO\r\n" + 
				"						           , ROOM_COUNT\r\n" + 
				"						           , ROOM_PRICE\r\n" + 
				"						           , ADULT_COUNT\r\n" + 
				"						           , CHILD_COUNT\r\n" + 
				"						           , HOTEL_SERVICE\r\n" + 
				"						           , BED_TYPE\r\n" + 
				"						           , ROOM_TYPE\r\n" + 
				"	                		   FROM \r\n" + 
				"	                		   		HOTEL H\r\n" + 
				"					                JOIN HOTEL_FILE USING(HOTEL_ID)\r\n" + 
				"					                JOIN ROOM USING(HOTEL_ID)\r\n" + 
				"	                		  WHERE \r\n" + 
				"	                		  		HOTEL_NAME LIKE '%' || ? ||'%' OR HOTEL_ADDRESS LIKE '%' || ? ||'%'\r\n" + 
				"ORDER BY "+ orderby +
				"				           ) \r\n" + 
				"				           	A)\r\n" + 
				"				WHERE \r\n" + 
				"					  RNUM BETWEEN ? AND ?\r\n" + 
				"				  AND STATUS = 'Y'\r\n" + 
				"				  AND ADULT_COUNT >= ?\r\n" + 
				"	              AND CHILD_COUNT >= ?\r\n" + 
				"	              AND (HOTEL_ID,ROOM_PRICE) IN (SELECT HOTEL_ID, MIN(ROOM_PRICE)\r\n" + 
				"			                                    FROM HOTEL \r\n" + 
				"			                                    JOIN ROOM USING (HOTEL_ID)\r\n" + 
				"			                                    WHERE ADULT_COUNT >= ?\r\n" + 
				"			                                    AND CHILD_COUNT >= ?                                    \r\n" + 
				"			                                    GROUP BY HOTEL_ID)\r\n";
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			pstmt.setInt(5, searchAdult);
			pstmt.setInt(6, searchChild);
			pstmt.setInt(7, searchAdult);
			pstmt.setInt(8, searchChild);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Hotel(rset.getInt("hotel_id"),
								   rset.getString("hotel_name"),
								   rset.getString("hotel_address"),
								   rset.getString("hotel_phone"),
								   rset.getDouble("hotel_x"),
								   rset.getDouble("hotel_y"),
								   rset.getString("file_url"),
								   rset.getString("file_rename"),
								   rset.getString("status"),
								   rset.getInt("room_no"),
								   rset.getInt("room_count"),
								   rset.getInt("room_price"),
								   rset.getInt("adult_count"),
								   rset.getInt("child_count"),
								   rset.getString("hotel_service"),
								   rset.getString("bed_type"),
								   rset.getString("room_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 리뷰 가져오기
	public List<Review> selectReview(Connection conn, int hId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> LList = new ArrayList<>();
		String sql = query.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				LList.add(new Review(rset.getInt("review_no"),
									 rset.getString("account_id"),
									 rset.getInt("reservation_no"),
									 rset.getString("review_title"),
									 rset.getString("review_content"),
									 rset.getInt("review_grade"),
									 rset.getDate("create_date"),
									 rset.getDate("modify_date"),
									 rset.getString("status"),
									 rset.getInt("rcount"),
									 rset.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return LList;
	}

	public int getAvgGrade(Connection conn, int hId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int avg = 0;
		String sql = query.getProperty("getAvgGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				avg = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avg;
	}

	public List<RoomFile> selectRoomFile(Connection conn, int hId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<RoomFile> rList = new ArrayList<>();
		String sql = query.getProperty("selectRoomFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rList.add(new RoomFile(rset.getInt("file_id"),
									   rset.getInt("room_no"),
									   rset.getString("file_name"),
									   rset.getString("file_rename"),
									   rset.getString("file_url")));
			}
			// System.out.println(rList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

	// 내림차순
	public List<Hotel> sortPaymentLow(Connection conn, PageInfo pi, int searchAdult, int searchChild,
			String searchValue) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> list = new ArrayList<>();
		String sql = query.getProperty("sortPaymentLow");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			pstmt.setInt(5, searchAdult);
			pstmt.setInt(6, searchChild);
			pstmt.setInt(7, searchAdult);
			pstmt.setInt(8, searchChild);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Hotel(rset.getInt("hotel_id"),
								   rset.getString("hotel_name"),
								   rset.getString("hotel_address"),
								   rset.getString("hotel_phone"),
								   rset.getDouble("hotel_x"),
								   rset.getDouble("hotel_y"),
								   rset.getString("file_url"),
								   rset.getString("file_rename"),
								   rset.getString("status"),
								   rset.getInt("room_no"),
								   rset.getInt("room_count"),
								   rset.getInt("room_price"),
								   rset.getInt("adult_count"),
								   rset.getInt("child_count"),
								   rset.getString("hotel_service"),
								   rset.getString("bed_type"),
								   rset.getString("room_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Review> reviewDetail(Connection conn, int hId, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> list = new ArrayList<>();
		String sql = query.getProperty("reviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, hId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
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
									rset.getInt("rcount"),
									rset.getString("name"),
									rset.getString("hotel_name")));	
			}
			// System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	// 리뷰 페이징처리용
	public int getReviewListCount(Connection conn, int hId) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hId);
			
			
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

	// 100000 이하 조건 검색 수
	public int getPaymentRangeListCount(Connection conn, String searchValue, String searchValue2, int payment1,
			int payment2) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getPaymentRangeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue2);
			pstmt.setInt(3, payment1);
			pstmt.setInt(4, payment2);
			
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

	// 100000 이상 조건 검색 수
	public int getOverPaymentRangeListCount(Connection conn, String searchValue, String searchValue2, int payment1) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("getOverPaymentRangeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue2);
			pstmt.setInt(3, payment1);
			
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
	
	// 가격범위
	public List<Hotel> sortPriceRange(Connection conn, PageInfo pi, int searchAdult, int searchChild,
			String searchValue, int payment1, int payment2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> list = new ArrayList<>();
		String sql = query.getProperty("sortPriceRange");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			 pstmt.setString(1, searchValue);
	         pstmt.setString(2, searchValue);
	         pstmt.setInt(3, payment1);
	         pstmt.setInt(4, payment2);
	         pstmt.setInt(5, startRow);
	         pstmt.setInt(6, endRow);
	         pstmt.setInt(7, searchAdult);
	         pstmt.setInt(8, searchChild);
	         pstmt.setInt(9, payment1);
	         pstmt.setInt(10, payment2);
	         pstmt.setInt(11, searchAdult);
	         pstmt.setInt(12, searchChild);
	         
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Hotel(rset.getInt("hotel_id"),
								   rset.getString("hotel_name"),
								   rset.getString("hotel_address"),
								   rset.getString("hotel_phone"),
								   rset.getDouble("hotel_x"),
								   rset.getDouble("hotel_y"),
								   rset.getString("file_url"),
								   rset.getString("file_rename"),
								   rset.getString("status"),
								   rset.getInt("room_no"),
								   rset.getInt("room_count"),
								   rset.getInt("room_price"),
								   rset.getInt("adult_count"),
								   rset.getInt("child_count"),
								   rset.getString("hotel_service"),
								   rset.getString("bed_type"),
								   rset.getString("room_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	// 필터링 리스트 갯수
		public int getfilterListCount(Connection conn, String searchValue, String searchValue2, String[] filter) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = "";
			if(filter.length == 1) {
				sql = query.getProperty("getfilterListCount1");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 2) {
				sql = query.getProperty("getfilterListCount2");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 3) {
				sql = query.getProperty("getfilterListCount3");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					pstmt.setString(5, filter[2]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 4) {
				sql = query.getProperty("getfilterListCount4");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					pstmt.setString(5, filter[2]);
					pstmt.setString(6, filter[3]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 5) {
				sql = query.getProperty("getfilterListCount5");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					pstmt.setString(5, filter[2]);
					pstmt.setString(6, filter[3]);
					pstmt.setString(7, filter[4]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 6) {
				sql = query.getProperty("getfilterListCount6");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					pstmt.setString(5, filter[2]);
					pstmt.setString(6, filter[3]);
					pstmt.setString(7, filter[4]);
					pstmt.setString(8, filter[5]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			} else if(filter.length == 7) {
				sql = query.getProperty("getfilterListCount7");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue2);
					pstmt.setString(3, filter[0]);
					pstmt.setString(4, filter[1]);
					pstmt.setString(5, filter[2]);
					pstmt.setString(6, filter[3]);
					pstmt.setString(7, filter[4]);
					pstmt.setString(8, filter[5]);
					pstmt.setString(9, filter[6]);
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
			}
			
			return listCount;
		}

		public List<Hotel> FilterList(Connection conn, PageInfo pi, int searchAdult, int searchChild, String searchValue,
				String[] filter) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = "";
			List<Hotel> list = new ArrayList<>();
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			
			if(filter.length == 1) {
				sql = query.getProperty("FilterList1");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}else if(filter.length == 2) {
				sql = query.getProperty("FilterList2");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					pstmt.setString(8, filter[1]);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}else if (filter.length == 3) {
				sql = query.getProperty("FilterList3");
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, searchValue);
				pstmt.setString(2, searchValue);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				pstmt.setInt(5, searchAdult);
				pstmt.setInt(6, searchChild);
				pstmt.setString(7, filter[0]);
				pstmt.setString(8, filter[1]);
				pstmt.setString(9, filter[2]);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Hotel(rset.getInt("hotel_id"),
									   rset.getString("hotel_name"),
									   rset.getString("hotel_address"),
									   rset.getString("hotel_phone"),
									   rset.getDouble("hotel_x"),
									   rset.getDouble("hotel_y"),
									   rset.getString("file_url"),
									   rset.getString("file_rename"),
									   rset.getString("status"),
									   rset.getInt("room_no"),
									   rset.getInt("room_count"),
									   rset.getInt("room_price"),
									   rset.getInt("adult_count"),
									   rset.getInt("child_count"),
									   rset.getString("hotel_service"),
									   rset.getString("bed_type"),
									   rset.getString("room_type")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}
			}else if (filter.length == 4) {
				sql = query.getProperty("FilterList4");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					pstmt.setString(8, filter[1]);
					pstmt.setString(9, filter[2]);
					pstmt.setString(10, filter[3]);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}else if (filter.length == 5) {
				sql = query.getProperty("FilterList5");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					pstmt.setString(8, filter[1]);
					pstmt.setString(9, filter[2]);
					pstmt.setString(10, filter[3]);
					pstmt.setString(11, filter[4]);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}else if (filter.length == 6) {
				sql = query.getProperty("FilterList6");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					pstmt.setString(8, filter[1]);
					pstmt.setString(9, filter[2]);
					pstmt.setString(10, filter[3]);
					pstmt.setString(11, filter[4]);
					pstmt.setString(12, filter[5]);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}else if (filter.length == 7) {
				sql = query.getProperty("FilterList7");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, searchValue);
					pstmt.setString(2, searchValue);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					pstmt.setInt(5, searchAdult);
					pstmt.setInt(6, searchChild);
					pstmt.setString(7, filter[0]);
					pstmt.setString(8, filter[1]);
					pstmt.setString(9, filter[2]);
					pstmt.setString(10, filter[3]);
					pstmt.setString(11, filter[4]);
					pstmt.setString(12, filter[5]);
					pstmt.setString(13, filter[6]);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Hotel(rset.getInt("hotel_id"),
										   rset.getString("hotel_name"),
										   rset.getString("hotel_address"),
										   rset.getString("hotel_phone"),
										   rset.getDouble("hotel_x"),
										   rset.getDouble("hotel_y"),
										   rset.getString("file_url"),
										   rset.getString("file_rename"),
										   rset.getString("status"),
										   rset.getInt("room_no"),
										   rset.getInt("room_count"),
										   rset.getInt("room_price"),
										   rset.getInt("adult_count"),
										   rset.getInt("child_count"),
										   rset.getString("hotel_service"),
										   rset.getString("bed_type"),
										   rset.getString("room_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rset);
				}
			}
			
			return list;
		}

		public List<Hotel> selectList(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<Hotel> list = new ArrayList<>();
			String sql = query.getProperty("selectApprovalList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getPageLimit() + 1;
				int endRow = startRow + pi.getPageLimit() - 1;
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Hotel(rset.getInt("hotel_id"),
							rset.getString("account_id"),
							rset.getString("hotel_name"),
							rset.getString("hotel_address"),
							rset.getString("hotel_phone"),
							rset.getString("status"),
							rset.getString("business_license"),
							rset.getString("hotel_status"),
							rset.getString("file_rename"),
							rset.getString("file_url")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

		public int selectApprovalHotel(Connection conn, int hotelId) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = query.getProperty("approvalHotel");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hotelId);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

		public List<Hotel> getHotelListByAccountId(Connection conn, String accountId, PageInfo pi) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<Hotel> list = new ArrayList<>();
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			String sql = query.getProperty("getHotelListByAccountId");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, accountId);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				
				while(rset.next()) {
					list.add(new Hotel(rset.getInt("hotel_id"),
							rset.getString("account_id"),
							rset.getString("hotel_name"),
							rset.getString("hotel_address"),
							rset.getString("hotel_phone"),
							rset.getString("status"),
							rset.getString("business_license"),
							rset.getString("hotel_status")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

		public int getHotelListCountByAccountId(Connection conn, String accountId) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = query.getProperty("getHotelListCountByAccountId");
			
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

		public int getSearchMyHotelListCount(Connection conn, String searchCondition, String search, String accountId) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = "";
			
			if(searchCondition.equals("hotelName")) {
				sql = query.getProperty("getSearchHotelNameListCount");
			} else {
				sql = query.getProperty("getSearchAddresstListCount");
			}
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, search);
				pstmt.setString(2, accountId);
				
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

		public List<Hotel> selectSearchMyHotelList(Connection conn, PageInfo pi, String searchCondition,
				String search, String accountId) {
			
			List<Hotel> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = "";
			
			if(searchCondition.equals("hotelName")) {
				sql = query.getProperty("selectSearchHotelNameList");
			} else {
				sql = query.getProperty("selectSearchAddressList");
			}
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setString(1, search);
				pstmt.setString(2, accountId);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Hotel(rset.getInt("hotel_id"),
							rset.getString("account_id"),
							rset.getString("hotel_name"),
							rset.getString("hotel_address"),
							rset.getString("hotel_phone"),
							rset.getString("status"),
							rset.getString("business_license"),
							rset.getString("hotel_status")));
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public List<Hotel> getHotelListByHotelId(Connection conn, int hotelId) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<Hotel> list = new ArrayList<>();
			
			String sql = query.getProperty("getHotelListByHotelId");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, hotelId);
				
				rset = pstmt.executeQuery();
				if(rset.next()) {
					list.add(new Hotel(rset.getInt("hotel_id"),
							rset.getString("account_id"),
							rset.getString("hotel_name"),
							rset.getString("hotel_address"),
							rset.getString("hotel_phone"),
							rset.getString("status"),
							rset.getString("business_license"),
							rset.getString("hotel_status")));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public int getListCount(Connection conn) {
			Statement stmt = null;
			ResultSet rset = null;
			int listCount = 0;
			String sql = query.getProperty("getListCount");
			
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(sql);
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
			
			return listCount;
		}

		public List<HotelLicensePhoto> selectPhoto(Connection conn, int hotel_id) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			List<HotelLicensePhoto> HList = new ArrayList<>();
			String sql = query.getProperty("selectPhoto");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, hotel_id);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					HList.add(new HotelLicensePhoto(rset.getInt("fileId"),
													rset.getInt("hotelId"),
													rset.getString("fileName"),
													rset.getString("fileRename"),
													rset.getString("fileUrl")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rset);
			}
			return HList;
		}



}
