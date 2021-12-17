package com.house.price.task;

import com.house.price.common.DateUtil;
import com.house.price.common.RegionData;
import com.house.price.common.StaticValue;
import com.house.price.common.Utils;
import com.house.price.entity.CityEntity;
import com.house.price.entity.Matrix;
import com.house.price.entity.PriceInfo;
import com.house.price.service.ConfigDataService;
import com.house.price.service.HousePriceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TaskStater {

    private static final Log LOG = LogFactory.getLog(TaskStater.class);

    @Autowired
    HousePriceService housePriceService;

    @Autowired
    ConfigDataService configDataService;

    @PostConstruct
    @Async
    void startTask() {

        try {
            String executeDate = DateUtil.getYYYYMMDD();

            // 0、查询需要拉去数据地市
            List<CityEntity> finalCityList = configDataService.getProvAndCityConfig();
            LOG.info("「地市」finalCityList: " + finalCityList);

            // 1、查询区县房价信息
            for (CityEntity cityEntity : finalCityList) {
                String cityId = cityEntity.getId();
                List<PriceInfo> countryPriceInfoList = housePriceService.getCountyPriceList(cityEntity);
                if(countryPriceInfoList != null){
                    for (PriceInfo countryPriceInfoItem : countryPriceInfoList) {
                        countryPriceInfoItem.setExecuteDate(executeDate);
                        countryPriceInfoItem.setType(StaticValue.TYPE_COUNTRY);
                        LOG.info("「区县」" + countryPriceInfoItem.getName() + " - " + countryPriceInfoItem);
                    }
                    housePriceService.addPriceInfo(countryPriceInfoList);
                }

                // 2、查询街道房价
                for (PriceInfo countryPriceInfoItem : countryPriceInfoList) {
                    String countryId = countryPriceInfoItem.getId();
                    // 获取区县编码、最大最小经纬度
                    Matrix countryMatrix = Utils.getMaxBorder(countryPriceInfoItem);

                    List<PriceInfo> streetPriceInfoList = housePriceService.getStreetPriceList(cityId, countryId, countryMatrix);
                    if(streetPriceInfoList != null){
                        for (PriceInfo streetPriceInfoSubItem : streetPriceInfoList) {
                            streetPriceInfoSubItem.setExecuteDate(executeDate);
                            streetPriceInfoSubItem.setType(StaticValue.TYPE_STREET);
                            LOG.info("「街道」" + countryPriceInfoItem.getName() + " - " + streetPriceInfoSubItem.getName() + " - " + streetPriceInfoSubItem);
                        }
                        housePriceService.addPriceInfo(streetPriceInfoList);
                    }

                    // 3、查询社区房价
                    for (PriceInfo streetPriceInfoSubItem : streetPriceInfoList) {
                        Thread.sleep(1);

                        Matrix communityMatrix = Utils.getMaxBorder(streetPriceInfoSubItem);
                        List<PriceInfo> communityPriceInfoList = housePriceService.getCommunityPriceList(cityId, "","", communityMatrix);

                        if(communityPriceInfoList != null){
                            LOG.info("「小区」 " + countryPriceInfoItem.getName() + " - " + streetPriceInfoSubItem.getName() + " - 数量: " + communityPriceInfoList.size());
                            for (PriceInfo communityPriceInfoSubItem : communityPriceInfoList) {
                                communityPriceInfoSubItem.setExecuteDate(executeDate);
                                communityPriceInfoSubItem.setType(StaticValue.TYPE_COMMUNITY);
//                                LOG.info("「小区」" + communityPriceInfoSubItem.getName() + " - " + communityPriceInfoSubItem);

                            }
                            housePriceService.addPriceInfo(communityPriceInfoList);
                        }
                    }
                }
            }
        }catch (Exception exception){
            LOG.error(exception.getMessage(), exception);
        }

    }

}
