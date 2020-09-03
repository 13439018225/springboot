<<<<<<< HEAD
package springboot.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.User;
import springboot.dao.IUMapper;
import springboot.service.IUServcie;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UServcieImpl implements IUServcie {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private IUMapper userMapper;
	
	@Override
	public List<User> query(String currentPage) throws Exception {
		//分页插件
		int pageSize=2;
		int pageNum=Integer.parseInt(StringUtils.isNotEmpty(currentPage)?currentPage:"0");
		Page<Object> page=PageHelper.startPage(pageNum, pageSize);
		
		List<User> list=userMapper.query();
		logger.info("总记录数==="+page.getTotal()+",每页记录数==="+page.getPageSize()+",总页数==="+page.getPages()+","
				+ "当前第几页=="+page.getPageNum());
		
		/*PageInfo info = new PageInfo(list);
		logger.info("总记录=="+info.getTotal()+",总页数=="+info.getPages()+","
				+ "当前第"+info.getPageNum()+",每页记录数=="+info.getPageSize());*/
		return list;
	}

	@Override
	public User getObjById(String id) throws Exception {
		User user=userMapper.getObjById(id);
		return user;
	}

	@Override
	public int save(User user) throws Exception {
		int k=0;
		if(StringUtils.isNotEmpty(user.getId())){
			//修改
			k=userMapper.update(user);
		}else{
			//增加
			k=userMapper.add(user);
		}
		return k;
	}

	@Override
	public int del(int id) throws Exception {
		return userMapper.del(id);
	}

}
=======
package springboot.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.User;
import springboot.dao.IUMapper;
import springboot.service.IUServcie;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UServcieImpl implements IUServcie {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private IUMapper userMapper;
	
	@Override
	public List<User> query(String currentPage) throws Exception {
		//分页插件
		int pageSize=2;
		int pageNum=Integer.parseInt(StringUtils.isNotEmpty(currentPage)?currentPage:"0");
		Page<Object> page=PageHelper.startPage(pageNum, pageSize);
		
		List<User> list=userMapper.query();
		logger.info("总记录数==="+page.getTotal()+",每页记录数==="+page.getPageSize()+",总页数==="+page.getPages()+","
				+ "当前第几页=="+page.getPageNum());
		
		/*PageInfo info = new PageInfo(list);
		logger.info("总记录=="+info.getTotal()+",总页数=="+info.getPages()+","
				+ "当前第"+info.getPageNum()+",每页记录数=="+info.getPageSize());*/
		return list;
	}

	@Override
	public User getObjById(String id) throws Exception {
		User user=userMapper.getObjById(id);
		return user;
	}

	@Override
	public int save(User user) throws Exception {
		int k=0;
		if(StringUtils.isNotEmpty(user.getId())){
			//修改
			k=userMapper.update(user);
		}else{
			//增加
			k=userMapper.add(user);
		}
		return k;
	}

	@Override
	public int del(int id) throws Exception {
		return userMapper.del(id);
	}

}
>>>>>>> tijioa
