package com.seeshion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/***
 * @Author ran
 */
@Configuration
public class ChuangLanSmsConfig {
    /**
     * 用户账号，必填
     */
    @Value("${sx.sms.account}")
    private String account;
    /**
     * 用户密码，必填
     */
    @Value("${sx.sms.password}")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
