package com.qna.controller;

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
import com.qna.service.QnaService;
import com.qna.vo.Qna;
import com.util.ResultDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/qna")
@CrossOrigin("*")
@Tag(name="Q&A 게시판 컨트롤러", description = "Q&A 게시판의 글 등록 수정 삭제 검색 목록 기능 ")
public class QnaRestController {
	@Autowired
	QnaService service;
	
	//전체 조회 
	@Operation(summary = "전체조회", description="전체 게시글을 반환합니다.")
	@GetMapping("")
	public ResponseEntity<List<Qna>> list() throws SQLException {
		ArrayList<Qna> list = service.selectAll();
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<Qna>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<Qna>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}
	
	@Operation(summary = "상세조회", description="게시글을 반환합니다.")
	@GetMapping("/{num}")
	public ResponseEntity<ResultDto<Qna>> read(@PathVariable("num") Integer num) throws SQLException {
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						200,
						"ok",
						service.selectOne(num)));
	}

	@Operation(summary = "게시글 삭제", description="게시글을 삭제합니다.")
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

	@Operation(summary = "게시글 작성", description="게시글을 생성합니다.")
	@PostMapping("")
	public ResponseEntity<ResultDto<Integer>> insertProcess(@RequestBody Qna b, 
			HttpSession session) throws SQLException {
		// 세션 확인 로직 추가 필요
	
		return ResponseEntity.status(200)
				.body(new ResultDto<>(
						201,
						"created",
						service.insert(b)
						));
	}
	@Operation(summary = "게시글 수정", description="게시글을 수정합니다.")
	@PutMapping("/{num}")
	public ResponseEntity<ResultDto<Integer>> modifyProcess(@PathVariable("num") Integer num,
			@RequestBody Qna dto,
			HttpSession session) throws SQLException {
		// 세션 확인 로직 추가 필요
//		if (!checkAdmin(session)) {
//			return ResponseEntity.status(403)
//					.body(new ResultDto<>(
//							403,
//							"access only admin",
//							null
//							));
//		}
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
	@Operation(summary = "게시글 검색", description="게시글을 검색합니다. http://localhost/qna/search?condition=title&word=hello 쿼리 파라미터는 title, writer을 condition으로 word")
	@GetMapping("/search")
	public ResponseEntity<List<Qna>> search(Model model, @RequestParam("condition") String condition, @RequestParam("word") String word) throws Exception {	
		List<Qna> list = service.search(condition, word);
		if (list != null && !list.isEmpty()) {
			ResponseEntity<List<Qna>> res = new ResponseEntity<>(list, HttpStatus.OK);
			return res;
		}
		else {
			ResponseEntity<List<Qna>> res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return res;
		}
	}	
}
