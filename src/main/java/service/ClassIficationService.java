package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ProductCategories;
import com.mapperFaces.ProductCategoriesMapper;
@Service
public class ClassIficationService implements ProductCategoriesMapper{
	@Resource
     ProductCategoriesMapper productCategorismapper;
	@Override
	public int deleteByPrimaryKey(Integer epcId) {
		
		return productCategorismapper.deleteByPrimaryKey(epcId);
	}
    
	/**
	 * 返回添加的商品分类id
	 */
	@Override
	public int insert(ProductCategories record) {
		int result = productCategorismapper.insert(record);
		if(result > 0) {
			return record.getEpcId();
		}
		return 0;
	}

	@Override
	public int insertSelective(ProductCategories record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductCategories selectByPrimaryKey(Integer epcId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ProductCategories record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ProductCategories record) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 *获取二级分类
	 */

	@Override
	public List<ProductCategories> allList() {
		// TODO Auto-generated method stub
		return productCategorismapper.allList();
	}
	
	
	

}
