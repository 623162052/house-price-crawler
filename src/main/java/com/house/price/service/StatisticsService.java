package com.house.price.service;

import com.alibaba.fastjson.JSONObject;
import com.house.price.entity.CityEntity;


/**
 * 房价统计
 */
public interface StatisticsService {

    /**
     * 统计市、各区二手房挂盘数
     */
    JSONObject getHouseCount(CityEntity cityEntity) throws Exception;

}
