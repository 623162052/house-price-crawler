package com.house.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.price.common.RegionData;
import com.house.price.common.URLAddress;
import com.house.price.entity.*;
import com.house.price.service.ConfigDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * 配置数据服务
 */
@Service
public class ConfigDataServiceImpl implements ConfigDataService {

    private static final Log LOG = LogFactory.getLog(ConfigDataServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取省份、地市配置数据
     * @throws Exception
     */
    @Override
    public List<CityEntity> getProvAndCityConfig() throws Exception {

        String url = URLAddress.PROV_CITY_CONFIG_URL;
        url += "?type={type}";
        url += "&category={category}";

        Map<String, Object> param = new HashMap<>();
        param.put("type", "province");
        param.put("category", 1);

        List<CityEntity> finalCityList = new ArrayList<>();
        ResponseEntity<CommonResponse> provCityData = restTemplate.getForEntity(url, CommonResponse.class, param);
        if(provCityData != null){
            CommonResponse commonResponse = provCityData.getBody();
            Map<String, HashMap> configMap = (HashMap) commonResponse.getData();
            LOG.info("configMap: " + configMap);

            // 遍历省份
            for (Map.Entry<String, HashMap> provEntry : configMap.entrySet()) {

                if(!RegionData.provSet.contains(provEntry.getKey())){
                    continue;
                }

                HashMap<String, HashMap> cityMapList = provEntry.getValue();

                // 地市遍历
                for (Map.Entry<String, HashMap> cityEntry : cityMapList.entrySet()) {

                    if(!RegionData.citySet.contains(cityEntry.getKey())){
                        continue;
                    }
                    HashMap cityInfoMap = cityEntry.getValue();
                    CityEntity cityEntity = JSON.parseObject(JSON.toJSONString(cityInfoMap), CityEntity.class);
                    finalCityList.add(cityEntity);
                }
            }
        }

        return finalCityList;
    }

}

