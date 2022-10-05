package com.test.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
	  
	   @RequestMapping("/question/list")
	   @ResponseBody
	   public String list() {
	          return  "안녕하세요!";
	   } 
	   
} 

