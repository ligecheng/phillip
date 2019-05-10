package com.mapperFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order;

/**
 * 订单 dao层
 * @author his
 *
 */
public interface OrderMapper {
    int deleteByPrimaryKey(@Param("eoId")Integer eoId);
    
    int insert(Order record);
    
    int insertSelective(Order record);
    
    
    /**
     * 插入order 返回插入的自增id 
     * @return 插入的自增id 
     */
    Integer insertReKey();
    
    Order selectByPrimaryKey(@Param("eoId") Integer eoId);
    
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    /**
     * 修改订单状态
     * @param record
     * @return
     */
    int updateOrderState(Order record);
    
    /**
     * 获取所有的订单
     * @return  List<Order> 
     */
    List<Order> getAllOrder();
    
    /**
     * 根据用户id,获取订单
     * @param eoUserId 用户id
     * @return List<Order> 订单model 集合
     */
    List<Order> getOrderFormUserId(@Param("eoUserId") Integer eoUserId);
    
    
    
}