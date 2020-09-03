<<<<<<< HEAD
package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/tomain")
	public String toMain(){
		return "main";
	}

}
=======
package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/tomain")
	public String toMain(){
		return "main";
	}

}
>>>>>>> tijioa
