package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.mapperFaces.ProductMapper;

import service.ProducntSevice;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexContController {
	@Resource
	ProducntSevice mapping;
	@RequestMapping("/search")
	@ResponseBody
	public List<Product>getSearch(@Param("name")String name){
		System.out.println("++++"+name);
		List<Product>list=mapping.getSearch(name);
		for(Product p:list){
			System.out.println(p);
		}
		return list;
	}

}
