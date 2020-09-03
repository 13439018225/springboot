<<<<<<< HEAD
package springboot.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.bean.User;
import springboot.service.IUServcie;

@Controller
public class UController {
	@Autowired
	private IUServcie userServcie;
	
	@RequestMapping("/index")
	public String toPage(Model model,String currentPage){
		//调用servcie层的方法
		List<User> list=null;
		try {
			list = userServcie.query(currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将list集合放到model数据模型中
		model.addAttribute("list", list);
		int pageNum=Integer.parseInt(StringUtils.isNotEmpty(currentPage)?currentPage:"1");
		model.addAttribute("pageNum", pageNum);
		//跳转到index.html
		return "index";
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(String id,Map<String,Object> map){
		User user=null;
		try {
		   user=userServcie.getObjById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("userinfo", user);
		return "userEdit";
	}
	
	@RequestMapping("/save")
	public String save(User user){
		int k=0;
		try {
			k = userServcie.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(k>0){
			return "redirect:/index";
		}else{
			return "userEdit";
		}
	}
	@RequestMapping("/del")
	public String del(int id){
		int k=0;
		try {
			k = userServcie.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/toAdd")
	public String del(){
		return "userEdit";
	}
}
=======
package springboot.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.bean.User;
import springboot.service.IUServcie;

@Controller
public class UController {
	@Autowired
	private IUServcie userServcie;
	
	@RequestMapping("/index")
	public String toPage(Model model,String currentPage){
		//调用servcie层的方法
		List<User> list=null;
		try {
			list = userServcie.query(currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将list集合放到model数据模型中
		model.addAttribute("list", list);
		int pageNum=Integer.parseInt(StringUtils.isNotEmpty(currentPage)?currentPage:"1");
		model.addAttribute("pageNum", pageNum);
		//跳转到index.html
		return "index";
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(String id,Map<String,Object> map){
		User user=null;
		try {
		   user=userServcie.getObjById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("userinfo", user);
		return "userEdit";
	}
	
	@RequestMapping("/save")
	public String save(User user){
		int k=0;
		try {
			k = userServcie.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(k>0){
			return "redirect:/index";
		}else{
			return "userEdit";
		}
	}
	@RequestMapping("/del")
	public String del(int id){
		int k=0;
		try {
			k = userServcie.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/toAdd")
	public String del(){
		return "userEdit";
	}
}
>>>>>>> tijioa
