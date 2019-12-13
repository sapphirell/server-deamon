package com.seeshion.db.service;

import com.seeshion.bean.StatisticsOfCprOrders;
import com.seeshion.bean.StatisticsOfUsers;
import com.seeshion.db.bean.CprOrderModel;
import com.seeshion.db.mapper.CprOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * @Author:ran
 */
@Service
public class CprOrderService {

    private static Logger logger = LoggerFactory.getLogger(CprOrderService.class);

    @Autowired
    private CprOrderMapper cprOrderMapper;

    /***
     * 获取一段时间执行过的任务，并计算出总数、成功率、等待数
     * hashMap
     *  -user 用户的统计数据
     *  -platform
     * @param startTime
     * @param endTime
     * @return
     */
    public HashMap<String, Object> getOrdersOfPeriodTime(long startTime, long endTime) {
        HashMap<String, Object> ret = new HashMap<String, Object>();
        StatisticsOfCprOrders statisticsOfCprOrders = new StatisticsOfCprOrders();
        HashMap<String, StatisticsOfUsers> statisticsOfUsersHashMap = new HashMap<String, StatisticsOfUsers>();
        List<CprOrderModel> cprOrderModelList = cprOrderMapper.getOrdersOfPeriodTime(startTime, endTime);

        if (cprOrderModelList != null && cprOrderModelList.size() > 0) {
            for (CprOrderModel cprOrderModel : cprOrderModelList) {
                StatisticsOfUsers statisticsOfUsers = statisticsOfUsersHashMap.get(cprOrderModel.getUid());
                if (statisticsOfUsers == null) {
                    statisticsOfUsers = new StatisticsOfUsers();
                }
                //记录统计任务的状态
                statisticsOfCprOrders.addTotalTask();
                statisticsOfUsers.addTotalTask();
                statisticsOfUsers.setUid(cprOrderModel.getUid());
                if (cprOrderModel.getStatus() == 0) {
                    statisticsOfCprOrders.addSpendingTask();
                    statisticsOfUsers.addSpendingTask();
                }
                if (cprOrderModel.getStatus() == 1) {
                    statisticsOfCprOrders.addSuccessTask();
                    statisticsOfUsers.addSuccessTask();
                    //记录渲染时间（如果成功）
                    statisticsOfCprOrders.setLongestCostTime(cprOrderModel.getCostTime());
                    statisticsOfCprOrders.setShortestCostTime(cprOrderModel.getCostTime());
                    statisticsOfCprOrders.addTotalCostTime(cprOrderModel.getCostTime());
                    //user
                    statisticsOfUsers.setLongestCostTime(cprOrderModel.getCostTime());
                    statisticsOfUsers.setShortestCostTime(cprOrderModel.getCostTime());
                    statisticsOfUsers.addTotalCostTime(cprOrderModel.getCostTime());
                }
                if (cprOrderModel.getStatus() > 1) {
                    statisticsOfCprOrders.addFailedTask();
                    statisticsOfUsers.addFailedTask();
                }

                statisticsOfUsersHashMap.put(cprOrderModel.getUid(), statisticsOfUsers);
            }
        }

        ret.put("platform", statisticsOfCprOrders);
        ret.put("user", statisticsOfUsersHashMap);

        return ret;
    }
}
