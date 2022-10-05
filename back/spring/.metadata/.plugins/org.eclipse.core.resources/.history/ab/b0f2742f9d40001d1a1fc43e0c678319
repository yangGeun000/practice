package com.green.sbb.answer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.sbb.question.Question;
import com.green.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService	answerService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(id);
		if(bindingResult.hasErrors()) {
			model.addAttribute("question",question);
			return "question_detail";
		}
		this.answerService.create(question, answerForm.getContent());
		return String.format("redirect:/question/detail/%s",id);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAnswer(@PathVariable("id") Integer id){
		Integer questionId = this.answerService.delete(id);
		return String.format("redirect:/question/detail/%s",questionId);
	}
	
	@GetMapping("/update/{qid}/{id}")
	public String updateAnswer(@PathVariable("id") Integer id, @PathVariable("qid") Integer qid, AnswerForm answerForm) {
		Answer answer =this.answerService.getAnswer(id);
		answerForm.setContent(answer.getContent());
		return "answer_update";
	}
	
	@PostMapping("/update/{qid}/{id}")
	public String updateAnswer(@PathVariable("id") Integer id, @PathVariable("qid") Integer qid, @Valid AnswerForm answerForm , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "answer_update";
		}
		Answer answer = this.answerService.getAnswer(id);
		this.answerService.update(answer.getId(), answerForm.getContent());
		return String.format("redirect:/question/detail/%s", qid);
	}
}
