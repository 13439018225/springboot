<<<<<<< HEAD
package springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.bean.User;
import springboot.service.IMenuServcie;
import springboot.util.RedisUtil;
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private IMenuServcie menuServcie;
	
/*	@Autowired
	private RedisUtil redisUtil;*/
	
	//加载tree菜单
	@RequestMapping("/getTreeAuthMenu")
	@ResponseBody
	public String getTreeAuthMenu(HttpSession session){
		User user=(User) session.getAttribute("userinfo");
		//User user=(User)redisUtil.get(session.getId());
		String menus="";
		try {
			 menus=menuServcie.getTreeAuthMenu(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

}
=======
package springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.bean.User;
import springboot.service.IMenuServcie;
import springboot.util.RedisUtil;
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private IMenuServcie menuServcie;
	
/*	@Autowired
	private RedisUtil redisUtil;*/
	
	//加载tree菜单
	@RequestMapping("/getTreeAuthMenu")
	@ResponseBody
	public String getTreeAuthMenu(HttpSession session){
		User user=(User) session.getAttribute("userinfo");
		//User user=(User)redisUtil.get(session.getId());
		String menus="";
		try {
			 menus=menuServcie.getTreeAuthMenu(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

}
>>>>>>> tijioa
