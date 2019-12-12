package com.seeshion.db.mapper;

import com.seeshion.db.bean.CprOrderModel;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/***
 * @Author:ran
 */
@Mapper
public interface CprOrderMapper {
    /***
     *  获取一段时间段内所有的执行的任务
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping
    @ResultType(com.seeshion.db.bean.CprOrderModel.class)
    @Select("Select * from vep_cpr_orders where created_at > #{startTime} and created_at < #{endTime}")
    public List<CprOrderModel> getOrdersOfPeriodTime(@Param("startTime") long startTime, @Param("endTime") long endTime);
}
