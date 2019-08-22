package com.exe.wenda.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Date 2019/5/8 17:01
 */
public class WatchOne extends BaseConfig{
  public String getZnode(String path) throws KeeperException, InterruptedException {
    String result = "";
    byte[] byteArray = zk.getData(path, new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {
        try {
          triggerValue(path);
        } catch (KeeperException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, new Stat());
    result = new String(byteArray);

    return result;
  }

  public void triggerValue(String path) throws KeeperException, InterruptedException {
    String result = "";

    byte[] byteArray = zk.getData(path, null, new Stat());

    result = new String(byteArray);

    logger.info("watch result" + result);
  }

  public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
    WatchOne one = new WatchOne();
    one.setZk(one.startZK());

    if(one.getZk().exists(PATH, false) == null)
    {
      one.createZnode(PATH, "AAA");

      String result = one.getZnode(PATH);

      logger.info("*********main init result : "+result);
    }else {
      logger.info("This node is exists......");
    }

    Thread.sleep(Long.MAX_VALUE);
  }
}
