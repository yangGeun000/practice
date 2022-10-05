package com.green.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.sbb.question.Question;
import com.green.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void testInsertQuesion() {
		Question q = new Question();
		q.setSubject("게시판");
		q.setContent("낙서장");
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
	@Test
	void testFindBySubject() {
		Question q = this.questionRepository.findBySubject("게시판");
		assertEquals("게시판",q.getSubject());
	}
	
	@Test
	void testUpdateQuesion() {
		Question q = this.questionRepository.findBySubject("게시판");
		q.setSubject("방명록");
		q.setContent("게스트북");
		this.questionRepository.save(q);
	}
}
