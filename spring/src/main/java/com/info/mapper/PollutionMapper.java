package com.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.info.vo.Pollution;

@Mapper
public interface PollutionMapper {

	List<Pollution> findByDongCode(String dongCode);
	List<Pollution> findByDongName(String dongName);

}
