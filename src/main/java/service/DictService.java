package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.mapperFaces.ProductMapper;
import com.util.Trie;

@Service
public class DictService {
	
	
	@Resource(name = "productMapper")
	private ProductMapper productMapper;
	


	public Trie getDict() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Trie dict = context.getBean("dict",Trie.class);
		List<Product> pList = productMapper.getProduct();
		for(Product product : pList) {
			dict.push(product.getEpName(), product);
		}
		return dict == null ? null : dict;
	}
}
