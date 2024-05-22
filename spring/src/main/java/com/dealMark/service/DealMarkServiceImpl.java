package com.dealMark.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealMark.mapper.DealMarkMapper;
import com.dealMark.vo.DealMark;

@Service
public class DealMarkServiceImpl implements DealMarkService {
	@Autowired
	DealMarkMapper mapper;// INTERFACE TYPE

	@Override
	public int insert(DealMark d) throws SQLException {
		return mapper.insert(d);
	}

	public int delete(DealMark d) throws SQLException {
		return mapper.delete(d);
	}//

	@Override
	public List<Long> selectAll(String userId) throws SQLException {
		return mapper.selectAll(userId);
	};

	// @Override
	// public int delete(Integer num) throws SQLException {
	// return mapper.delete(num);
	// }

	// @Override
	// public int modify(Qna b) throws SQLException {

	// return mapper.modify(b);
	// }

	// @Override
	// public List<Qna> search(String condition, String word) {
	// Map<String, String> map = new HashMap<>();
	// map.put("condition", condition);
	// map.put("word", word);
	// return mapper.search(map);
	// }

}
