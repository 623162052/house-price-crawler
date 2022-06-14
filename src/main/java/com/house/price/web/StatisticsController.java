package com.house.price.web;

import com.alibaba.fastjson.JSONObject;
import com.house.price.entity.CityEntity;
import com.house.price.service.StatisticsService;
import com.house.price.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private static final Logger LOG = LoggerFactory.getLogger(StatisticsController.class);


    @Autowired
    StatisticsService statisticsService;

    /**
     * 请求城市房价汇总信息
     */
    @ResponseBody
    @GetMapping("/getStatisticsInfo")
    public Map<String, Object> getStatisticsInfo(Map<String, Object> params) throws Exception {
        LOG.info("access requestService");
        Map<String, Object> response = new HashMap<>();
//        RequestInfo requestInfo = new RequestInfo();
//        try {
//            BeanUtils.populate(requestInfo,params);
//        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
//        }
        try {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setId("320100");
            cityEntity.setName("南京");
            JSONObject jsonObject = statisticsService.getHouseCount(cityEntity);
            response.put("busi", "查询地市、区县二手房挂牌量");
            response.put("cityId", cityEntity.getId());

            response.put(WebUtil.RESULT_VAL, WebUtil.SUCCESS);
            response.put(WebUtil.RESULT_MSG, jsonObject);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            response.put(WebUtil.RESULT_VAL, WebUtil.FAIL);
            response.put(WebUtil.RESULT_MSG, WebUtil.DEFAULT_ERROR_MSG);
        }
        return response;
    }

}
