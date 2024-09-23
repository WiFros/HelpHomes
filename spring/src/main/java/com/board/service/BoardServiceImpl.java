package com.board.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.mapper.BoardMapper;
import com.board.vo.Board;

//BoardService의 메소드를 구현한 객체
//Controller에서 들어온 요청을 실제로 처리하는 객체
//mapper에게 요청 사항을 전달함.

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;//INTERFACE TYPE


	@Override
	public ArrayList<Board> selectAll()  throws SQLException{
		ArrayList<Board> list = mapper.selectAll();
		return list;//-> Controller로 감
	}

	@Override
	@Transactional
	public Board selectOne(Integer num) throws SQLException{
		mapper.countUp(num);
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Board b) throws SQLException {
		return mapper.insert(b);
	}

	@Override
	public int delete(Integer num) throws SQLException {
		return mapper.delete(num);
	}

	@Override
	public int modify(Board b) throws SQLException {
		return mapper.modify(b);
	}

}
