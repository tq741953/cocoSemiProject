package hnotice.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import hnotice.model.dao.HNoticeDao;
import hnotice.model.vo.HNotice;


public class HNoticeService {
	// 호텔 게시판 리스트 페이지
	public List<HNotice> selectList(int hotelId) {
		Connection conn = getConnection();
		
		List<HNotice> list = new HNoticeDao().selectList(conn, hotelId);
		
		close(conn);
		
		return list;
	}
	// 호텔 게시판에서 search 기능
	public List<HNotice> searchBoard(String searchCondition, String search, int hotelId) {
		Connection conn = getConnection();
		
		List<HNotice> list = new HNoticeDao().searchBoard(conn, searchCondition, search, hotelId);
		
		close(conn);
		
		return list;
	}

	// 호텔 게시글 삭제 기능
	public int deleteNotice(HNotice n) {
		Connection conn = getConnection();

		int result = new HNoticeDao().deleteNotice(conn, n);
		System.out.println("qwe" + result);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	// 호텔 게시판 게시글 상세 페이지
	public HNotice selectdetailList(int hnno) {
		Connection conn = getConnection();
		
		HNotice list = new HNoticeDao().selectdetailList(conn, hnno);
		
		close(conn);
		
		return list;
	}
	
	// 호텔 게시판 게시글 작성하기 기능
	public int insertNotice(HNotice n) {
		Connection conn = getConnection();
		
		int result = new HNoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 호텔 게시판 게시글 수정하기 기능
	public int selectupdateHNotice(HNotice n) {
		Connection conn = getConnection();
		
		int result = new HNoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public List<HNotice> updateNotice(int hnno) {
	      Connection conn = getConnection();
	      List<HNotice> nlist = new HNoticeDao().updateNotice(conn, hnno);
	      
	      close(conn);
	      
	      return nlist;
	   }

}
