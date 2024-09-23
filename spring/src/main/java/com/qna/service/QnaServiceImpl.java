package com.qna.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.vo.Board;
import com.qna.mapper.QnaMapper;
import com.qna.vo.Qna;

@Service
public class QnaServiceImpl implements QnaService{
	@Autowired
	QnaMapper mapper;//INTERFACE TYPE

	@Override
	public ArrayList<Qna> selectAll() throws SQLException {
		ArrayList<Qna> list = mapper.selectAll();
		return list;//->
	}

	@Override
	@Transactional
	public Qna selectOne(Integer num) throws SQLException {
		mapper.countUp(num);
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Qna b) throws SQLException {
		return mapper.insert(b);
	}

	@Override
	public int delete(Integer num) throws SQLException {
		return mapper.delete(num);
	}

	@Override
	public int modify(Qna b) throws SQLException {
		
		return mapper.modify(b);
	}

	@Override
	public int answer(Qna b) throws SQLException {
		return mapper.answer(b);
	}


	@Override
	public List<Qna> search(String condition, String word) {
		Map<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("word", word);
		return mapper.search(map);
	}
	

}
