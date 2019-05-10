package com.serviceFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order;

/**
 * 订单接口
 * @author his
 *
 */
public interface OrderServiceFace {

	 /**
     * 插入order 返回插入的自增id 
     * @return 插入的自增id 
     */
	
    Integer insertReKey(Order order);
    
    int insert(Order order);
	
    int insertSelective(Order order);
    
    //删除订单
    boolean  deleteByPrimaryKey(Integer eoId);
    
    /**
     * 修改订单状态
     * @param record
     * @return
     */
    boolean updateOrderState(Order record);
    
    /**
     * 获取 订单
     * @param eoId
     * @return
     */
    Order selectOneOrderById(@Param("eoId") Integer eoId);
    
    /**
     * 获取全部的订单 
     * @return List<Order>
     */
    List<Order> getAllOrder();
    
    /**
     * 根据用户id,获取订单
     * @param eoUserId 用户id
     * @return List<Order> 订单model 集合
     */
    List<Order> getOrderFormUserId(Integer eoUserId);
    
    
}
