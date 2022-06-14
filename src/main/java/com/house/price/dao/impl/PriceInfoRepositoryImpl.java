package com.house.price.dao.impl;

import com.house.price.dao.PriceInfoRepository;
import com.house.price.entity.PriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceInfoRepositoryImpl implements PriceInfoRepository {

    private RowMapper<PriceInfo> rowMapper = BeanPropertyRowMapper.newInstance(PriceInfo.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Iterable<PriceInfo> findAll() {
        String sql = "select * from t_price_info";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<PriceInfo> findAll(String sql) {
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<PriceInfo> findAll(String sql, Object[] param) {
        return jdbcTemplate.query(sql, param, rowMapper);
    }

    @Override
    public PriceInfo findOne(String id) {
        return null;
    }

    @Override
    public PriceInfo save(PriceInfo Book) {
        return null;
    }

    @Override
    public boolean save(List<PriceInfo> Book) {
        return false;
    }
}
