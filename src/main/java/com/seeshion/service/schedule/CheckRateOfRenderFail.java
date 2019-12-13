package com.seeshion.service.schedule;

import com.seeshion.bean.StatisticsOfCprOrders;
import com.seeshion.bean.StatisticsOfUsers;
import com.seeshion.config.PlatformConfig;
import com.seeshion.db.service.CprOrderService;
import com.seeshion.service.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;


/****
 * @Author：ran
 */
@Component
@EnableScheduling
public class CheckRateOfRenderFail {
    @Autowired
    private CprOrderService cprOrderService;

    @Autowired
    private PlatformConfig platformConfig;

    @Autowired
    private SmsSender smsSender;

    private static Logger logger = LoggerFactory.getLogger(CheckRateOfRenderFail.class);

    /****
     * 检查平台的总失败率
     */
    @Scheduled(cron = "*/15 * * * * ? ")
    public void checkPlatform() {
        logger.info("Start checking fail rate of platform...");
        HashMap<String, Object> statistics = cprOrderService.getOrdersOfPeriodTime(10, 999999999999999L);
        StatisticsOfCprOrders statisticsOfCprOrders = (StatisticsOfCprOrders) statistics.get("platform");
        //如果平台的整体失败率或等待率高于阈值
        if (statisticsOfCprOrders.getRateOfFailed() > Double.valueOf(platformConfig.getFailedAlarmThreshold()) || statisticsOfCprOrders.getRateOfSpending() > Double.valueOf(platformConfig.getSpendingAlarmThreshold()))
        {
            logger.info("Total failure or spending rate of platform task is higher than the threshold !");
            //平台监控的{s8}率超过阈值，其中监控时间段内任务总数为{s10}，失败率为{s4}，等待率为{s4}
            String rateOfFailed = this.double2percent(statisticsOfCprOrders.getRateOfFailed());
            String rateOfSpending = this.double2percent(statisticsOfCprOrders.getRateOfSpending());

            String smsMessage = smsSender.getMessageOfPlatformTemplate(statisticsOfCprOrders.getTotalTask(), rateOfFailed, rateOfSpending);
            logger.info(smsMessage);
//            smsSender.sendSms(smsMessage);
        }
        //检查用户
        HashMap<String, StatisticsOfUsers> statisticsOfUsersHashMap = (HashMap<String, StatisticsOfUsers>) statistics.get("user");
         if (statisticsOfUsersHashMap != null && statisticsOfUsersHashMap.size() > 0) {
            for (StatisticsOfUsers statisticsOfUsers : statisticsOfUsersHashMap.values()) {
                if (statisticsOfUsers.getRateOfFailed() > Double.valueOf(platformConfig.getFailedAlarmThreshold()) || statisticsOfUsers.getRateOfSpending() > Double.valueOf(platformConfig.getSpendingAlarmThreshold()))
                {
                    logger.info("Total failure or spending rate of user `" + statisticsOfUsers.getUid() + "` task is higher than the threshold !");
                    String rateOfFailed = this.double2percent(statisticsOfUsers.getRateOfFailed());
                    String rateOfSpending = this.double2percent(statisticsOfUsers.getRateOfSpending());
                    String userName = statisticsOfUsers.getUid();
                    String smsMessage = smsSender.getMessageOfUserTemplate(userName, statisticsOfUsers.getTotalTask(), rateOfFailed, rateOfSpending);

                    logger.info(smsMessage);
//                    smsSender.sendSms(smsMessage);
                }

            }
        }

        logger.info("End of checking fail rate");
    }

    /***
     *
     * @param rate
     * @return sample : 3.9%
     */
    public String double2percent(Double rate) {
        DecimalFormat df = new DecimalFormat("#.0");
        String ret = df.format(rate * 100) + "%";
        return ret;
    }
}
