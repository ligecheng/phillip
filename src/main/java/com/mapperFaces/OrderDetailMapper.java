package com.mapperFaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(@Param("eodId") Integer eodId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);
    
    /**
     * 获取单个订单详情,包含 商品对象
     * @param eodId
     * @return OrderDetail
     */
    OrderDetail selectByOneOrder(@Param("eodId") Integer eodId);

    OrderDetail selectByPrimaryKey(@Param("eodId")  Integer eodId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
   //批量插入订单详情
  	int  insertBatch (List<OrderDetail> orderDetailList);
  	
  	/**
  	 * 删除该订单id指定的所有订单详情
  	 * @param eoId 订单id
  	 * @return 删除结果 
  	 */
  	Integer deleteOrderDetailFormOrderId(@Param("eodEoId") Integer eoId);
}