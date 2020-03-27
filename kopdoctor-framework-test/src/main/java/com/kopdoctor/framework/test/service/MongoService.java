package com.kopdoctor.framework.test.service;

import com.kopdoctor.framework.data.mongodb.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class MongoService<DemoMO, Long> extends CrudService<DemoMO, Long> {

}
