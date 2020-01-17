package com.db.doudizhu.server;

import com.db.doudizhu.server.kit.RegistryZK;
import com.db.doudizhu.server.server.GameServerHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

/**
 * date: 2020/1/16 17:08
 * author: DengBiao
 */
@SpringBootApplication
public class ServerApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Value("${server.port}")
    private int serverPort;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        logger.info("启动 Server 成功");
    }

    @Override
    public void run(String... args) throws Exception {
        //获得本机IP
        String addr = InetAddress.getLocalHost().getHostAddress();
        Thread thread = new Thread(new RegistryZK(addr, serverPort));
        thread.setName("registry-zk");
        thread.start();
    }
}
