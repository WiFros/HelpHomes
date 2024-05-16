package com.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.Board;
import com.util.ResultDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	
	@Autowired
	private BoardService service;

	// http://localhost:8080/rest/boards
	@GetMapping("")
	public ResponseEntity<ResultDto<List<Board>>> list() throws SQLException {
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						200,
						"ok",
						service.selectAll()));
	}

	@GetMapping("/{num}")
	public ResponseEntity<ResultDto<Board>> read(@PathVariable("num") Integer num) throws SQLException {
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						200,
						"ok",
						service.selectOne(num)));
	}


	@DeleteMapping("/{num}")
	public ResponseEntity<ResultDto<Integer>> delete(@PathVariable("num") Integer num,
			HttpSession session) throws SQLException {
		// 세션 확인 로직 추가 필요
		if (!checkAdmin(session)) {
			return ResponseEntity.status(403)
					.body(new ResultDto<>(
							403,
							"access only admin",
							null
							));
		}
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						200,
						"ok",
						service.delete(num)
						));
	}

	
	@PostMapping("")
	public ResponseEntity<ResultDto<Integer>> insertProcess(@RequestBody Board b, 
			HttpSession session) throws SQLException {
		// 세션 확인 로직 추가 필요
		if (!checkAdmin(session)) {
			return ResponseEntity.status(403)
					.body(new ResultDto<>(
							403,
							"access only admin",
							null
							));
		}
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						201,
						"created",
						service.insert(b)
						));
	}
	
	@PostMapping("/{num}")
	public ResponseEntity<ResultDto<Integer>> modifyProcess(@PathVariable("num") Integer num,
			@RequestBody Board dto,
			HttpSession session) throws SQLException {
		// 세션 확인 로직 추가 필요
		if (!checkAdmin(session)) {
			return ResponseEntity.status(403)
					.body(new ResultDto<>(
							403,
							"access only admin",
							null
							));
		}
		dto.setNum(num);
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						200,
						"ok",
						service.modify(dto)
						));
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorProcess() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMsg", "에러발생");
		mv.setViewName("error");
		return mv;
	}
	
	
	private boolean checkAdmin(HttpSession httpSession) {
		if (httpSession.getAttribute("user")!=null&&httpSession.getAttribute("user").equals("admin")) {
			return true;
		}
		return true; // test용으로 true 처리함
	}
}
