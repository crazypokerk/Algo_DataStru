package com.exe.wenda.zookeeper;

import org.apache.zookeeper.*;

/**
 * @Date 2019/5/8 15:44
 */
public class HelloZK extends BaseConfig{

  public static void main(String[] args) throws Exception {
    HelloZK helloZK = new HelloZK();

    ZooKeeper zooKeeper = helloZK.startZK();

    if (zooKeeper.exists(PATH, false) == null) {
      helloZK.createZnode(PATH, "java");
      String result = helloZK.getZnode(PATH);

      if (logger.isInfoEnabled()) {
        logger.info("result" + result);
      }
    }else {
      logger.info("This node is exists...");
    }

    helloZK.stopZK();
  }
}
