package notice.model.service;

import java.sql.Connection;
import java.util.List;
import static common.JDBCTemplate.*;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.PageInfo;

public class NoticeService {

	public List<Notice> selectList() {
		Connection conn = getConnection();
		
		List<Notice> list = new NoticeDao().selectList(conn);

		close(conn);
		return list;
	}

	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		Notice n = null;
		if(result > 0) {
			n = new NoticeDao().selectNotice(conn, noticeNo);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public List<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<Notice> list = new NoticeDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public List<Notice> selectList(String searchCondition, String search) {
		Connection conn = getConnection();
		
		List<Notice> list = new NoticeDao().selectList(conn, searchCondition, search);
		
		close(conn);
		
		return list;
	}

	public int getSearchListCount(String searchCondition, String search) {
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().getSearchListCount(conn, searchCondition, search);
		
		close(conn);
		
		return listCount;
	}

	public List<Notice> selectSearchList(PageInfo pi, String searchCondition, String search) {
		Connection conn = getConnection();
		
		List<Notice> list = new NoticeDao().selectSearchList(conn, pi, searchCondition, search);
		
		close(conn);
		
		return list;
	}

}
