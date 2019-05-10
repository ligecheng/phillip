package com.mapperFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer epId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer epId);
    List<Product>selectProduct(@Param("encId")Integer encId);//返回分类商品
    List<Product>getSearch(String search);//商品搜索功能
    
    List<Product>getProduct();//返回所有字段
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    int count();//获取总条数
    List<Product>limProduct(@Param("start")Integer start,@Param("end")Integer end);//分页查询
}