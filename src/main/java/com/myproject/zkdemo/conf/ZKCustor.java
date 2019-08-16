package com.myproject.zkdemo.conf;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author wenhuigong
 * @Date 2019/7/16 19:52
 * @Description
 **/
@Component
public class ZKCustor {

    private CuratorFramework client = null;

    final static Logger log = LoggerFactory.getLogger(ZKCustor.class);

    public static final  String ZOOKEEPER_SERVER = "47.106.230.109:2181";

    public void init(){

        if (client!=null){
            return;
        }
        //创建重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,5);
        //创建zookeeper客户端
        client = CuratorFrameworkFactory.builder().connectString(ZOOKEEPER_SERVER)
                .sessionTimeoutMs(10000)
                .retryPolicy(retryPolicy)
                .namespace("conf")
                .build();

        client.start();

        try {
            if (client.checkExists().forPath("/conf")==null){
                /**
                 *  持久节点,创建之后 节点会永远存在 除非你手动删除
                 *                   临时节点 会话断开 自动删除
                 */
                client.create().creatingParentContainersIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath("/conf");
                log.info("zookeeper初始化成功");

            }
        } catch (Exception e) {
            log.error("zookeeper初始化失败");
            e.printStackTrace();
        }
    }
}
