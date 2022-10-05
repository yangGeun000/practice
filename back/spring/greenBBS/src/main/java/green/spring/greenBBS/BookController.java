package green.spring.greenBBS;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@RequestMapping("/book")
	@ResponseBody
	public String book() {
		Book book = new Book();
		book.setTitle("점프투스프링부트");
		book.setAuthor("박응용");
		book.setPublisher("위키독스");
		book.setPublishedDate(LocalDate.of(2022, 3, 25));
		book.setPrice(25000);
		String tmp ="책제목 | " + book.getTitle() + "<br>"
				  + "-------------------------------------<br>"
				  + "저자	&emsp;| " + book.getAuthor() + "<br>"
				  + "-------------------------------------<br>"
				  + "출간일 | " + book.getPublishedDate();
		return tmp;
	}
	
}
