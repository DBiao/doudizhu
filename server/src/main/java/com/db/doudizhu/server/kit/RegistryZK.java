package com.db.doudizhu.server.kit;

import com.db.doudizhu.server.config.Configuration;
import com.db.doudizhu.server.util.SpringBeanFactory;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * date: 2020/1/16 17:08
 * author: DengBiao
 */
public class RegistryZK implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(RegistryZK.class);

    private ZkClient zkClient;
    private Configuration config;
    private String ip;
    private int serverPort;

    public RegistryZK(String ip, int serverPort) {
        this.ip = ip;
        this.serverPort = serverPort;
        this.config = SpringBeanFactory.getBean(Configuration.class);
        this.zkClient = new ZkClient(config.getZkAddr(), config.getZkConnectTimeout());
    }

    @Override
    public void run() {

        createFatherNode();

        //是否要将自己注册到 ZK
        if (config.isZkSwitch()) {
            String path = config.getZkRoot() + "/ip-" + ip + ":" + serverPort;
            zkClient.createEphemeral(path);
            logger.info("注册 zookeeper 成功，msg=[{}]", path);
        }
    }

    /**
     * 创建父节点
     */
    public final void createFatherNode() {
        boolean exists = zkClient.exists(config.getZkRoot());
        if (exists) {
            return;
        }

        //创建 root
        zkClient.createPersistent(config.getZkRoot());
    }
}
