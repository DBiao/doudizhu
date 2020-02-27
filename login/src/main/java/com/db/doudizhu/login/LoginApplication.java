package com.db.doudizhu.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
        LOGGER.info("启动 login 成功");
    }
}
