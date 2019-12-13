package com.seeshion.control.api;


import com.alibaba.fastjson.JSON;
import com.seeshion.bean.StatisticsOfCprOrders;
import com.seeshion.db.bean.CprOrderModel;
import com.seeshion.db.service.CprOrderService;
import com.seeshion.db.service.RequestTestService;
import com.seeshion.service.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/***
 * @Author ran
 */

@RestController
public class ReceiveController {
    private static Logger logger = LoggerFactory.getLogger(ReceiveController.class);

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private RequestTestService requestTestService;

    @Autowired
    private CprOrderService cprOrderService;

    @RequestMapping("/index")
    public String showServerStatus()
    {
//        RequestTestModel requestTestModel = new RequestTestModel();
//        requestTestModel.setData("test-spring");
//        requestTestModel.setDatetime(DateFormat.getTimeInstance());
//        requestTestModel.setInfo("test-spring-info");

//        smsSender.sendSms();
//        requestTestService.insertTestRequest();
//        HashMap<String, Object> statistics = cprOrderService.getOrdersOfPeriodTime(10,999999999999999L);


//        return JSON.toJSONString(statistics);


        return double2percent(0.039545);
    }

    public String double2percent(Double rate) {
        DecimalFormat df = new DecimalFormat("#.00");
        String ret = df.format(rate*100) + "%";
        return ret;
    }
}
