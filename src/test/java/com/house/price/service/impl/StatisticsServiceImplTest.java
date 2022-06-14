package com.house.price.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.house.price.common.RegionData;
import com.house.price.entity.CityEntity;
import com.house.price.entity.PriceInfo;
import com.house.price.service.ConfigDataService;
import com.house.price.service.StatisticsService;
import com.house.price.web.StatisticsController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StatisticsServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(StatisticsController.class);


    @Autowired
    StatisticsService statisticsService;

    /**
     * 测试
     * @throws Exception
     */
    @Test
    void testGetCountyPriceList() throws Exception {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("320100");
        cityEntity.setName("南京");
//        cityEntity.setId("310000");
//        cityEntity.setName("上海");
        JSONObject jsonObject = statisticsService.getHouseCount(cityEntity);
        LOG.info("jsonObject: " + jsonObject);
    }


}
