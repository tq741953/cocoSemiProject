package facilities.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.JDBCTemplate.*;
import facilities.model.dao.FacilitiesDao;
import facilities.model.vo.Facilities;
import facilities.model.vo.Room_file;

public class FacilitiesService {


	// 객실 등록 게시판 리스트 확인 페이지
	public Map<String, Object> boardListRoom(int hotelId) {
		Connection conn = getConnection();
		FacilitiesDao fDao = new FacilitiesDao();
		List<Facilities> fList = fDao.boardListRoom(conn, hotelId);
		List<Room_file> rList = fDao.boardListRoom_file(conn, hotelId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("fList", fList);
		map.put("rList", rList);
		
		close(conn);
		
		return map;
	}
	// 객실 정보 등록 상세 페이지로 이동
	public int roomInformationInsert(Facilities f, List<Room_file> room_file) {
		Connection conn = getConnection();
		FacilitiesDao fDao = new FacilitiesDao();

		int result1 = fDao.roomInformationInsert(conn, f);
		int result2 = fDao.room_fileInformationInsert(conn, room_file);
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
	// 객실 등록 게시글 상세 페이지(room_file)
	public List<Room_file> selectRoom_fileBoard(int room_no) {
		Connection conn = getConnection();
		
		List<Room_file> room_file = new FacilitiesDao().selectRoom_fileBoard(conn, room_no);
		close(conn);
		
		return room_file;
	}
	// 객실 등록 게시글 상세 페이지(room)
	public List<Facilities> selectRoomBoard(int room_no) {
		Connection conn = getConnection();
		
		List<Facilities> facilities = new FacilitiesDao().selectRoomBoard(conn, room_no);
		close(conn);
		
		return facilities;
	}

	
}
