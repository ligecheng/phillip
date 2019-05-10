package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.util.Page;

import net.sf.json.JSONObject;
import service.ProducntSevice;

/**
 * 
 * @author jokerTank
 * 商品
 *
 */

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	@Resource
	ProducntSevice product;
	/**
	 * 获取全部商品列表
	 * @return
	 */
	 @RequestMapping("/getProduct")
	 @ResponseBody
	 public List<Product>getProduct(){
		 List<Product>list =product.getProduct();
		 for(Product p:list){
			 System.out.println("商品参数"+p);
		 }
		 return list;
	 }
	 /**
		 * 添加商品
		 * @return 新添加的商品ID
		 */
	 @RequestMapping("/addProductForOne")
	 public Integer addProduct(Product record){
		 System.out.println("2121");
		 
		 if(record == null) {
			 System.out.println("空的商品数据!!");
			 return 0;
		 }
		 System.out.println(record.toString());
		 Integer newEpId =product.insert(record);
		 
		 return newEpId;
	 }
	 /**
	  * 获取单个商品
	  * @param epId
	  * @return Product
	  */
	 @RequestMapping("/getProductForOne")
	 public Product getProductForOne(Integer epId) {
		 //product
		List<Product>sumList=product.getProduct();
		for(Product p:sumList){
			System.out.println("测试"+p);
		}
		 return product.selectByPrimaryKey(epId);
		 
	 }
	 /**
	  * 修改商品信息
	  * @param record
	  * @return 修改结果
	  * 1为null
	  */
	 @RequestMapping("/updateProduct")
	 @ResponseBody
	 public  Integer updateProduct(Product record) {
		 if(record==null){
			 return 0;
		 }
		 System.out.println(record.toString());
		 return product.updateByPrimaryKeySelective(record);
		 
	 }

	 /**
		 * 删除商品
		 * @return delete  result
		 */
	 
	 @RequestMapping("/deleteForEpId")
	 @ResponseBody
	 public Integer deleteForEpId(Integer epId){
		 if(epId==null){
			 return 1;
		 }
		 System.out.println("2121");
		 
		 if(epId == null) {
			 System.out.println("空的商品数据!!");
			 return 0;
		 }
		 
		 Integer newEpId =product.deleteByPrimaryKey(epId);
		 
		 return newEpId;
	 }
	 
	
		
	 
	 /**
	  * 分页
	  * @param pageNow
	  * @return
	  */
	 public List<Product>limtPorduct(@Param("pageNow")Integer pageNow){
		 int cont=product.count();
		 Page page=null;
		 if(cont<pageNow){
			 pageNow=cont;
		 }
		 if(pageNow<=0){
			 pageNow=1;
		 }
		 
		 if(pageNow!=null){
			  page=new Page(cont,pageNow);
			  page.setPageSize(4);
			  return product.limProduct(page.getStartPos(), page.getPageSize());
		 }else{
			 page=new Page(cont,1);
			 page.setPageSize(4);
			 return product.limProduct(page.getStartPos(), page.getPageSize());
		 }
		 
		 
	 }
	    

}
