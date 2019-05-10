package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.mapperFaces.ProductMapper;
@Service
public class ProducntSevice implements ProductMapper{
	@Resource
	ProductMapper mapper;

	@Override
	public int deleteByPrimaryKey(Integer epId) {
		
		return mapper.deleteByPrimaryKey(epId);
	}
    
	/**
	 * 返回插入的商品ID
	 */
	@Override
	public int insert(Product record) {
		Integer result = mapper.insert(record);
		if(result > 0) {
			return record.getEpId();
		}
		return 0;
	}

	@Override
	public int insertSelective(Product record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public Product selectByPrimaryKey(Integer epId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(epId);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Product record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Product record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Product> selectProduct(Integer encId) {
		// TODO Auto-generated method stub
		return mapper.selectProduct(encId);
	}
    
	/**
	 * 模糊搜索
	 */
	@Override
	public List<Product> getSearch(String search) {
		// TODO Auto-generated method stub
		return mapper.getSearch(search);
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return mapper.getProduct();
	}
	
    /**
     * 获取总条数
     */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return mapper.count();
	}
     /**
      * 分页
      */
	@Override
	public List<Product> limProduct(Integer start, Integer end) {
		// TODO Auto-generated method stub
		
		return mapper.limProduct(start, end);
	}

}
