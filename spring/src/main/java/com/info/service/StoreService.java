package com.info.service;

import java.sql.SQLException;
import java.util.List;

import com.info.vo.Store;
import com.info.vo.StoreCategory;

public interface StoreService {

	List<Store> getInfos(String dongCode, Integer pageSize, Integer pageNum) throws SQLException;
	List<StoreCategory> getCate(String dongCode) throws SQLException;
}
