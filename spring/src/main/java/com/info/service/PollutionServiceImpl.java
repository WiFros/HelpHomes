package com.info.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.mapper.PollutionMapper;
import com.info.vo.Pollution;

@Service
public class PollutionServiceImpl implements PollutionService {

	@Autowired
	private PollutionMapper mapper;
	
	@Override
	public List<Pollution> getInfos(String dongCode) throws SQLException {
		if (dongCode.charAt(0)>='0'&&dongCode.charAt(0)<='9') {
			return mapper.findByDongCode(dongCode);
		}
		return mapper.findByDongName(dongCode);
	}

}
