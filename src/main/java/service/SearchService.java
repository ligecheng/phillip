package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.mapperFaces.ProductMapper;
import com.util.Trie;

@Service
public class SearchService {
	
	@Resource(name = "dictService")
	private DictService dictService;
	
	@Resource(name = "productMapper")
	private ProductMapper productMapper;
	
	public List<Product> match(String keyWord){
		Trie dict = dictService.getDict();
		return dict.match(keyWord);
		
	}
	
}
