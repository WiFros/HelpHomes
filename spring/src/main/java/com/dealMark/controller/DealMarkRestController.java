package com.dealMark.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apt.vo.AptDeal;
import com.board.vo.Board;
import com.dealMark.service.DealMarkService;
import com.dealMark.vo.DealMark;
import com.util.ResultDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/dealMark")
@CrossOrigin("*")
// @Tag(name = "Q&A 게시판 컨트롤러", description = "Q&A 게시판의 글 등록 수정 삭제 검색 목록 기능 ")
public class DealMarkRestController {
	@Autowired
	DealMarkService service;

	// 전체 조회
	// // @Operation(summary = "전체조회", description = "전체 게시글을 반환합니다.")
	// @GetMapping("")
	// public ResponseEntity<List<dealMark>> list() throws SQLException {
	// ArrayList<dealMark> list = service.selectAll();
	// if (list != null && !list.isEmpty()) {
	// ResponseEntity<List<dealMark>> res = new ResponseEntity<>(list,
	// HttpStatus.OK);
	// return res;
	// } else {
	// ResponseEntity<List<dealMark>> res = new
	// ResponseEntity<>(HttpStatus.NO_CONTENT);
	// return res;
	// }
	// }

	// @Operation(summary = "상세조회", description = "게시글을 반환합니다.")
	// @GetMapping("/{num}")
	// public ResponseEntity<ResultDto<dealMark>> read(@PathVariable("num") Integer
	// num)
	// throws SQLException {
	// return ResponseEntity.status(200)
	// .body(new ResultDto<>(
	// 200,
	// "ok",
	// service.selectOne(num)));
	// }

	// @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
	// @DeleteMapping("/{num}")
	// public ResponseEntity<ResultDto<Integer>> delete(@PathVariable("num") Integer
	// num,
	// HttpSession session) throws SQLException {

	// return ResponseEntity.status(200)
	// .body(new ResultDto<>(
	// 201,
	// "created",
	// service.insert(b)));
	// }

	@Operation(summary = "매물 찜", description = "매물을 찜 합니다.")
	@PostMapping("")
	public ResponseEntity<ResultDto<Integer>> insertProcess(@RequestBody DealMark m,
			HttpSession session) throws SQLException {

		System.out.println("받아옴:" + m);

		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						201,
						"created",
						service.insert(m)));
	}

	@Operation(summary = "찜목록 불러오기", description = "찜목록을 불러옵니다.")
	@GetMapping("/{userId}")
	public ResponseEntity<List<Long>> readAll(@PathVariable("userId") String userId,
			HttpSession session) throws SQLException {
		List<Long> list = service.selectAll(userId);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<Long>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		} else {
			ResponseEntity<List<Long>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}

	@Operation(summary = "찜 해제", description = "찜을 해제합니다.")
	@PostMapping("/delete")
	public ResponseEntity<ResultDto<Integer>> deleteProcess(@RequestBody DealMark d,
			HttpSession session) throws SQLException {

		System.out.println("삭제하려고 받아옴:" + d);
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						201,
						"deleted",
						service.delete(d)));
	}
}
