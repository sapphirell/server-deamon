package com.seeshion.db.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

/***
 * @Author:ran
 */


@Mapper
public interface RequestTestMapper {
    /****
     *
     * @param data
     * @param datetime
     * @param info
     */
    @Insert("Insert into vep_request_test(data,datetime,info) values(#{data}, #{datetime}, #{info})")
    @Options(useGeneratedKeys = false)
    void insert(@Param("data") String data, @Param("datetime") String datetime, @Param("info") String info);

}
