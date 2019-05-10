package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.ShoppingCart;
import com.serviceFaces.ShoppingCartService;

public class TestProduct {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		ShoppingCartService shop=app.getBean(ShoppingCartService.class);
		List<ShoppingCart>list=shop.displayUserShoppingCart(1);
		System.out.println("========"+list.size());
		for(ShoppingCart p:list){
			System.out.println("购物车"+p);
		}
	}

}
