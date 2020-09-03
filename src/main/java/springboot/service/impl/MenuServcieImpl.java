<<<<<<< HEAD
package springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import springboot.bean.Tree;
import springboot.bean.User;
import springboot.dao.IMenuMapper;
import springboot.service.IMenuServcie;
import springboot.util.RedisUtil;

import com.alibaba.fastjson.JSONObject;

@Service
public class MenuServcieImpl implements IMenuServcie {
	@Autowired
	private IMenuMapper menuMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public String getTreeAuthMenu(User user) throws Exception {
		
		String json="";
		if(user==null || "admin".equals(user.getName())){
			//查看全部菜单
			json=getAllMenu(user);
		}else{
			String userid=user.getId();
			String username=user.getName();
			try {
				//先从redis 中取
				json=(String)redisUtil.get(username);
				if(StringUtils.isEmpty(json)){
					//如果redis中取不到,则从关系型数据库中取
					//查询父节点
					List<Tree> plist = menuMapper.getTreeAuthMenuParent(userid);
					json=getMenu(plist);
					//将菜单信息放到redis中
					redisUtil.set(username, json, 7*24*60*60);
				}
			} catch (Exception e) {
				e.printStackTrace();
				List<Tree> plist = menuMapper.getTreeAuthMenuParent(userid);
				json=getMenu(plist);
			}
		}
		return json;
	}
	
    //admin 用户查询全部菜单
	private String getAllMenu(User user){
		String username=user==null?"admin":user.getName();
		String menus="";
		try {
			//先从redis中取
			menus=(String)redisUtil.get(username);
			if(StringUtils.isEmpty(menus)){
				//说明redis 中取不到，则从关系型数据库中取
				List<Tree> plist = menuMapper.getAllMenu("0");
				menus=getMenu(plist);
				//将菜单信息放到redis中
				redisUtil.set(username, menus, 7*24*60*60);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			List<Tree> plist;
			try {
				plist = menuMapper.getAllMenu("0");
				menus=getMenu(plist);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return menus;
	}
	
	private String getMenu(List<Tree> plist){
		String json="";
		if(plist!=null){
			try {
				for(Tree tree:plist){
					String id=tree.getId();
					List<Tree> children = menuMapper.getAllMenu(id);
					tree.setChildren(children);
				}
				json=JSONObject.toJSONString(plist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
=======
package springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import springboot.bean.Tree;
import springboot.bean.User;
import springboot.dao.IMenuMapper;
import springboot.service.IMenuServcie;
import springboot.util.RedisUtil;

import com.alibaba.fastjson.JSONObject;

@Service
public class MenuServcieImpl implements IMenuServcie {
	@Autowired
	private IMenuMapper menuMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public String getTreeAuthMenu(User user) throws Exception {
		
		String json="";
		if(user==null || "admin".equals(user.getName())){
			//查看全部菜单
			json=getAllMenu(user);
		}else{
			String userid=user.getId();
			String username=user.getName();
			try {
				//先从redis 中取
				json=(String)redisUtil.get(username);
				if(StringUtils.isEmpty(json)){
					//如果redis中取不到,则从关系型数据库中取
					//查询父节点
					List<Tree> plist = menuMapper.getTreeAuthMenuParent(userid);
					json=getMenu(plist);
					//将菜单信息放到redis中
					redisUtil.set(username, json, 7*24*60*60);
				}
			} catch (Exception e) {
				e.printStackTrace();
				List<Tree> plist = menuMapper.getTreeAuthMenuParent(userid);
				json=getMenu(plist);
			}
		}
		return json;
	}
	
    //admin 用户查询全部菜单
	private String getAllMenu(User user){
		String username=user==null?"admin":user.getName();
		String menus="";
		try {
			//先从redis中取
			menus=(String)redisUtil.get(username);
			if(StringUtils.isEmpty(menus)){
				//说明redis 中取不到，则从关系型数据库中取
				List<Tree> plist = menuMapper.getAllMenu("0");
				menus=getMenu(plist);
				//将菜单信息放到redis中
				redisUtil.set(username, menus, 7*24*60*60);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			List<Tree> plist;
			try {
				plist = menuMapper.getAllMenu("0");
				menus=getMenu(plist);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return menus;
	}
	
	private String getMenu(List<Tree> plist){
		String json="";
		if(plist!=null){
			try {
				for(Tree tree:plist){
					String id=tree.getId();
					List<Tree> children = menuMapper.getAllMenu(id);
					tree.setChildren(children);
				}
				json=JSONObject.toJSONString(plist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
>>>>>>> tijioa
