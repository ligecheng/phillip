package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.entity.Product;
import service.SearchService;

@RestController
@CrossOrigin
public class SearchControllers {
	
	@Resource(name = "searchService")
	private SearchService searchService;
	
	@RequestMapping(value = "/searchService.do",method = RequestMethod.POST)
	@ResponseBody
	public List<Product> searchServer(@RequestBody JSONObject jObject,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println(jObject.get("keyWord"));
		return searchService.match(jObject.getString("keyWord"));
		
	}
}
