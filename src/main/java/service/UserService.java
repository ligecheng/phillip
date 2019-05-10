package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.mapperFaces.UserMapper;
@Service
public class UserService implements UserMapper{
      @Resource
      UserMapper user;
	@Override
	public int deleteByPrimaryKey(Integer enId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer enId) {
		// TODO Auto-generated method stub
		return user.selectByPrimaryKey(enId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}
      
	//登录
	@Override
	public User selectBPrimaryUserNameBypassword(String name, String pasdd) {
		// TODO Auto-generated method stub
		return user.selectBPrimaryUserNameBypassword(name, pasdd);
	}

	@Override
	public int insertUser(String name, String reyname, String passd) {
		// TODO Auto-generated method stub
		return user.insertUser(name, reyname, passd);
	}

	

	

	@Override
	public int upuserPassd(String passd, Integer epcId) {
		// TODO Auto-generated method stub
		return user.upuserPassd(passd, epcId);
	}
	
	/**
	 *查询名字
	 */

	@Override
	public User selectName(String name) {
		// TODO Auto-generated method stub
		return user.selectName(name);
	}
     
	/**
	 * 分页
	 */
	@Override
	public int userCount() {
		// TODO Auto-generated method stub
		return user.userCount();
	}
     /**
      * 分页
      */
	@Override
	public List<User> limit(Integer  strat,Integer end) {
		// TODO Auto-generated method stub
		return user.limit(strat,end);
	}

}
