package com.seeshion.service.schedule;

import com.seeshion.bean.StatisticsOfCprOrders;
import com.seeshion.db.service.CprOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/****
 * @Author：ran
 */
@Component
@EnableScheduling
public class CheckRateOfRenderFail {
    @Autowired
    private CprOrderService cprOrderService;

    private static Logger logger = LoggerFactory.getLogger(CheckRateOfRenderFail.class);
    /****
     * 检查平台的总失败率
     */
    @Scheduled(cron = "*/60 * * * * ? ")
    public void checkPlatform() {
        logger.info("Start checking fail rate of platform...");
        StatisticsOfCprOrders statisticsOfCprOrders = cprOrderService.getOrdersOfPeriodTime(10,999999999999999L);
        if (statisticsOfCprOrders.getRateOfFailed() > 0.1) {

        }
    }

}
