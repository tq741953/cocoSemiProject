package Hotelinsert.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Hotelinsert.model.dao.HotelDao;
import Hotelinsert.model.vo.Hotel;
import Hotelinsert.model.vo.Hotel_file;

public class HotelService {
	// 호텔 게시판 뷰 Hotel 게시판
	public Map<String, Object> boardList(String account_id) {
		Connection conn = getConnection();
		HotelDao hDao = new HotelDao();
		List<Hotel> hList = hDao.HotelboardList(conn, account_id);
		List<Hotel_file> fList = hDao.HotelfileboardList(conn);
		
		Map<String, Object> map = new HashMap<>();
		map.put("hList", hList);
		map.put("fList", fList);
		
		close(conn);
		
		return map;
	}
	// 호텔 게시판 추가 하는 역활
	public int hotelBoardInsert(Hotel h,Hotel_file f1,Hotel_file f2) {
		Connection conn = getConnection();
		HotelDao hDao = new HotelDao();
		
		int result1 = hDao.hotelBoardInsert(conn, h);
		int result2 = hDao.hotel_fileBoardInsert(conn, f1);
		int result3 = hDao.hotel_blpInsert(conn, f2);
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			result = 1;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	// 호텔 등록 되어 있는 게시판 내용 확인
	public List<Hotel> hotlecheckboard(int hotel_id) {
		Connection conn = getConnection();
		
		List<Hotel> hotel = new HotelDao().hotlecheckboard(conn, hotel_id);
		
		close(conn);
		
		return hotel;
	}
	// 호텔 등록 되어 있는 게시판 사진 내용 확인
	public List<Hotel_file> hotel_filecheckboard(int hotel_id) {
		Connection conn = getConnection();
		
		List<Hotel_file> hotel_file = new HotelDao().hotel_filecheckboard(conn, hotel_id);
		
		close(conn);
		
		return hotel_file;
	}


}
 