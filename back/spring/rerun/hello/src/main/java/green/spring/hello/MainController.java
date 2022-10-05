package green.spring.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/GoodMorning")
	@ResponseBody
	public String goodmorning() {
		String result = "<h1> 좋은 "
					  + "<b>아침</b>"
					  + "입니다.</h1>";
		return result;
	}
	
	@RequestMapping("/calcScore")
	@ResponseBody
	public String calcScore() {
		Student s = new Student();
		s.setName("최");
		s.setKorean(88);
		s.setEnglish(95);
		s.setMath(73);
		String result = "학생의<br>"
					  + "&emsp;이름 : " + s.getName() + "<br>" 
					  + "&emsp;국어 : " + s.getKorean() + "<br>" 
					  + "&emsp;영어 : " + s.getEnglish() + "<br>" 
					  + "&emsp;수학 : " + s.getMath() + "<br>" 
					  + "&emsp;총점 : " + s.getTotal() + "<br>" 
					  + "&emsp;평균 : " + s.getAvg() + "<br>";
		return result;
	}
}
