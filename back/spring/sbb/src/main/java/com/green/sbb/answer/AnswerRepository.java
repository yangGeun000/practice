package com.green.sbb.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	List<Answer> findByQuestion_id(Integer id);
}
