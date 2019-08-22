package com.exe.wenda.zookeeper;

import lombok.Getter;
import lombok.Setter;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Date 2019/5/8 16:45
 */
public class BaseConfig {
  protected static final Logger logger = LoggerFactory.getLogger(BaseConfig.class);

  protected @Setter@Getter ZooKeeper zk;

  protected static final String CONNECTSTRING = "192.168.120.131:2181";
  protected static final String PATH = "/motherfucker";
  protected static final int SESSION_TIMEOUT = 20 * 1000;

  public ZooKeeper startZK() throws IOException {
    return new ZooKeeper(CONNECTSTRING, SESSION_TIMEOUT, new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {

      }
    });
  }

  public void createZnode(String path, String data) throws KeeperException, InterruptedException {
    zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
  }

  public String getZnode(String path) throws KeeperException, InterruptedException {
    String result = "";
    byte[] byteArray = zk.getData(path, false, new Stat());
    result = new String(byteArray);

    return result;
  }

  public void stopZK() throws InterruptedException {
    if (zk != null) {
      zk.close();
    }
  }
}
