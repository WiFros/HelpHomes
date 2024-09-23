package com.info.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.mapper.StoreMapper;
import com.info.vo.Store;
import com.info.vo.StoreCategory;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper mapper;
	
	@Override
	public List<Store> getInfos(String dongCode, Integer pageSize, Integer pageNum) throws SQLException {
		
		Integer offset = pageNum==null ? null : pageSize*(pageNum-1);
		return mapper.findByDongCode(dongCode, pageSize, offset);
	}

	@Override
	public List<StoreCategory> getCate(String dongCode) throws SQLException {
		return mapper.getCateListByDongCode(dongCode);
	}

}
