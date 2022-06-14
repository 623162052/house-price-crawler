package com.house.price.dao;

import com.house.price.entity.PriceInfo;

import java.util.List;

public interface PriceInfoRepository {

    Iterable<PriceInfo> findAll();

    List<PriceInfo> findAll(String sql);

    List<PriceInfo> findAll(String sql, Object[] param);

    PriceInfo findOne(String id);

    PriceInfo save(PriceInfo Book);

    boolean save(List<PriceInfo> Book);

}
