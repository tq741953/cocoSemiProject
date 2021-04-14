package reservation.model.service;

import java.sql.Connection;
import java.util.List;
import static common.JDBCTemplate.*;

import reservation.model.dao.ReservationDao;
import reservation.model.vo.Reservation;

public class ReservationService {
	// 예약 결제 게시판 리스트 확인
	public List<Reservation> selectList(int hotelId) {
	      Connection conn = getConnection();
	      
	      List<Reservation> list = new ReservationDao().selectList(conn, hotelId);
	      
	      close(conn);
	      
	      return list;
	   }
	// 예약 결제 게시판에서 회원 ID와 객실 번호로 search
	public List<Reservation> searchReservation(String searchCondition, String search) {
		Connection conn = getConnection();
		
		List<Reservation> list = new ReservationDao().searchReservation(conn, searchCondition, search);
		
		close(conn);
		
		return list;
	}
	// 예약 및 결제 게시판 내용 상세 보기
	public Reservation selectDetailList(int reservationNo) {
	      Connection conn = getConnection();
	      
	      Reservation list = new ReservationDao().selectDetailList(conn, reservationNo);
	      
	      close(conn);
	      
	      return list;
	   }
	public int deleteReservation(int rNo) {
		Connection conn = getConnection();
		int result = new ReservationDao().deleteReservation(conn, rNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

}
