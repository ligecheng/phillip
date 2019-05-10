package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Order;
import com.mapperFaces.OrderMapper;
import com.serviceFaces.OrderServiceFace;

@Service("OrderServiceImp")
public class OrderServiceImp implements OrderServiceFace {

	@Resource
	OrderMapper orderMapping;
	/**
	 * 插入订单,返回插入订单的自增id 提示: 如果插入不成功,则返回
	 */
	@Override
	public Integer insertReKey(Order order) {

		Integer orderId = orderMapping.insertReKey();
		if (orderId <= 0) {
			return 0;
		}
		return orderId;
	}

	@Override
	public int insert(Order order) {
		int state = orderMapping.insert(order);
		return state;
	}

	/**
	 * 插入订单,返回订单的id
	 */
	@Override
	public int insertSelective(Order order) {
		int state = orderMapping.insertSelective(order);
		int orderId = order.getEoId();

		return orderId;
	}

	/**
	 * 删除订单
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer eoId) {
		int state = orderMapping.deleteByPrimaryKey(eoId);
		if (state > 0) {
			System.out.println("订单删除成功!!");
			return true;
		}
		return false;
	}

	/**
	 * 修改订单状态
	 */
	@Override
	public boolean updateOrderState(Order record) {

		int state = orderMapping.updateOrderState(record);
		if (state > 0) {
			System.out.println("订单状态修改成功!!");
			return true;
		}
		return false;
	}

	/**
	 * 根据id 查询单个订单
	 */
	@Override
	public Order selectOneOrderById(Integer eoId) {
		if (eoId <= 0) {
			return null;
		}
		Order order = orderMapping.selectByPrimaryKey(eoId);
		return order;
	}
    
	@Override
	public List<Order> getAllOrder() {

		return orderMapping.getAllOrder();
	}

	@Override
	public List<Order> getOrderFormUserId(Integer eoUserId) {
		if (eoUserId <= 0) {
			return null;
		}
		return orderMapping.getOrderFormUserId(eoUserId);
	}

}
