package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ShoppingCart;
import com.mapperFaces.ShoppingCartMapper;

@Service
public class ShoppingCartService {
	@Resource(name = "shoppingCartMapper")
	private ShoppingCartMapper shoppingCartMapper = null;
	
	public List<ShoppingCart> displayUserShoppingCart(Integer userId){
		List<ShoppingCart> products = shoppingCartMapper.selectByUserPrimaryKey(userId);
		System.out.println("Servict购物车"+products.size());
		for(ShoppingCart p :products){
			System.out.println("Servicts购物车"+p);
		}
		return products == null ? null : products;
	}
	
	public Integer deleteProducts(Integer enId,Integer esId) {
		return shoppingCartMapper.deleteByPrimaryKey(enId, esId);
	}
	
	public Integer deleteFullProduct(Integer enId) {
		return shoppingCartMapper.deleteByUserAllProductByPrimaryKey(enId);
	}
	
	public Integer updateByPrimaryKeySelective(ShoppingCart cart) {
		return shoppingCartMapper.updateByPrimaryKeySelective(cart);
	}
	public Integer insert(ShoppingCart record) {
		return shoppingCartMapper.insert(record);
	}
	
}
