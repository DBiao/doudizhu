package com.db.doudizhu.login.config;

/**
 * date: 2020/3/13 15:53
 * author: DengBiao
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "login")
@PropertySource("classpath:application.yml")
public class Config {
    private String root;
}
