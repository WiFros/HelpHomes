package com.board.mapper;

//BoardService를 위한 인터페이스
//Controller가 메소드를 이용함.
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.MergedAnnotations.Search;

import com.board.vo.Board;

@Mapper
public interface BoardMapper {
	ArrayList<Board> selectAll() throws SQLException;//모든 글정보
	Board selectOne(Integer num) throws SQLException;//해당 번호의 글 조회
	int insert(Board b) throws SQLException;//새글 추가
	int delete(Integer num) throws SQLException;//해당 번호의 글 삭제
	public int countUp(Integer num) throws SQLException;//조회수 증가
	int modify(Board b) throws SQLException;
}
