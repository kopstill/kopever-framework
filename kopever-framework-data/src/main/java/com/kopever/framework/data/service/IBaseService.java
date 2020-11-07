package com.kopever.framework.data.service;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

interface IBaseService<T> {

    T selectOne(T t);

    List<T> select(T t);

    List<T> selectAll();

    List<T> selectByRowBounds(T t, RowBounds rowBounds);

    int delete(T t);

    int deleteByPrimaryKey(Object primaryKey);

    boolean existsWithPrimaryKey(Object primaryKey);

    int insert(T t);

    int insertSelective(T t);

    int selectCount(T t);

    T selectByPrimaryKey(Object primaryKey);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

}
