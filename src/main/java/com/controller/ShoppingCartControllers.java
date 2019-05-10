package com.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.ShoppingCart;
import service.ShoppingCartService;


@RestController
@CrossOrigin
public class ShoppingCartControllers {
	
	@Resource(name = "shoppingCartService")
	private ShoppingCartService shoppingCartService;
	
	/**
	 * @param userId
	 * @return 如果查询成功返回购物车商品列表，否则返回null
	 * 根据用户id查询购物车  ajax发送的变量名字要和接口变量名字一样 [userId : value]
	 * 返回json对象数组
	 */
	@RequestMapping(value = "/shoppingCart.do",method = RequestMethod.POST)
	@ResponseBody
	public List<ShoppingCart> displayUserShoppingCart(@Param("userId")Integer userId,HttpServletResponse response) {
		System.out.println(userId);
		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
//	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    
		
			List<ShoppingCart> list = shoppingCartService.displayUserShoppingCart(userId);
			System.out.println("***********请求到购物车数据***********");
			System.out.println(list.size());
			for(ShoppingCart cart:list){
				System.out.println(cart);}
			return list;
		
		
		
	}
	/**
	 * 添加商品到购物车
	 * @param jsonObject
	 * @return Integer
	 */
	@RequestMapping(value = "/addProduct.do",method = RequestMethod.POST)
	@ResponseBody
	public Integer addProduct(@RequestBody JSONObject jsonObject) {
		if(jsonObject.isEmpty())
			return null;
		String imgPath = "";
		List<Integer> list = new ArrayList<>();
		Set<String> keys = jsonObject.keySet();
		for(String key : keys) {
			if(key.equals("esEpFilePath")){
				imgPath = jsonObject.getString(key);
				continue;
			}
			list.add(Integer.parseInt(jsonObject.getString(key)));
		}
		ShoppingCart cart = new ShoppingCart(null,imgPath,list.get(0),list.get(1),list.get(2));
		Integer count = shoppingCartService.insert(cart);
		return count == null ? null : count;
		
	}
	
//	/**
//	 * 
//	 * @param userId
//	 * @param esId
//	 * @return 删除成功返回1否则返回null
//	 * 单条记录删除，根据用户的id和购物车id查询。
//	 */
//	@RequestMapping(value = "/deleteProduct.do",method = RequestMethod.POST)
//	public Integer deleteProducts(@Param("userId")Integer userId,@Param("esId")Integer esId) {
//		if(userId != null && esId != null)
//			return shoppingCartService.deleteProducts(userId, esId);
//		else
//			return null;
//	}
	
	/**
	 * 
	 * @param userId
	 * @return 删除成功返回清空的记录数目否则返回null
	 * 清空购物车根据用户id删除。
	 */
	@RequestMapping(value = "/deleteFullProduct.do",method = RequestMethod.POST)
	public Integer deleteFullProduct(@Param("userId")Integer userId) {
		if(userId != null) 
			return shoppingCartService.deleteFullProduct(userId);
		else
			return null;
			
	}
	
	/**
	 * 
	 * @param jsonObject
	 * @return 返回删除购物车商品数(逐个提交)
	 * 根据用户id和购物车id删除用户购物车中相应的商品，最后返回删除的数量。如果发送的json数据为空，
	 */
	
	@RequestMapping(value = "/deleteSelectionProduct.do",method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteSelectionProduct(@RequestBody JSONObject jsonObject) {
		System.out.println("deleteSelectionProduct:"+jsonObject == null);
		if(jsonObject.isEmpty())
			return null;
		
		Integer count = 0;
		//获取用户id userId:value
		Integer enId = Integer.parseInt(jsonObject.getString("userId"));
		System.out.println(enId);
		//获取购物车id
		JSONArray jsonArray = jsonObject.getJSONArray("list");
		Object objArray[] = jsonArray.toArray();
		for(Object obj : jsonArray) {
			JSONObject jObject = (JSONObject)obj;
			Set<String> keys = jObject.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				shoppingCartService.deleteProducts(enId, Integer.parseInt(jObject.getString(key)));
//				System.out.println(key + ":" + jObject.getString(key));
				count += 1;
			}
		}
		System.out.println("deleteSelectionProduct result:"+count);
		return count;
	}
	
	
	/**
	 * @return 返回修改后的数量
	 * 根据返回回去的购物车数据，再以返回回去的数据发送给接口，以json格式发送给接口(接口处理的是前段的json对象)
	 */
	//更新购物车的商品信息
	@RequestMapping(value = "/changeProductMsg.do",method = RequestMethod.POST)
	@ResponseBody
	public Integer changeProductMsg(@RequestBody JSONObject jsonObject) {
	
		if(jsonObject.isEmpty()) 
			return null;
		Integer count = 0;
		String imgPath = "";
		JSONArray jsonArray = jsonObject.getJSONArray("products");
		
		Object objArray[] = jsonArray.toArray();
		List<Integer> typeData = new ArrayList<>();
		
		
		
		for(Object obj:objArray) {
			JSONObject jObject = (JSONObject)obj;
			Set<String> keys = jObject.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				if(key.equals("esEpFilePath")) {
					imgPath = (String) jObject.get(key);
					continue;
				}
				Integer varNumber = Integer.parseInt(jObject.getString(key));
				typeData.add(varNumber);
			}
			

			
			count += shoppingCartService.updateByPrimaryKeySelective(
					new ShoppingCart(typeData.get(0),imgPath, typeData.get(1), typeData.get(2), typeData.get(3)));
			
		}
		
		return count;
		
	}
	
	
	//根据json数据中是立体类的属性利用反射调用实体类的setter方法并实例化实体类(有bug!!!!!!!!!)
	public Object setFieldValue(Object bean,TreeMap<String,String> map) {
		
		Class<?> cls = bean.getClass();
		Method methods[] = cls.getDeclaredMethods();
		Field field[] = cls.getDeclaredFields();
		
		
		for(Field fd:field) {
			try {
				
				String fieldSetName = this.parSetName(fd.getName());
				
				if(!checkSetMet(methods, fieldSetName)) 
					continue;
				
				Method fieldSetMet = cls.getMethod(fieldSetName, fd.getType());
				
				String fieldName = fd.getName();
				String value = map.get(fieldName);
				System.out.println(value);
				if(null != value && !"".equals(value)) {
					String fieldTyep = fd.getType().getSimpleName();
					if("Integer".equals(fieldTyep) || "int".equals(fieldTyep)) {
						Integer newVar = Integer.parseInt(value);
						fieldSetMet.invoke(bean, newVar);
					}else{
						fieldSetMet.invoke(bean, value);
						
					}
				}
				
			
			}catch(Exception e) {
				continue;
			}
		}
		return bean;
	}
	
	//将订单时间格式转换成正确的时间格式
	public Date parseDate(String dateStr) {
		if(dateStr == null || "".equals(dateStr))
			return null;
		String newDate = null;
		try {
			if(dateStr.indexOf(":") > 0) 
				newDate = "yyyy-MM-dd HH:mm:ss";
			else 
				newDate = "yyy-MM-dd";
			SimpleDateFormat df = new SimpleDateFormat(newDate,Locale.CHINA);
			return df.parse(dateStr);
		}catch(Exception e) {
			return null;
		}
	}
	//获取类字段的setter的名字
	public String parSetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        int startIndex = 0;   
        return "set"  
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
                + fieldName.substring(startIndex);  
    }
	//检查在类的所有方法中是否存在当前给定的方法
	private boolean checkSetMet(Method methods[],String fieldSetMet) {
		for (Method met : methods) {  
            if (fieldSetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false; 
	}
	

	
	
	
	
	
	
	

	
}
