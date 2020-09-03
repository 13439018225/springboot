<<<<<<< HEAD
package springboot.service;

import java.util.List;

import springboot.bean.User;

public interface IUServcie {
	
	public List<User> query(String currentPage) throws Exception;
	
	public User getObjById(String id)throws Exception;
	
	public int save(User user)throws Exception;
	
	public int del(int id)throws Exception;

}
=======
package springboot.service;

import java.util.List;

import springboot.bean.User;

public interface IUServcie {
	
	public List<User> query(String currentPage) throws Exception;
	
	public User getObjById(String id)throws Exception;
	
	public int save(User user)throws Exception;
	
	public int del(int id)throws Exception;

}
>>>>>>> tijioa
