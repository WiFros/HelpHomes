package com.apt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apt.service.AptService;
import com.apt.trie.Trie;
import com.apt.trie.TrieNode;
import com.apt.vo.AptDeal;

@CrossOrigin("*") 
@RestController
@RequestMapping("/apt")
public class AptRestController {
	
	@Autowired
	AptService service;

	//전체 조회 
	@GetMapping("")
	public ResponseEntity<List<AptDeal>> search(@RequestParam("year") String year, @RequestParam("month") String month) throws SQLException {
		List<AptDeal> list = service.search(year, month);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}
	
	@GetMapping("/dongSearch")
	public ResponseEntity<List<AptDeal>> dongSearch(@RequestParam("dongName") String dongName, @RequestParam("year") String year, @RequestParam("month") String month) throws SQLException {

		List<AptDeal> list = service.dongSearch(dongName, year, month);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}
	@GetMapping("/aptSearch")
	public ResponseEntity<List<AptDeal>> aptSearch(@RequestParam("aptName") String aptName, @RequestParam("year") String year, @RequestParam("month") String month) throws SQLException {
		List<AptDeal> list = service.aptSearch(aptName ,year, month);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}
	
	@GetMapping("/aptFloorSearch")
	public ResponseEntity<List<AptDeal>> aptFloorSearch(@RequestParam("aptCode") String aptCode, @RequestParam("floor") String floor) throws SQLException {
		List<AptDeal> list = service.aptFloorSearch(aptCode,floor);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<AptDeal>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}
	@GetMapping("/sido")
    public List<String> getSidoList() {
        return service.getSidoList();
    }

    @GetMapping("/gugun")
    public List<String> getGugunList(@RequestParam String sido) {
        return service.getGugunList(sido);
    }

    @GetMapping("/dong")
    public List<String> getDongList(@RequestParam String sido, @RequestParam String gugun) {
        return service.getDongList(sido, gugun);
    }
}


