package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDAO {
	private final JdbcTemplate jdbcTemplate;
	
	// 	db 데이터를 가져오는 방법
	// 1. 	spring jdbcTemplate 클래스 이용
	// 		jdbcTemplate에 질의할 쿼리를 등록저장
	// 		jdbcTemplate.query(
	// 		- 첫번째 인수: "SELECT ..." 질의 쿼리 등록,
	//		- 두번째 인수: 테이블 컬럼 구조를 담은 레코드들의 집합(Array, List)			
	public List<Board> list() throws Exception{
		String listSql = "select "
					   + "boardNo, subject, content, writer, reg_date "
					   + "from board "
					   + "where boardNo > 0 "
					   + "order by boardNo desc, reg_date DESC ";
		
		List<Board> results = jdbcTemplate.query(
				listSql,
				new RowMapper<Board>() {
					
					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException{
						Board board = new Board();
						
						board.setBoardNo(rs.getInt("boardNo"));
						board.setSubject(rs.getString("subject"));
						board.setContent(rs.getString("content"));
						board.setWriter(rs.getString("writer"));
						
						Timestamp timestamp = rs.getTimestamp("reg_date");
						board.setRegDate(timestamp.toLocalDateTime());
						
						return board;
					}
				});
		
			return results;
		}
}

