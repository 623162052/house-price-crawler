package com.house.price.dao.impl;

import com.house.price.dao.PriceInfoRepository;
import com.house.price.dao.StatisticsDao;
import com.house.price.entity.CityEntity;
import com.house.price.entity.PriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 房价统计
 */
@Repository
public class StatisticsDaoImpl implements StatisticsDao {


    @Autowired
    PriceInfoRepository priceInfoRepository;


    /**
     * 统计市、各区二手房挂盘数
     */
    @Override
    public List<PriceInfo> getHouseCount(CityEntity cityEntity) throws Exception {
        String cityId = cityEntity.getId();
        String sql = "SELECT * FROM t_price_info WHERE price_type = 2 and pid = ? AND execute_date = " +
                "(SELECT MAX(i.execute_date) FROM t_price_info i WHERE i.price_type = 2 and pid = ?)";
        Object param[] = {cityId, cityId};
        List<PriceInfo> priceInfoList = priceInfoRepository.findAll(sql, param);
        return priceInfoList;
    }

}
