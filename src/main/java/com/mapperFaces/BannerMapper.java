package com.mapperFaces;

import java.util.List;

import com.entity.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer ebId);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer ebId);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<Banner>getBanner();//获取所有的的banner数据
}