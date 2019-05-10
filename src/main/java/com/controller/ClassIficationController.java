package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.entity.ProductCategories;

import service.ClassIficationService;
import service.ProducntSevice;

@RestController
/**
 * 分类模块
 * @author jokerTank
 *
 */
@CrossOrigin
@RequestMapping("/classCte")
public class ClassIficationController {
	@Resource
	ClassIficationService classi;//商品分类
	@Resource
	ProducntSevice product;//商品
	/**
	 * 查询二级目录
	 * 返回参数 
	 * 分类列表
	 */
	
	@RequestMapping("/getClass")
	@ResponseBody
	public List<ProductCategories>list(){
	     List<ProductCategories>getlist=classi.allList();
	     for(ProductCategories i:getlist){
	    	 System.out.println("-----------"+i);
	     }	
		return getlist;
	}
	/**
	 * 返回分类商品
	 * @param epcId
	 * @return
	 */
	@RequestMapping("/keySelectProduct")
	@ResponseBody
	public List<Product>getProduct(@Param("epcId")Integer epcId){
		System.out.println(epcId);
		List<Product>allProduct=product.selectProduct(epcId);
	        System.out.println(epcId);
		for(Product p:allProduct){
			System.out.println("=========="+p);
		}
		System.out.println("成功");
		return allProduct;
	}
	
	
	/**
	/**
	 * 后台管理
	 */
	/**删除分类
	 * 
	 * @param epcId
	 * @return 0删除失败 1删除成功
	 */
	@RequestMapping("/deleteClass")
	@ResponseBody
	public Integer deleteClass(@Param("epcId")int epcId){
		 int i=classi.deleteByPrimaryKey(epcId);
		return i;
	}
	/**
	 * 添加商品分类
	 * @param add
	 * @return
	 */
	@RequestMapping("/addClass")
	@ResponseBody
    public Integer addClass(ProductCategories add){
    	int i=classi.insert(add);
         
    	return i;
    }
	
	/**
	 * 修改商品分类名称
	 * @param model
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public Integer updata(ProductCategories model){
		int i=classi.updateByPrimaryKey(model);
		return i;
	}
}
