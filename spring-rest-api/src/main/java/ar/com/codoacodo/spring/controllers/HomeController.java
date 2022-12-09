package ar.com.codoacodo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller       //para usar un index
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
		//src/main/resources/templates/index.html
	}
}
   