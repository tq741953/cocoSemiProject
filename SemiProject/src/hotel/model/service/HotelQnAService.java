package hotel.model.service;

import java.sql.Connection;
import static common.JDBCTemplate.*;
import java.util.List;

import account.model.vo.Account;
import hotel.model.dao.HotelDao;
import hotel.model.dao.HotelQnADao;
import hotel.model.vo.Hotel;
import hotel.model.vo.PageInfo;
import hotel.model.vo.QnA;

public class HotelQnAService {

	public List<QnA> selectList(int hotelId) {
		Connection conn = getConnection();
		
		
		List<QnA> list = new HotelQnADao().selectList(conn, hotelId);
		
		close(conn);
		
		return list;
	}

	public QnA selectNotice(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new HotelQnADao().increaseCount(conn, qnaNo);
		
		QnA q = null;
		if(result > 0) {
			q = new HotelQnADao().selectQnA(conn, qnaNo);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return q;
	}

	public int insertQnA(QnA q) {
		Connection conn = getConnection();
		
		int result = new HotelQnADao().insertQnA(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int getHotelQnAListCountByHotelId(int hotelId) {
		Connection conn = getConnection();
		int listCount = new HotelQnADao().getHotelQnAListCountByHotelId(conn, hotelId);
		
		close(conn);
		return listCount;
	}

	public List<QnA> getHotelQnAListByHotelId(int hotelId, PageInfo pi) {
		Connection conn = getConnection();
		List<QnA> list = new HotelQnADao().getHotelQnAListByHotelId(conn, hotelId, pi);
		
		close(conn);
		return list;
	}

	public int insertQnAAnswer(QnA q) {
		Connection conn = getConnection();
		
		int result = new HotelQnADao().insertQnAAnswer(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public List<QnA> selectSearchHotelQnAList(PageInfo pi, String searchCondition, String search, int hotelId) {
		Connection conn = getConnection();
		
		List<QnA> list = new HotelQnADao().selectSearchHotelQnAList(conn, pi, searchCondition, search, hotelId);
		
		close(conn);
		
		return list;
	}

	public int getSearchHotelQnAListCount(String searchCondition, String search, int hotelId) {
		Connection conn = getConnection();
		
		int listCount = new HotelQnADao().getSearchHotelQnAListCount(conn, searchCondition, search, hotelId);
		
		close(conn);
		
		return listCount;
	}



}
