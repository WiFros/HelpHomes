package com.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.info.vo.Store;
import com.info.vo.StoreCategory;

@Mapper
public interface StoreMapper {

	List<Store> findByDongCode(String dongCode, Integer pageSize, Integer offset);

	List<StoreCategory> getCateListByDongCode(String dongCode);

}
