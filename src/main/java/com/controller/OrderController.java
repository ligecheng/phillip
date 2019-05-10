package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Order;
import com.entity.OrderDetail;
import com.entity.Result;
import com.entity.User;
import service.OrderDetailServiceImp;
import service.OrderServiceImp;
import com.util.DateUtil;
import com.util.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author his 订单信息,包含订单详情
 */

@Controller
@CrossOrigin
public class OrderController {

	@Autowired
	OrderServiceImp orderServiceImp; // 订单bean
	@Autowired
	OrderDetailServiceImp orderDetailServiceImp; // 订单详情bean

	/**
	 * 结算购物车中的商品
	 * 
	 * @param products
	 *            前端传递的json数据 --json数据要有商品id productId ,商品数量 eodCount,商品单价 eodPrice
	 * @param model
	 * @param request
	 *            用来获取session @RequestBody JSONObject products
	 * @return 进入结算成功页面
	 */
	@ResponseBody
	@RequestMapping(value = "/closing")
	public Result executeClosing(@RequestBody JSONObject products, HttpServletRequest request) {

		System.out.println("json" + JSONObject.fromObject(products));
		// 判断当前用户是否已经登录
		HttpSession session = request.getSession();// 获取session
		User currentUser = (User) session.getAttribute("user_info");// 获取当前存储在session中的用户
		// 当前并没有登录,不能进行结算商品操作
		 /*if (currentUser == null) {  
			 //404页面
			 return "";
			 }*/
		 

		List<OrderDetail> orderDetailList = paseJson(products);
		System.out.println(orderDetailList);
		// 产生订单
		Order newOrder = new Order(1, DateUtil.currentDate(), 0, getTotalPrice(orderDetailList));

		// 创建订单,返回该订单的订单号
		Integer orderId = orderServiceImp.insertSelective(newOrder);

		// 将主订单号注入到订单详情中
		if (orderId > 0) {
			for (int i = 0; i < orderDetailList.size(); i++) {
				orderDetailList.get(i).setEodEoId(orderId);
			}
		}
		// 批量创建订单详情
		boolean createState = orderDetailServiceImp.insertBatch(orderDetailList);
		Result result = new Result();
		if (createState) {
			System.out.println("创建订单详情成功!!");
			return result.setSuccess();
		}

		// 清除购物车中的商品
        
		
		
		return result.setError();
	}

	/**
	 * 解析json ,解析后存储到List集合中存储 OrderDetail
	 * 
	 * @param orderFormJsonData
	 * @return 结算的订单详情 集合,还未包含主订单id
	 */
	public List<OrderDetail> paseJson(JSONObject orderFormJsonData) {

		List<OrderDetail> orderDetailList = new ArrayList<>();

		JSONArray array = orderFormJsonData.getJSONArray("products");
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonItem = array.getJSONObject(i);

			int productId = Integer.parseInt(jsonItem.getString("productId"));
			int eodCount = Integer.parseInt(jsonItem.getString("eodCount"));
			double eodPrice = Double.valueOf(jsonItem.getString("eodPrice"));// 总价
			orderDetailList.add(new OrderDetail(productId, eodCount, eodPrice));
			System.out.println(new OrderDetail(productId, eodCount, eodPrice).toString());
		}
		return orderDetailList;

	}

	/**
	 * 计算订单的总价
	 * 
	 * @param orderDetailsList
	 *            订单详情
	 * @return 订单总价
	 */
	private Double getTotalPrice(List<OrderDetail> orderDetailsList) {
		Double price = 0.0;
		for (OrderDetail orderDetail : orderDetailsList) {
			price += orderDetail.getEodTotalPrice();
		}
		return price;
	}

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 * @return Result
	 */
	@ResponseBody
	@RequestMapping("/deleteOrder")
	public Result deleteOrder(String orderId, HttpServletRequest request) {

		System.out.println(orderId);
		Result requestResult = new Result();
		if (orderId != null) {
			boolean deleteState = orderServiceImp.deleteByPrimaryKey(Integer.valueOf(orderId));
			if (deleteState) {
				// 请求成功,删除该订单下的所有订单详情
				deleteState = deleteOrderDetailFormOrderId(Integer.valueOf(orderId));
				if (deleteState) {
					// 删除订单详情成功
					return requestResult.setSuccess();
				}
			}
		}
		// 请求失败
		return requestResult.setError();

	}

	/**
	 * 修改订单状态
	 * 
	 * @param orderId
	 * @return Result
	 */
	@ResponseBody
	@RequestMapping("/updateOrderState")
	public Result updateOrderState(String eoId, String eoStatus) {
		Result requestResult = new Result();
		System.out.println(eoId + eoStatus);
		// 传递的数据为空
		if (StringUtils.isNullOrEmpty(eoId) || StringUtils.isNullOrEmpty(eoStatus)) {
			return requestResult.setError();
		}
		Order order = new Order(Integer.valueOf(eoId), Integer.valueOf(eoStatus));
		System.out.println(order.toString());
		if (order != null) {
			boolean updateState = orderServiceImp.updateOrderState(order);
			if (updateState) {
				// 请求成功
				return requestResult.setSuccess();
			}
		}
		// 请求失败
		return requestResult.setError();

	}

	/**
	 * 
	 * 根据订单详情号 获取指定的订单详情,包含商品
	 * 
	 * @return OrderDetail 订单详情
	 */
	@ResponseBody
	@RequestMapping("/getOrderDetailByOne")
	public OrderDetail getOrderDetailByOne(String eodId) {
		System.out.println(eodId);
		// 订单id不为空,则进行查询操作
		if (!StringUtils.isNullOrEmpty(eodId)) {
			OrderDetail orderDetail = orderDetailServiceImp.selectByOneOrder(Integer.valueOf(eodId));
			System.out.println(orderDetail.toString());
			return orderDetail;
		}
		return null;

	}

	/**
	 * 
	 * 根据订单号 获取该订单信息
	 * 
	 * @param eodId 订单id
	 *            
	 * @return Order 订单
	 */
	@ResponseBody
	@RequestMapping("/getOrderByOne")
	public Order getOrderByOne(String eodId) {
		System.out.println(eodId);
		// 订单id不为空,则进行查询操作
		if (!StringUtils.isNullOrEmpty(eodId)) {
			Order order = orderServiceImp.selectOneOrderById(Integer.valueOf(eodId));
			System.out.println(order.toString());
			return order;
		}
		return null;

	}

	/**
	 * 
	 * 获取全部订单信息
	 * 
	 * @param eodId 订单id
	 *            
	 * @return List<Order> 全部的订单信息,包含订单详情以及订单中的商品
	 */
	@ResponseBody
	@RequestMapping("/getAllOrder")
	public List<Order> getAllOrder() {
         
		return orderServiceImp.getAllOrder();

	}

	/**
	 * 
	 * 根据用户名 获取订单
	 * 
	 * @param eoUserId  用户id
	 * @return OrderDetail
	 */
	@ResponseBody
	@RequestMapping("/getOrderFormUserId")
	public List<Order> getOrderFormUserId(String eoUserId) {
		System.out.println("根据用户id请求订单号,该用户id为:" + eoUserId);
		if (!StringUtils.isNullOrEmpty(eoUserId)) {
			return orderServiceImp.getOrderFormUserId(Integer.parseInt(eoUserId));
		}
		return null;

	}
	/**
	 * 删除指定订单的所有订单详情
	 * 
	 * @param eoId
	 *            订单id
	 * @return 删除结果,true--成功
	 */
	public boolean deleteOrderDetailFormOrderId(Integer eoId) {
		
		return orderDetailServiceImp.deleteOrderDetailFormOrderId(eoId);

	}

}
