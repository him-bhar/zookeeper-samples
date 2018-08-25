package com.himanshu.zookeeper.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkNodeReader {
  public static String readNode(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
    byte[] bytes = zooKeeper.getData(path, false, new Stat());
    return new String(bytes);
  }
}
