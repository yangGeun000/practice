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
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg","hello ");
		return "home";
	}
}
