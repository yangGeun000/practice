package green.spring.greenBBS;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
	// 고유식별번호
	private String isbn;
	
	// 이름
	private String title;
	
	// 저자
	private String author;
	
	// 출판사
	private String publisher;
	
	// 가격
	private int price;
	
	// 출간날짜
	private LocalDate publishedDate;
}
