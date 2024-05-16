package com.info.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.service.PollutionService;
import com.info.vo.Pollution;
import com.util.ResultDto;

@RestController
@RequestMapping("/pollution")
public class PollutionRestController {

	@Autowired
	private PollutionService service;
	
	@GetMapping("/{dongCode}")
	public ResponseEntity<ResultDto<List<Pollution>>> getPollutionInfo(@PathVariable("dongCode") String dongCode) {
		try {
			return ResponseEntity.status(200)
					.body(new ResultDto<>(
							200, 
							"ok", 
							service.getInfos(dongCode)));
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(400)
					.body(new ResultDto<>(
							400, 
							"check dongCode", 
							null));
		}
	}
}
