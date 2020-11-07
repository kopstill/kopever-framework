package com.kopever.framework.data.service;

import com.kopever.framework.data.mapper.IBaseMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T, M extends IBaseMapper<T>> implements IBaseService<T> {

    @Autowired
    protected M mapper;

    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    public List<T> select(T t) {
        return mapper.select(t);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return mapper.selectByRowBounds(t, rowBounds);
    }

    public int delete(T t) {
        return mapper.delete(t);
    }

    public int deleteByPrimaryKey(Object primaryKey) {
        return mapper.deleteByPrimaryKey(primaryKey);
    }

    public boolean existsWithPrimaryKey(Object primaryKey) {
        return mapper.existsWithPrimaryKey(primaryKey);
    }

    public int insert(T t) {
        return mapper.insert(t);
    }

    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    public T selectByPrimaryKey(Object primaryKey) {
        return mapper.selectByPrimaryKey(primaryKey);
    }

    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

}
