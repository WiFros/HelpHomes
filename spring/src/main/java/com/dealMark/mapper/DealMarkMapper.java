package com.dealMark.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.dealMark.vo.DealMark;

@Mapper
public interface DealMarkMapper {

	int insert(DealMark d) throws SQLException;// 새글 추가

	int delete(DealMark d) throws SQLException;// 해당 번호의 글 삭제

	// public int countUp(Integer num) throws SQLException;// 조회수 증가

	// int modify(dealMark b) throws SQLException;

	List<Long> selectAll(String userId) throws SQLException;
}