package com.green.sbb.question;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.sbb.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
	}
	
	@RequestMapping("/detail/{id}")
	public String detial(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String createQuestion(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String createQuestion(@Valid QuestionForm questionForm , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable("id") Integer id) {
		this.questionService.delete(id);
		return "redirect:/question/list";
	}
	
	@GetMapping("/update/{id}")
	public String updateQeustion(@PathVariable("id") Integer id, QuestionForm questionForm) {
		Question question=this.questionService.getQuestion(id);
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		return "question_update";
	}
	
	@PostMapping("/update/{id}")
	public String updateQeustion(@PathVariable("id") Integer id, @Valid QuestionForm questionForm , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "question_update";
		}
		this.questionService.update(id,questionForm.getSubject(), questionForm.getContent());
		return String.format("redirect:/question/detail/%s",id);
	}
}
