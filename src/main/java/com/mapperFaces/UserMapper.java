package com.mapperFaces;



import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.entity.User;
@Service
public interface UserMapper {
    int deleteByPrimaryKey(Integer enId);

    int insert(User record);

    int insertSelective(User record);
    

    User selectByPrimaryKey(Integer enId);
    
    int userCount();//返回总条数
    List<User>limit(@Param("strat")Integer strat,@Param("end")Integer end);//分页

    int updateByPrimaryKeySelective(User record);

      //查询名字
    User selectName(String name);
    int updateByPrimaryKey(User record);
    //注册
      
    int insertUser(@Param("name")String name,@Param("reyname")String reyname,@Param("passd")String passd);
    //登录
    User selectBPrimaryUserNameBypassword(@Param("name")String name,@Param("pasdd") String pasdd);
    int upuserPassd(@Param("passd")String passd,@Param("epcId")Integer epcId);//修改密码
}