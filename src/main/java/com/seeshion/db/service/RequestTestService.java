package com.seeshion.db.service;

import com.seeshion.db.mapper.RequestTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @Author:ran
 */
@Service
public class RequestTestService {

    @Autowired
    private RequestTestMapper requestTestMapper;

    public void insertTestRequest() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        System.out.println(date);
        System.out.println("insertDate" + date);
        requestTestMapper.insert("test-spring", date, "spring");
    }
}
