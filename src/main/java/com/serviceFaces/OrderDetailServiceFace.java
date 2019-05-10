package com.serviceFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.OrderDetail;

public interface OrderDetailServiceFace {
   
	//批量插入订单详情
	boolean  insertBatch (List<OrderDetail> orderDetailList);
	
	 /**
     * 获取单个订单详情,包含 商品对象
     * @param eodId
     * @return OrderDetail
     */
	OrderDetail selectByOneOrder(@Param("eodId") Integer eodId);
	
	OrderDetail selectByPrimaryKey(@Param("eodId") Integer eodId);
	
	/**
	 * 根据订单id获取订单
	 * @param eoId 订单id
	 * @return  List<OrderDetail> 订单详情集合
	 */
	List<OrderDetail> selectOrderDetailForEoId(@Param("eoId") Integer eoId);
	
	/**
  	 * 删除该订单id指定的所有订单详情
  	 * @param eoId 订单id
  	 * @return 是够成功删除,true --成功
  	 */
  	boolean deleteOrderDetailFormOrderId(Integer eoId);
	
}
