package review.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import review.model.dao.ReviewDao;
import review.model.vo.Review;

public class ReviewService {
	// 리뷰 게시판 보드 확인
	public List<Review> selectList(int hotelId) {
		Connection conn = getConnection();
		
		List<Review> list = new ReviewDao().selectList(conn, hotelId);
		
		close(conn);
		
		return list;
	}
	// 리뷰 게시판에서 내용 찾기 기능
	public List<Review> searchBoard(String searchCondition, String search) {
		Connection conn = getConnection();
		
		List<Review> list = new ReviewDao().searchBoard(conn, searchCondition, search);
		
		close(conn);
		
		return list;
	}
	// 리뷰 페이시 상세 보기
	public Review selectDetailList(int review_no) {
		Connection conn = getConnection();
		
		Review list = new ReviewDao().selectDetailList(conn, review_no);
		
		close(conn);
		
		return list;
	}
	// 작성폼에 reservationNO 조회해오기
	public Review reviewInsertForm(int no) {
		Connection conn = getConnection();
		
		Review r = new ReviewDao().reviewInsertForm(conn, no);
		
		

		close(conn);

		
		
		return r;
		
		
	}

	// 작성한거 넣기
	
	public int reviewInsert(Review r) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().reviewInsert(conn, r);
		
		close(conn);
		
		
		return result;
	}
	

	// 예약한거 가져오기 외부조인
	public List<Review> rCheckList(String userId) {
		Connection conn = getConnection();
		
		List<Review> rlist = new ReviewDao().rCheckList(conn, userId);
		
		close(conn);
		
		return rlist;
	
	}
	// 아이디로 리스트 가져오기
	public List<Review> selectList(String accountId) {
		Connection conn = getConnection();
		
		List<Review> list = new ReviewDao().selectList(conn, accountId);
		
		close(conn);
		
		return list;
		
	}

	// 리뷰 상세보기
	public Review reviewDetail(int no) {
		Connection conn = getConnection();
		
		Review list = new ReviewDao().reviewDetail(conn, no);
		
		close(conn);
		
		return list;
	}

	
	
	// 리뷰 수정하기
	public int reviewUpdate(Review r) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().reviewUpdate(conn, r);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 리뷰 삭제
	public int reviewDelete(int no) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().reviewDelete(conn, no);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		System.out.println("result : "+ result);
		close(conn);
		
		return result;
	}

	// 리뷰작성버튼 활성화 비활성화
	public int reviewChecked(int reservation_no) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().reviewChecked(conn, reservation_no);
		
		
		close(conn);
		
		return result;
	}

	
}
