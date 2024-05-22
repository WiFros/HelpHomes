package com.apt.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.apt.vo.AptDeal;
import com.apt.vo.DongCode;
import com.apt.vo.Apart;

@Mapper
public interface AptMapper {
	
	public List<AptDeal> search(Map map) throws SQLException;
	public List<AptDeal> dongSearch(Map map) throws SQLException;
	public List<AptDeal> aptSearch(Map map) throws SQLException;
	public List<AptDeal> aptFloorSearch(Map map) throws SQLException;
	
	public List<Apart> markAptSearch(String userId) throws SQLException;

    @Select("SELECT dongCode, sidoName, gugunName, dongName FROM dongcode")
	public List<DongCode> findAllLocation();
}

