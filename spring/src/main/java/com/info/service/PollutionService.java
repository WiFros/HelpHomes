package com.info.service;

import java.sql.SQLException;
import java.util.List;

import com.info.vo.Pollution;

public interface PollutionService {

	List<Pollution> getInfos(String dongCode) throws SQLException;
}
