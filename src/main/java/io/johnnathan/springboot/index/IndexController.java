package io.johnnathan.springboot.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String start() {
		return "redirect:/products";
	}
}
