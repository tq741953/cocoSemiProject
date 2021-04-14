package account.model.service;

import java.sql.Connection;
import java.util.List;

import account.model.dao.AccountQnADao;

import static common.JDBCTemplate.*;

import account.model.vo.QnA;
import account.model.vo.PageInfo;

public class AccountQnAService {

	public List<QnA> selectList(String accountId) {
		Connection conn = getConnection();
		
		List<QnA> list = new AccountQnADao().selectList(conn, accountId);
		
		close(conn);
		
		return list;
	}

	public QnA selectNotice(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new AccountQnADao().increaseCount(conn, qnaNo);
		
		QnA q = null;
		if(result > 0) {
			q = new AccountQnADao().selectQnA(conn, qnaNo);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return q;
	}
	public int insertQnA(QnA q) {
		Connection conn = getConnection();
		
		int result = new AccountQnADao().insertQnA(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public QnA selectQnA(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new AccountQnADao().increaseCount(conn, qnaNo);
		
		QnA q = null;
		if(result > 0) {
			q = new AccountQnADao().selectQnA(conn, qnaNo);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return q;
	}

	public int updateQnA(QnA q) {
		Connection conn = getConnection();
		
		int result = new AccountQnADao().updateQnA(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteQnA(int qnaNo) {
		Connection conn = getConnection();
		
		int result = new AccountQnADao().deleteQnA(conn, qnaNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int getAccountQnAListCountByAccountId(String accountId) {
		Connection conn = getConnection();
		int listCount = new AccountQnADao().getAccountQnAListCountByAccountId(conn, accountId);
		
		close(conn);
		return listCount;
	}

	public List<QnA> getAccountQnAListByAccountId(String accountId, PageInfo pi) {
		Connection conn = getConnection();
		List<QnA> list = new AccountQnADao().getAccountQnAListByAccountId(conn, accountId, pi);
		
		close(conn);
		return list;
	}



}
