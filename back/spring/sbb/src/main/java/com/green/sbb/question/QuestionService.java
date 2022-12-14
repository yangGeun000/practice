package com.green.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public Page<Question> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> opQuestion = this.questionRepository.findById(id);
		if(opQuestion.isPresent()) {
			return opQuestion.get();
		}
		else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void create(String subject,String content) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	public void delete(Integer id) {
		this.questionRepository.delete(getQuestion(id));
	}
	
	public void update(Integer id, String subject, String content) {
		Question question = getQuestion(id);
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
}
