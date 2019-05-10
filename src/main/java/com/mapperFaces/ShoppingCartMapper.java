package com.mapperFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(@Param("enId")Integer enId,@Param("esId")Integer esId);
    
    int deleteByUserAllProductByPrimaryKey(@Param("enId")Integer enId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByUserPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    
    
}