package com.kopever.framework.test.service;

import com.kopever.framework.data.service.BaseService;
import com.kopever.framework.test.dao.DemoMapper;
import com.kopever.framework.test.domain.data.Demo;
import org.springframework.stereotype.Service;

@Service
public class DemoService extends BaseService<Demo, DemoMapper> {

}
