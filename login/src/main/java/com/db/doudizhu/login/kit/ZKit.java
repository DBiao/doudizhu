package com.db.doudizhu.login.kit;

import com.db.doudizhu.login.config.Config;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * date: 2020/3/13 15:22
 *
 * @author: DengBiao
 */
@Component
public class ZKit {

    private static Logger logger = LoggerFactory.getLogger(ZKit.class);

    private AtomicLong index = new AtomicLong();

    @Autowired
    private Config config;

    @Autowired
    private ZkClient zkClient;

    @Autowired
    private LoadingCache<String, String> cache;

    /**
     * 添加服务器
     */
    public void addCache(String key) {
        cache.put(key, key);
    }

    /**
     * 监听事件
     */
    public void subscribeEvent() {
        zkClient.subscribeChildChanges(config.getRoot(), new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                logger.info("清除/更新本地缓存 parentPath=【{}】,currentChilds=【{}】", parentPath, currentChilds.toString());

                //更新所有缓存/先删除 再新增
                updateCache(currentChilds);
            }
        });
    }

    /**
     * 更新所有节点
     */
    public void updateCache(List<String> currentChilds) {
        cache.invalidateAll();
        for (String currentChild : currentChilds) {
            String key = currentChild.split("-")[1];
            addCache(key);
        }
    }

    /**
     * 轮询选取服务器
     *
     * @return
     */
    public String selectServer() {
        List<String> all = getAll();
        if (all.size() == 0) {
            throw new RuntimeException("可用服务器为空:" + all.size());
        }
        Long position = index.incrementAndGet() % all.size();
        if (position < 0) {
            position = 0L;
        }

        return all.get(position.intValue());
    }

    /**
     * 获取所有注册节点
     *
     * @return
     */
    public List<String> getAllNode() {
        List<String> children = zkClient.getChildren("/route");
        return children;
    }

    /**
     * 获取所有的服务列表
     *
     * @return
     */
    public List<String> getAll() {

        List<String> list = new ArrayList<>();

        if (cache.size() == 0) {
            List<String> allNode = getAllNode();
            for (String node : allNode) {
                String key = node.split("-")[1];
                addCache(key);
            }
        }

        for (Map.Entry<String, String> entry : cache.asMap().entrySet()) {
            list.add(entry.getKey());
        }
        return list;

    }
}
