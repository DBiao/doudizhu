package com.db.doudizhu.login;

import com.db.doudizhu.login.kit.ZKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
        LOGGER.info("启动 login 成功");
    }

    @Override
    public void run(String... args) throws Exception {
        ZKit zKit = new ZKit();
        zKit.subscribeEvent();
    }
}
