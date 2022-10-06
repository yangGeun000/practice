package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
// 로그기능을 사용하겠다
@RequiredArgsConstructor
@Controller
public class BoardController {
	private final BoardDAO dao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "/board/list";
	}
	
	@RequestMapping("/board/list03")
	public void list03() {
		log.info("/board/list03 요청 ===> board_list03.html 응답");
	}
	
	// return이 없을시 함수 이름과 같은 템플릿을 리턴해준다
	@RequestMapping(value="/board/list")
	public String list(Model model) throws Exception {
		List<Board> boardList = dao.list();
		model.addAttribute("list", boardList);
		return "/board/list";
	}
	
}
