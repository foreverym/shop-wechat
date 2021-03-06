package com.wy.shop.mapper;

import com.wy.shop.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RegionMapper {

    public String findNameById(Integer id);

    public List<Region> findRegionListByPid(Integer pid);

}
