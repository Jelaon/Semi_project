package com.khtime.board.model.service;
import static com.khtime.common.JDBCTemplate.close;
import static com.khtime.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.khtime.board.model.dao.BoardDao;
import com.khtime.board.model.vo.Board;
import com.khtime.category.vo.Category;
import com.khtime.common.JDBCTemplate;
import com.khtime.common.model.vo.PageInfo;



public class BoardService {
	
	public ArrayList<Board> selectBoard(int cNo, PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Board> boardList = new BoardDao().selectBoard(conn, cNo, pi);

		close(conn);

		return boardList;
	}

	public int boardListCount(int cNo) {
		Connection conn = getConnection();

		int result = new BoardDao().boardListCount(conn, cNo);

		close(conn);

		return result;
	}
	
	public Board selectContent(int bNo) {
		Connection conn = getConnection();

		Board b = new BoardDao().selectContent(conn, bNo);

		close(conn);

		return b;
	}
	
	public int selectReplyCount(int bNo) {
		Connection conn = getConnection();

		int result = new BoardDao().selectReplyCount(conn, bNo);
		close(conn);

		return result;
	}


	
	public ArrayList<Board> bestList(int rcCount, PageInfo pi, String year) {
		Connection conn = getConnection();

		ArrayList<Board> bestList = new BoardDao().bestList(conn, rcCount, pi, year);

		close(conn);

		return bestList;
	}

	public int bestListCount(int rcCount) {
		Connection conn = getConnection();

		int result = new BoardDao().bestListCount(conn, rcCount);

		close(conn);

		return result;
	}
	public ArrayList<Board> getHotBestBoardlist(int recommendCount, String year) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().getHotBestBoardlist(conn, recommendCount, year);
		close(conn);
		return list;
	}
	
//	public int insertBoard(Board b, int userNo, BoardAttachment at) {
//		Connection conn = JDBCTemplate.getConnection();
//
//		int result1 = new BoardDao().insertBoard(conn, b, userNo);
//		int result2 = 1;
//		
//		if (at != null) {
//			result2 = new BoardDao().insertAttachment(conn, at);
//		}
//		
//		if(result1 * result2 > 0 ) {
//			JDBCTemplate.commit(conn);
//		}else {
//			JDBCTemplate.rollback(conn);
//		} JDBCTemplate.close(conn);
//
//		return result1 * result2;
//	}
//	
	
	public int deleteContent(int bNo, int userNo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new BoardDao().deleteContent(conn, bNo, userNo);

		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		} JDBCTemplate.close(conn);

		return result;
	}
	
	public int updateBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new BoardDao().updateBoard(conn, b);

		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		} JDBCTemplate.close(conn);

		return result;
	}
	
	public int recommendCountUp(int bNo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new BoardDao().recommendCountUp(conn, bNo);

		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		} JDBCTemplate.close(conn);

		return result;
	}
	
	public int scrapCountUp(int bNo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new BoardDao().scrapCountUp(conn, bNo);

		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		} JDBCTemplate.close(conn);

		return result;
	}
	
	public ArrayList<Category> categoryTitle( String searchTitle){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Category> cn = new  BoardDao().categoryTitle(conn , searchTitle);
	
		close(conn); 
		
		return cn;
	}
	

}
