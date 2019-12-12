package com.seeshion.db.service;

import com.seeshion.bean.StatisticsOfCprOrders;
import com.seeshion.db.bean.CprOrderModel;
import com.seeshion.db.mapper.CprOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Author:ran
 */
@Service
public class CprOrderService {

    @Autowired
    private CprOrderMapper cprOrderMapper;

    /***
     * 获取一段时间执行过的任务，并计算出总数、成功率、等待数
     * @param startTime
     * @param endTime
     * @return
     */
    public StatisticsOfCprOrders getOrdersOfPeriodTime(long startTime, long endTime) {
        StatisticsOfCprOrders statisticsOfCprOrders = new StatisticsOfCprOrders();

        List<CprOrderModel> cprOrderModelList = cprOrderMapper.getOrdersOfPeriodTime(startTime, endTime);
        if (cprOrderModelList != null && cprOrderModelList.size() > 0)
        {
            System.out.println("getListLen:" + cprOrderModelList.size());
            for (CprOrderModel cprOrderModel : cprOrderModelList) {
                //记录统计任务的状态
                statisticsOfCprOrders.addTotalTask();
                if (cprOrderModel.getStatus() == 0){
                    statisticsOfCprOrders.addSpendingTask();
                }
                if (cprOrderModel.getStatus() == 1) {
                    statisticsOfCprOrders.addSuccessTask();
                    //记录渲染时间（如果成功）
                    statisticsOfCprOrders.setLongestCostTime(cprOrderModel.getCostTime());
                    statisticsOfCprOrders.setShortestCostTime(cprOrderModel.getCostTime());
                    statisticsOfCprOrders.addTotalCostTime(cprOrderModel.getCostTime());
                }
                if (cprOrderModel.getStatus() > 1) {
                    statisticsOfCprOrders.addFailedTask();
                }

            }
        }

        return statisticsOfCprOrders;
    }
}
