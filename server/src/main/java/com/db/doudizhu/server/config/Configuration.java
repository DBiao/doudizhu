package com.db.doudizhu.server.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * date: 2020/1/16 17:41
 * author: DengBiao
 */
public class Configuration {
    @Value("${app.zk.root}")
    private String zkRoot;

    @Value("${app.zk.addr}")
    private String zkAddr;

    @Value("${app.zk.switch}")
    private boolean zkSwitch;

    @Value("${cim.server.port}")
    private int cimServerPort;

    @Value("${cim.clear.route.request.url}")
    private String clearRouteUrl ;

    @Value("${cim.heartbeat.time}")
    private long heartBeatTime ;

    @Value("${app.zk.connect.timeout}")
    private int zkConnectTimeout;

    public int getZkConnectTimeout() {
        return zkConnectTimeout;
    }

    public String getClearRouteUrl() {
        return clearRouteUrl;
    }

    public void setClearRouteUrl(String clearRouteUrl) {
        this.clearRouteUrl = clearRouteUrl;
    }

    public String getZkRoot() {
        return zkRoot;
    }

    public void setZkRoot(String zkRoot) {
        this.zkRoot = zkRoot;
    }

    public String getZkAddr() {
        return zkAddr;
    }

    public void setZkAddr(String zkAddr) {
        this.zkAddr = zkAddr;
    }

    public boolean isZkSwitch() {
        return zkSwitch;
    }

    public void setZkSwitch(boolean zkSwitch) {
        this.zkSwitch = zkSwitch;
    }

    public int getCimServerPort() {
        return cimServerPort;
    }

    public void setCimServerPort(int cimServerPort) {
        this.cimServerPort = cimServerPort;
    }

    public long getHeartBeatTime() {
        return heartBeatTime;
    }

    public void setHeartBeatTime(long heartBeatTime) {
        this.heartBeatTime = heartBeatTime;
    }
}
