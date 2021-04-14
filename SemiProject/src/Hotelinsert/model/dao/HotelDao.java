package Hotelinsert.model.dao;

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

import Hotelinsert.model.vo.Hotel;
import Hotelinsert.model.vo.Hotel_file;
import facilities.model.dao.FacilitiesDao;

public class HotelDao {
	
	private Properties query = new Properties();
	// 쿼리와 연결하는 부분
	public HotelDao() {
		String fileName = FacilitiesDao.class.getResource("/sql/hotelinsert/hotelinsert-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	// 호텔 게시판 뷰 Hotel 게시판
	public List<Hotel> HotelboardList(Connection conn, String account_id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> hList = new ArrayList<>();
		String sql = query.getProperty("HotelboardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, account_id);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				hList.add(new Hotel(rset.getInt("Hotel_id"),
									rset.getString("Account_id"),
									rset.getString("Hotel_name"),
									rset.getString("Hotel_address"),
									rset.getString("Hotel_phone"),
									rset.getString("status"),
									rset.getString("Business_license"),
									rset.getString("Hotel_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hList;
	}
	// 호텔 게시판 뷰 Hotel_file
	public List<Hotel_file> HotelfileboardList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel_file> fList = new ArrayList<>();
		String sql = query.getProperty("HotelfileboardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				fList.add(new Hotel_file(rset.getInt("File_id"),
										 rset.getInt("Hotel_id"),
										 rset.getString("File_name"),
										 rset.getString("File_rename"),
										 rset.getString("File_url")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return fList;
	}
	// 호텔 게시판 hotel 추가
	public int hotelBoardInsert(Connection conn, Hotel h) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("hotelBoardInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, h.getAccount_id());
			pstmt.setString(2, h.getHotel_name());
			pstmt.setString(3, h.getHotel_address());
			pstmt.setString(4, h.getHotel_phone());
			pstmt.setString(5, h.getBusiness_license());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 호텔 게시판 hotel_file 추가
	public int hotel_fileBoardInsert(Connection conn, Hotel_file f1) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("hotel_fileBoardInsert");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f1.getFile_name());
			pstmt.setString(2, f1.getFile_rename());
			pstmt.setString(3, f1.getFile_url());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 호텔 등록 되어 있는 게시판 내용 확인
	public List<Hotel> hotlecheckboard(Connection conn, int hotel_id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> hotel = new ArrayList<>();
		String sql = query.getProperty("hotlecheckboard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotel_id);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				hotel.add(new Hotel(rset.getInt("Hotel_id"),
									rset.getString("Account_id"),
									rset.getString("Hotel_name"),
									rset.getString("Hotel_address"),
									rset.getString("Hotel_phone"),
									rset.getString("status"),
									rset.getString("Business_license"),
									rset.getString("Hotel_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hotel;
	}
	// 호텔 등록 되어 있는 게시판 사진 내용 확인
	public List<Hotel_file> hotel_filecheckboard(Connection conn, int hotel_id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel_file> hotel_file = new ArrayList<>();
		String sql = query.getProperty("hotel_filecheckboard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotel_id);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				hotel_file.add(new Hotel_file(rset.getInt("File_id"),
											  rset.getInt("Hotel_id"),
											  rset.getString("File_name"),
											  rset.getString("File_rename"),
											  rset.getString("File_url")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return hotel_file;
	}
	public int hotel_blpInsert(Connection conn, Hotel_file f2) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("hotel_blpInsert");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f2.getFile_name());
			pstmt.setString(2, f2.getFile_rename());
			pstmt.setString(3, f2.getFile_url());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


}
