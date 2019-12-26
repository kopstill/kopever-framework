package com.kopdoctor.framework.data.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class BaseService<T, M extends BaseMapper<T>> extends ServiceImpl<M, T> {

}
