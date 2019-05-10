package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Banner;
import com.mapperFaces.BannerMapper;
@Service
public class BannerSverice implements BannerMapper{
	
    @Resource
    BannerMapper banner;
	@Override
	public int deleteByPrimaryKey(Integer ebId) {
		// TODO Auto-generated method stub
		return banner.deleteByPrimaryKey(ebId);
	}

	@Override
	public int insert(Banner record) {
		// TODO Auto-generated method stub
		return banner.insert(record);
	}

	@Override
	public int insertSelective(Banner record) {
		// TODO Auto-generated method stub
		return banner.insertSelective(record);
	}

	@Override
	public Banner selectByPrimaryKey(Integer ebId) {
		// TODO Auto-generated method stub
		return banner.selectByPrimaryKey(ebId);
	}

	@Override
	public int updateByPrimaryKeySelective(Banner record) {
		// TODO Auto-generated method stub
		return banner.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Banner record) {
		// TODO Auto-generated method stub
		return banner.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Banner record) {
		// TODO Auto-generated method stub
		return banner.updateByPrimaryKey(record);
	}
    /**
     * 获取全部banner的数据
     */
	@Override
	public List<Banner> getBanner() {
		// TODO Auto-generated method stub
		return banner.getBanner();
	}

}
