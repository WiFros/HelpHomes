package com.apt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apt.vo.Apart;
import com.apt.vo.AptDeal;


public interface AptService {
	
	public List<AptDeal> search(String year, String month) throws SQLException;
	public List<AptDeal> dongSearch(String dongName, String year, String month) throws SQLException;
	public List<AptDeal> aptSearch(String aptName, String year, String month) throws SQLException;
	public List<AptDeal> aptFloorSearch(String aptCode, String floor) throws SQLException;
	
	public List<Apart> markApartSearch(String userId) throws SQLException;
	
	public List<String> getSidoList();
	public List<String> getGugunList(String sido);
	public List<String> getDongList(String sido, String gugun);

}
