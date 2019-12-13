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

    /****
     * 【ve】平台监控的{s8}率超过阈值，其中监控时间段内任务总数为{s10}，失败率为{s6}，等待率为{s6}
     * @return
     */
    public String getMessageOfPlatformTemplate(int totalTaskNum, String rateOfFailed, String rateOfSpending) {
        return "【ve】平台监控的失败率或等待率超过阈值，其中监控时间段内任务总数为" + totalTaskNum + "，失败率为" + rateOfFailed + "，等待率为" + rateOfSpending + "。";
    }

    /****
     * 用户{s10}的任务异常，监控时段内其任务总数{s8},失败率{s6},等待率{s6}。
     * @return
     */
    public String getMessageOfUserTemplate(String userName, int totalTaskNum, String rateOfFailed, String rateOfSpending) {
        return "【ve】用户" + userName + "的任务异常，监控时段内其任务总数" + totalTaskNum + ",失败率" + rateOfFailed + ",等待率" + rateOfSpending + "。";
    }

    public void sendSms(String msg) {
        if (chuangLanSmsConfig == null) {
            return;
        }
        SmsSendRequest smsSingleRequest = new SmsSendRequest(
                chuangLanSmsConfig.getAccount(),
                chuangLanSmsConfig.getPassword(),
                msg,
                chuangLanSmsConfig.getWarningTelPhone()
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
