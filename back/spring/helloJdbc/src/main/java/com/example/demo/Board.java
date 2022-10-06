package com.example.demo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	// 게시글 번호
	private int boardNo;
	
	// 제목
	private String subject;

	// 내용
	private String content;
	
	// 글쓴이
	private String writer;
	
	// 작성날짜
	private LocalDateTime regDate;
	
}
