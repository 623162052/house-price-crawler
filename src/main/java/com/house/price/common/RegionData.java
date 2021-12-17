package com.house.price.common;

import com.house.price.entity.Matrix;

import java.util.*;

/**
 * 地市、区县、街道、小区配置
 */
public class RegionData {

    /**
     * 需要爬取数据的省份、直辖市列表
     */
    public static final Set<String> provSet = new HashSet<>(
            Arrays.asList(
                    "江苏",
                    "上海"
            )
    );

    /**
     * 需要爬取数据的地市列表
     */
    public static final Set<String> citySet = new HashSet<>(
            Arrays.asList(
                    "320100",   // 南京
                    "310000"    // 上海
            )
    );

    /**
     * 地市、区县边界范围优先使用的数据
     */
    public static final Map<String, Matrix> cityMappingList = new HashMap() {{
        // 南京
        put("320100", new Matrix("320100", "32.306399256054924", "31.937478334965306", "119.16571969714943", "118.44017630285043"));
        // 江宁
        put("320115", new Matrix("320115", "31.960239071674057", "31.848168588372154", "118.92840397705706", "118.69484454446278"));

    }};


}
