package com.seeshion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/***
 * @Author:ran
 */
@Configuration
public class PlatformConfig {
    /**
     * 等待渲染的任务报警比例
     */
    @Value("${deamon.alarm-threshold.spending}")
    private String spendingAlarmThreshold;

    @Value("${deamon.alarm-threshold.failed}")
    private String failedAlarmThreshold;

    @Value("${deamon.alarm-threshold.total-cost-time}")
    private String totalCostTimeAlarmThreshold;

    public String getSpendingAlarmThreshold() {
        return spendingAlarmThreshold;
    }

    public void setSpendingAlarmThreshold(String spendingAlarmThreshold) {
        this.spendingAlarmThreshold = spendingAlarmThreshold;
    }

    public String getFailedAlarmThreshold() {
        return failedAlarmThreshold;
    }

    public void setFailedAlarmThreshold(String failedAlarmThreshold) {
        this.failedAlarmThreshold = failedAlarmThreshold;
    }

    public String getTotalCostTimeAlarmThreshold() {
        return totalCostTimeAlarmThreshold;
    }

    public void setTotalCostTimeAlarmThreshold(String totalCostTimeAlarmThreshold) {
        this.totalCostTimeAlarmThreshold = totalCostTimeAlarmThreshold;
    }
}
