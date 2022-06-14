package com.house.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.house.price.dao.PriceInfoDao;
import com.house.price.dao.StatisticsDao;
import com.house.price.entity.CityEntity;
import com.house.price.entity.PriceInfo;
import com.house.price.service.StatisticsService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房价统计
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsDao statisticsDao;

    /**
     * 统计市、各区二手房挂盘数
     */
    @Override
    public JSONObject getHouseCount(CityEntity cityEntity) throws Exception {
        List<PriceInfo> priceInfoList = statisticsDao.getHouseCount(cityEntity);

        JSONObject jsonObject = new JSONObject();
        int allCount = 0;
        String executeDate = "";
        if (CollectionUtils.isNotEmpty(priceInfoList)) {
            for (PriceInfo priceInfoItem : priceInfoList) {
                jsonObject.put(priceInfoItem.getName(), priceInfoItem.getCount());
                allCount += Integer.valueOf(priceInfoItem.getCount());
                if(StringUtils.isEmpty(executeDate)){
                    executeDate = priceInfoItem.getExecuteDate();
                }
            }
        }
        jsonObject.put(cityEntity.getName(), allCount);
        jsonObject.put("date", executeDate);
        return jsonObject;
    }


}
