package facilities.model.dao;

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
import facilities.model.vo.Facilities;
import facilities.model.vo.Room_file;


public class FacilitiesDao {
	
	private Properties query = new Properties();
	// 쿼리와 연결하는 부분
	public FacilitiesDao() {
		String fileName = FacilitiesDao.class.getResource("/sql/facilities/facilities-query.xml").getPath();
		
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	// 객실 등록 게시판 리스트 room 정보 확인
	public List<Facilities> boardListRoom(Connection conn, int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Facilities> fList = new ArrayList<>();
		String sql = query.getProperty("boardListRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				fList.add(new Facilities(rset.getInt("Room_no"),
										 rset.getInt("Hotel_id"),
										 rset.getInt("Room_count"),
										 rset.getInt("Room_price"),
										 rset.getInt("Room_maximum"),
										 rset.getInt("Adult_count"),
										 rset.getInt("Child_count"),
										 rset.getString("Hotel_service"),
										 rset.getString("Bed_type"),
										 rset.getString("Room_type"),
										 rset.getString("Account_id"),
										 rset.getString("Hotel_name"),
										 rset.getString("Hotel_Address"),
										 rset.getString("Hotel_phone"),
										 rset.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return fList;
	}

	// 객실 등록 게시판 리스트 room_file 정보 확인
	public List<Room_file> boardListRoom_file(Connection conn, int hotelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Room_file> rList = new ArrayList<>();
		String sql = query.getProperty("boardListRoom_file");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rList.add(new Room_file(rset.getInt("File_id"),
										rset.getInt("Room_no"),
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
		return rList;
	}

	// 객실 정보 등록 페이지 room정보 전달
	public int roomInformationInsert(Connection conn, Facilities f) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("roomInformationInsert");
		System.out.println(f);
		try {
			pstmt =  conn.prepareStatement(sql);
			
			pstmt.setInt(1, f.getHotel_id());
			pstmt.setInt(2, f.getRoom_count());
			pstmt.setInt(3, f.getRoom_price());
			pstmt.setInt(4, f.getRoom_maximum());
			pstmt.setInt(5, f.getAdult_count());
			pstmt.setInt(6, f.getChild_count());
			pstmt.setString(7, f.getHotel_service());
			pstmt.setString(8, f.getBed_type());
			pstmt.setString(9, f.getRoom_type());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	// 객실 정보 등록 페이지 room_file정보 전달
	public int room_fileInformationInsert(Connection conn, List<Room_file> room_file) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("room_fileInformationInsert");
		
		try {
			
			for(int i = 0; i < room_file.size(); i++) {
				Room_file r = room_file.get(i);
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, r.getFile_name());
				pstmt.setString(2, r.getFile_rename());
				pstmt.setString(3, r.getFile_url());
				
				result = pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	// 객실 등록 상세 페이지 room_file데 대한 정보 확인
	public List<Room_file> selectRoom_fileBoard(Connection conn, int room_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Room_file> room_file = new ArrayList<>();
		String sql = query.getProperty("selectRoom_fileBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, room_no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				room_file.add(new Room_file(rset.getInt("File_id"),
										rset.getInt("Room_no"),
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
		
		return room_file;
	}

	// 객실 등록 상세 페이지 room데 대한 정보 확인
	public List<Facilities> selectRoomBoard(Connection conn, int room_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Facilities> facilities = new ArrayList<>();
		String sql = query.getProperty("selectRoomBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, room_no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				facilities.add(new Facilities(rset.getInt("Room_no"),
											  rset.getInt("Hotel_id"),
											  rset.getInt("Room_count"),
											  rset.getInt("Room_price"),
											  rset.getInt("Room_maximum"),
											  rset.getInt("Adult_count"),
											  rset.getInt("Child_count"),
											  rset.getString("Hotel_service"),
											  rset.getString("Bed_type"),
											  rset.getString("Room_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return facilities;
	}





}
