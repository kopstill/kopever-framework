package com.kopdoctor.framework.test.service;

import com.kopdoctor.framework.data.service.BaseService;
import com.kopdoctor.framework.test.dao.DemoMapper;
import com.kopdoctor.framework.test.domain.data.Demo;
import org.springframework.stereotype.Service;

@Service
public class DemoService extends BaseService<Demo, DemoMapper> {

}
