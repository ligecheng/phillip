package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.annotations.Param;
import org.eclipse.sisu.Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Banner;
import com.entity.User;
import com.util.Page;

import service.BannerSverice;
import service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
    @Resource
    UserService user;
    @Resource
    BannerSverice banner;
    
    /**
     * 登录
     * @param name
     * @param passd
     * @param session
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/login")
	public User login(@Param("name")String name,@Param("passd")String passd,HttpSession session){
		 User u=user.selectBPrimaryUserNameBypassword(name, passd);
		 System.out.println(name);
		 System.out.println(passd);
		if(u!=null){
			session.setAttribute("user_info", u);
		}
       
	   
		return u;
		
	}
    /**
     * banner
     * @return
     */
    @RequestMapping("/banner")
    @ResponseBody
    public List<Banner>getBanner(){
    	return banner.getBanner();
    }
    @ResponseBody
    @RequestMapping("/registered")
    public int registerd(User model){
    	         System.out.println(model);
    	         try {
    	        	   if(model.getEnUsername()!=null&&model.getEnReallyname()!=null&&model.getEnPassword()!=null){
    	    	        	User u =user.selectName(model.getEnUsername());
    	    	        	
    	    	        	if(u!=null){
    	    	        		return 2;
    	    	        	}else{
    	    	        		 int i=user.insertUser(model.getEnUsername(), model.getEnReallyname(), model.getEnPassword());
    	        	        	 return i;
    	    	        	}
    	    	        	
    	    	        	
    	    	        }else{
    	    	        	return 0;
    	    	        }
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return 0;
				}
    	     
    	       //ystem.out.println(request.getParameter("enUsername"));
    	     
    		 
    		 
    	 
    	   
    	
    }

    /**
     * 0修改密码失败  1修改成功并更新session的值    2请先登录
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("upUserPassd")
    @ResponseBody
    public Integer upuserPassd(User model,HttpServletRequest httpServletRequest){
    	HttpSession session=httpServletRequest.getSession();
    	
    	User u=(User)session.getAttribute("user_info");
    	if(u!=null & u.getEnId().equals(model.getEnId())){
    		int i=user.upuserPassd(model.getEnPassword(), model.getEnId());
    		if(i>0){
    			session.setAttribute("user", model.getEnId());
    			
    		}
    		return i;
    	}else{
    		return 2;
    	}
    	
    }
    /**
     * 返回总条数
     * @return
     */
    @RequestMapping("/userCount")
    @ResponseBody
    public Integer getCount(){
    	/**
    	 * 获取中的数据
    	 */
    	return user.userCount();
    }
    /**
     * 分页
     */
  @RequestMapping("/userLimt")
    @ResponseBody
    public List<User> getLimit(@Param("pows")Integer pows){
    	int count=user.userCount();
    	Page page=null;
    	if(pows<0){
    		pows=0;
    	}else
    	if(pows>count){
    		pows=count;
    	}
    	if(pows!=null){
    		page=new Page(count,pows);
    	    int sum= page.getTotalPageCount();
    	    System.out.println(sum+"数据出");
    	    
    		
    		System.out.println("===="+page.getPageSize());
    		System.out.println("条数"+page.getPageSize());
    		return user.limit(page.getStartPos(),page.getPageSize());
    	}else{
    		page=new Page(count,1);
        	
    		page.setPageSize(8);
    		return user.limit(page.getStartPos(),page.getPageSize());
    	}
    	
    	
    	
    }
    
}
