package com.dealMark.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dealMark.vo.DealMark;

public interface DealMarkService {

	int insert(DealMark d) throws SQLException;// 새글 추가

	int delete(DealMark d) throws SQLException;// 삭제

	List<Long> selectAll(String userId) throws SQLException;
}
