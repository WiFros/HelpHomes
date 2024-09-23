package com.info.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.service.StoreService;
import com.info.vo.Store;
import com.info.vo.StoreCategory;
import com.util.ResultDto;

@RestController
@RequestMapping("/store")
public class StoreRestController {

	@Autowired
	private StoreService service;
	
	@GetMapping("/list/{dongCode}")
	public ResponseEntity<ResultDto<List<Store>>> getStoreInfo(@PathVariable("dongCode") String dongCode,
			@RequestParam(value="pageSize", required = false, defaultValue = "30") Integer pageSize,
			@RequestParam(value="pageNum",required = false, defaultValue = "1") Integer pageNum) {
		try {
			return ResponseEntity.status(200)
					.body(new ResultDto<>(
							200,
							"ok",
							service.getInfos(dongCode, pageSize, pageNum)));
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(400)
					.body(new ResultDto<>(
							400,
							"check dongCode",
							null
							));
		}
	}
	
	@GetMapping("/category/{dongCode}")
	public ResponseEntity<ResultDto<List<StoreCategory>>> getStoreCateInfo(@PathVariable("dongCode") String dongCode) {
		try {
			return ResponseEntity.status(200)
					.body(new ResultDto<>(
							200,
							"ok",
							service.getCate(dongCode)));
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(400)
					.body(new ResultDto<>(
							400,
							"check dongCode",
							null
							));
		}
	}
}
