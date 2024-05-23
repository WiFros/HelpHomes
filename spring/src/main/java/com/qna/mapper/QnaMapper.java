package com.qna.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.qna.vo.Qna;

@Mapper
public interface QnaMapper {
	ArrayList<Qna> selectAll() throws SQLException;//모든 글정보
	Qna selectOne(Integer num) throws SQLException;//해당 번호의 글 조회
	int insert(Qna b) throws SQLException;//새글 추가
	int delete(Integer num) throws SQLException;//해당 번호의 글 삭제
	public int countUp(Integer num) throws SQLException;//조회수 증가
	int modify(Qna b) throws SQLException;
	int answer(Qna b) throws SQLException;
	List<Qna> search(Map<String, String> map);
}