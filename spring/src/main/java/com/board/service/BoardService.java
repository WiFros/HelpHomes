package com.board.service;
import java.sql.SQLException;
//Controller를 위한 인터페이스
//Controller가 메소드를 이용함.
import java.util.ArrayList;

import com.board.vo.Board;

public interface BoardService {
	ArrayList<Board> selectAll() throws SQLException;//모든 글정보
	Board selectOne(Integer num) throws SQLException;//해당 번호의 글 조회
	int insert(Board b) throws SQLException;//새글 추가
	int delete(Integer num) throws SQLException;//해당 번호의 글 삭제
	int modify(Board b) throws SQLException;
}
