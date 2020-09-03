<<<<<<< HEAD
package springboot.dao;

import java.util.List;

import springboot.bean.User;

public interface IUMapper {
	
	public List<User> query() throws Exception;

	public User getObjById(String id) throws Exception;
	
	public int add(User user)throws Exception;
	
	public int update(User user)throws Exception;
	
	public int del(int id)throws Exception;
}
=======
package springboot.dao;

import java.util.List;

import springboot.bean.User;

public interface IUMapper {
	
	public List<User> query() throws Exception;

	public User getObjById(String id) throws Exception;
	
	public int add(User user)throws Exception;
	
	public int update(User user)throws Exception;
	
	public int del(int id)throws Exception;
}
>>>>>>> tijioa
