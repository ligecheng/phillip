package service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.entity.OrderDetail;
import com.mapperFaces.OrderDetailMapper;
import com.serviceFaces.OrderDetailServiceFace;

/**
 * 订单详情实现
 * 
 * @author his
 *
 */
@Service
public class OrderDetailServiceImp implements OrderDetailServiceFace {

	@Resource
	OrderDetailMapper orderDetailMapper;

	/**
	 * 批量插入,插入成功则返回 true
	 */
	@Override
	public boolean insertBatch(List<OrderDetail> orderDetailList) {

		int state = orderDetailMapper.insertBatch(orderDetailList);
		if (state > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 查询单个的订单详情
	 */

	@Override
	public OrderDetail selectByOneOrder(Integer eodId) {

		System.out.println(eodId);
		OrderDetail orderDetail = orderDetailMapper.selectByOneOrder(eodId);

		return orderDetail;
	}

	@Override
	public OrderDetail selectByPrimaryKey(Integer eodId) {
		System.out.println(eodId);
		OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(eodId);

		return orderDetail;
	}

	@Override
	public List<OrderDetail> selectOrderDetailForEoId(Integer eoId) {

		return null;
	}

	@Override
	public boolean deleteOrderDetailFormOrderId(Integer eoId) {
        if(eoId <= 0) {
        	System.out.println("订单id不合理!!");	
        	return false;
        }
		
		Integer delState = orderDetailMapper.deleteOrderDetailFormOrderId(eoId);

		if (delState <= 0) {
			System.out.println("根据订单id删除所有的订单详情  失败!!!!");
			return false;
		}
		System.out.println("订单详情删除成功");	
		return true;

	}

}
