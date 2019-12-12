package com.seeshion.service.sms;

import com.alibaba.fastjson.JSON;
import com.seeshion.config.ChuangLanSmsConfig;
import com.seeshion.service.sms.model.ChuangLanSmsUtil;
import com.seeshion.service.sms.model.request.SmsSendRequest;
import com.seeshion.service.sms.model.response.SmsSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsSender {
    private static Logger logger = LoggerFactory.getLogger(SmsSender.class);

    @Autowired
    private ChuangLanSmsConfig chuangLanSmsConfig;

    public void sendSms() {
        String msg = "【ve】您好，您的验证码是 1234 ,5分钟内有效。如非本人操作请忽略此短信。";
        if (chuangLanSmsConfig == null)
        {
            return ;
        }
        SmsSendRequest smsSingleRequest = new SmsSendRequest(
                chuangLanSmsConfig.getAccount(),
                chuangLanSmsConfig.getPassword(),
                msg,
                "17602114904"
        );


        System.out.println(chuangLanSmsConfig.getAccount());
        System.out.println(chuangLanSmsConfig.getPassword());

        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }

}
