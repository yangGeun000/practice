package com.green.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.green.sbb.DataNotFoundException;
import com.green.sbb.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	public Answer getAnswer(Integer id) {
		Optional<Answer> opAnswer = this.answerRepository.findById(id);
		if(opAnswer.isPresent()) {
			return opAnswer.get();
		}
		else {
			throw new DataNotFoundException("answer not found");
		}
	}
	
	public void create(Question question, String content) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		this.answerRepository.save(answer);
	}
	
	public Integer delete(Integer id) {
		Answer answer = getAnswer(id);
		this.answerRepository.delete(answer);
		return answer.getQuestion().getId();
	}
	
	public void update(Integer id, String content) {
		Answer answer = getAnswer(id);
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(answer);
	}
	
}
