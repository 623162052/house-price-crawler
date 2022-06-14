package com.house.price.dao;

import com.house.price.entity.CityEntity;
import com.house.price.entity.PriceInfo;
import java.util.List;

/**
 * 房价统计
 */
public interface StatisticsDao {

    /**
     * 统计市、各区二手房挂盘数
     */
    List<PriceInfo> getHouseCount(CityEntity cityEntity) throws Exception;

}
