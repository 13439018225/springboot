<<<<<<< HEAD
package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.User;
import springboot.dao.ILoginMapper;
import springboot.service.ILoginServcie;
import springboot.util.MD5;

@Service
public class LoginServiceImpl implements ILoginServcie {

	@Autowired
	private ILoginMapper loginMapper;
	
	@Override
	public User login(User user) throws Exception {
		return loginMapper.login(user);
	}

	@Override
	public int reUpPwd(User user) throws Exception {
		//对密码加密
		//String md5pwd=MD5.encryptPassword(user.getName(), user.getPassword(), null);
		String md5pwd=MD5.encodeMD5(user.getName(), user.getPassword());
		user.setPassword(md5pwd);
		return loginMapper.reUpPwd(user);
	}

}
=======
package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.User;
import springboot.dao.ILoginMapper;
import springboot.service.ILoginServcie;
import springboot.util.MD5;

@Service
public class LoginServiceImpl implements ILoginServcie {

	@Autowired
	private ILoginMapper loginMapper;
	
	@Override
	public User login(User user) throws Exception {
		return loginMapper.login(user);
	}

	@Override
	public int reUpPwd(User user) throws Exception {
		//对密码加密
		//String md5pwd=MD5.encryptPassword(user.getName(), user.getPassword(), null);
		String md5pwd=MD5.encodeMD5(user.getName(), user.getPassword());
		user.setPassword(md5pwd);
		return loginMapper.reUpPwd(user);
	}

}
>>>>>>> tijioa
