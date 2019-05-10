package com.mapperFaces;

import java.util.List;

import com.entity.ProductCategories;

public interface ProductCategoriesMapper {
    int deleteByPrimaryKey(Integer epcId);

    int insert(ProductCategories record);

    int insertSelective(ProductCategories record);

    ProductCategories selectByPrimaryKey(Integer epcId);
    
    int updateByPrimaryKeySelective(ProductCategories record);

    int updateByPrimaryKey(ProductCategories record);
    //查询二级目录
    List<ProductCategories>allList();
}