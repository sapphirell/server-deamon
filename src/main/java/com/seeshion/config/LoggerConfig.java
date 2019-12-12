package com.seeshion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/***
 * @Author:ran
 */
@Configuration
@PropertySource("classpath:log4j.properties")
public class LoggerConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${log4j.rootLogger}")
    private String rootLogger;

    @Value("${log4j.logger.com.seeshion}")
    private String debugLevel;

    @Value("${log4j.appender.stdout}")
    private String stdout;

    public String getRootLogger() {
        return rootLogger;
    }

    public void setRootLogger(String rootLogger) {
        this.rootLogger = rootLogger;
    }

    public String getDebugLevel() {
        return debugLevel;
    }

    public void setDebugLevel(String debugLevel) {
        this.debugLevel = debugLevel;
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }
}
