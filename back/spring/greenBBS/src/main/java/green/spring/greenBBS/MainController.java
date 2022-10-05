package green.spring.greenBBS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/greenBBS")
	@ResponseBody
	public String green_bbs() {
		return "greenBBS";
	}
	
	@RequestMapping("/member_address")
	public String memberAndAddress(Model model) {
		Address a = new Address();
		a.setPostCode("080901");
		a.setLocation("부산");
		Member m = new Member();
		m.setUserId("test");
		m.setPassword("1234");
		m.setAddress(a);
		model.addAttribute("member",m);
		
		return "member_address";
	}
	
	@RequestMapping("/home")
	public String index() {
		return "home";
	}
}
