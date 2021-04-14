package hotel.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import admin.model.vo.HotelLicensePhoto;
import hotel.model.dao.HotelDao;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import hotel.model.vo.Reservation;
import hotel.model.vo.Review;
import hotel.model.vo.RoomFile;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;


public class HotelService {

	public int getSearchListCount(String searchValue, String searchValue2) {
		Connection conn = getConnection();
		
		int listCount = new HotelDao().getSearchListCount(conn, searchValue, searchValue2);
		
		close(conn);
		
		return listCount;
	}

	public List<Hotel> selectSearchList(PageInfo pi, String searchValue, String searchValue2, int searchAdult, int searchChild) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().selectSearchList(conn, pi, searchValue, searchValue2, searchAdult, searchChild);
		
		close(conn);
		
		return list;
	}

	public List<Hotel> selectHotel(int rNo) {
		Connection conn = getConnection();
		
		List<Hotel> HList = new HotelDao().selectHotel(conn, rNo);
		
		close(conn);
		
		return HList;
	}

	public List<Hotel> hotelPayment(int rNo) {
		Connection conn = getConnection();
		List<Hotel> list = new HotelDao().hotelPayment(conn, rNo);
		
		close(conn);
		return list;
	}

	public int checkRoomCount(String checkIn, String checkOut, int room_no) {
		Connection conn = getConnection();
		int result = new HotelDao().checkRoomCount(conn, checkIn, checkOut, room_no);
		
		close(conn);
		
		return result;
	}

	public int insertReservation(Reservation r) {
		Connection conn = getConnection();
		int result = new HotelDao().insertReservation(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 가격 순 정렬
	public List<Hotel> sortPayment(PageInfo pi, int searchAdult, int searchChild, String searchValue, String orderby) {
		Connection conn = getConnection();
		List<Hotel> list = new HotelDao().sortPayment(conn, pi, searchAdult, searchChild, searchValue, orderby);
		
		close(conn);
		
		return list;
	}

	// 리뷰 가져오기
	public List<Review> selectReview(int hId) {
		Connection conn = getConnection();
		List<Review> LList = new HotelDao().selectReview(conn, hId);
		
		close(conn);
		return LList;
	}

	// 리뷰 평균 평점 가져오기
	public int getAvgGrade(int hId) {
		Connection conn = getConnection();
		
		int avg = new HotelDao().getAvgGrade(conn, hId);
		
		close(conn);
		return avg;
	}

	public List<RoomFile> selectRoomFile(int hId) {
		Connection conn = getConnection();
		
		List<RoomFile> rList = new HotelDao().selectRoomFile(conn, hId);
		
		close(conn);
		return rList;
	}

	public List<Review> reviewDetail(PageInfo pi, int hId) {
		Connection conn = getConnection();
		List<Review> list = new HotelDao().reviewDetail(conn, hId, pi);
		
		close(conn);
		
		return list;
	}

	public int getReviewListCount(int hId) {
		Connection conn = getConnection();
		int listCount = new HotelDao().getReviewListCount(conn, hId);
		
		close(conn);
		return listCount;
	}

	// 가격 범위 정렬 게시물 총갯수
	public int getPaymentRangeListCount(String searchValue, String searchValue2, int payment1, int payment2) {
		Connection conn = getConnection();
		
		int listCount = new HotelDao().getPaymentRangeListCount(conn, searchValue, searchValue2, payment1, payment2);
		
		close(conn);
		
		return listCount;
	}

	public int getOverPaymentRangeListCount(String searchValue, String searchValue2, int payment1) {
		Connection conn = getConnection();
		
		int listCount = new HotelDao().getOverPaymentRangeListCount(conn, searchValue, searchValue2, payment1);
		
		close(conn);
		
		return listCount;
	}

	public List<Hotel> sortPriceRange(PageInfo pi, int searchAdult, int searchChild, String searchValue, int payment1,
			int payment2) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().sortPriceRange(conn, pi, searchAdult, searchChild, searchValue, payment1, payment2);
		
		close(conn);
		
		return list;
	}

	public int getfilterListCount(String searchValue, String searchValue2, String[] filter) {
		Connection conn = getConnection();
		
		int listCount = new HotelDao().getfilterListCount(conn, searchValue, searchValue2, filter);
		
		close(conn);
		
		return listCount;
	}

	public List<Hotel> FilterList(PageInfo pi, int searchAdult, int searchChild, String searchValue, String[] filter) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().FilterList(conn, pi, searchAdult, searchChild, searchValue, filter);
		
		close(conn);
		
		return list;
	}

	public List<Hotel> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int selectApprovalHotel(int hotelId) {
		Connection conn = getConnection();
		
		int result = new HotelDao().selectApprovalHotel(conn, hotelId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<Hotel> getHotelListByAccountId(String accountId , PageInfo pi) {
		Connection conn = getConnection();
		List<Hotel> list = new HotelDao().getHotelListByAccountId(conn, accountId, pi);
		
		close(conn);
		return list;
	}

	public int getHotelListCountByAccountId(String accountId) {
		Connection conn = getConnection();
		int listCount = new HotelDao().getHotelListCountByAccountId(conn, accountId);
		
		close(conn);
		return listCount;
	}

	public int getSearchMyHotelListCount(String searchCondition, String search, String accountId) {
		Connection conn = getConnection();
		int listCount = new HotelDao().getSearchMyHotelListCount(conn, searchCondition, search, accountId);
		close(conn);
		return listCount;
	}

	public List<Hotel> selectSearchMyHotelList(PageInfo pi, String searchCondition, String search, String accountId) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().selectSearchMyHotelList(conn, pi, searchCondition, search, accountId);
		
		close(conn);
		
		return list;
	}

	public List<Hotel> getHotelListByHotelId(int hotelId) {
		Connection conn = getConnection();
		
		List<Hotel> list = new HotelDao().getHotelListByHotelId(conn, hotelId);
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new HotelDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public List<HotelLicensePhoto> selectPhoto(int hotel_id) {
		Connection conn = getConnection();
		List<HotelLicensePhoto> HList = new HotelDao().selectPhoto(conn, hotel_id);
		
		close(conn);
		
		return HList;
	}



}
