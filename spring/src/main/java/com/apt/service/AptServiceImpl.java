package com.apt.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.mapper.AptMapper;
import com.apt.vo.AptDeal;


@Service
public class AptServiceImpl implements AptService{
	@Autowired
	AptMapper mapper;//<- proxy가 주입됨
	
	@Override
	public List<AptDeal> search(String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		return mapper.search(map);
	}
	
	@Override
	public List<AptDeal> dongSearch(String dongName, String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("dongName", dongName);
		return mapper.dongSearch(map);
	}

	@Override
	public List<AptDeal> aptSearch(String aptName, String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("aptName", aptName);
		return mapper.aptSearch(map);
	}
	

	@Override
	public List<AptDeal> aptFloorSearch(String aptCode, String floor) throws SQLException {
	    Map<String, String> map = new HashMap<>();
	    map.put("aptCode", aptCode);
	    map.put("floor", floor);
	    return mapper.aptFloorSearch(map);
	}

}
