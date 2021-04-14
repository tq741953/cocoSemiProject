package faq.model.service;

import java.sql.Connection;
import java.util.List;
import static common.JDBCTemplate.*;

import faq.model.dao.FaqDao;
import faq.model.vo.Faq;






public class FaqService {

	// list조회
	public List<Faq> selectList() {
		Connection conn = getConnection();
		
		List<Faq> list = new FaqDao().selectList(conn);
		
		close(conn);
		
		return list;
	}

	// faq 작성
	public int insertFaq(Faq f) {
		Connection conn = getConnection();
		
		int result = new  FaqDao().insertFaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
			
		
		
	}
	// faq 상세보기 
	public Faq faqDetail (int no) {
		Connection conn = getConnection();
		
	
		Faq f = new  FaqDao().faqDetail(conn, no);
		
		close(conn);
		
		return f;
	}

	// faq 삭제
	public int deleteFaq(int no) {
		Connection conn = getConnection();

		int result = new FaqDao().deleteFaq(conn, no);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}

	// 수정폼
	public List<Faq> faqlist(int no) {
		Connection conn = getConnection();
		
		List<Faq> faqlist = new FaqDao().faqlist(conn, no);
		
		close(conn);
		
		return faqlist;
	}

	// 수정하기
	public int updateFaq(Faq f) {
		Connection conn = getConnection();

		int result = new FaqDao().updateFaq(conn, f);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
		
	}

	// 검색으로 faq찾기
	public List<Faq> searchFaq(String searchCondition, String search) {
		Connection conn = getConnection();
		
		List<Faq> searchList = new FaqDao().searchFaq(conn, searchCondition, search);
		
		close(conn);
		
		return searchList;
	}

	

		
	
	

}
