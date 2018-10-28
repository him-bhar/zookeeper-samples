package com.himanshu.zookeeper.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZkNodeDeleter {
  public static void deleteZNode(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
    zooKeeper.delete(path, zooKeeper.exists(path, false).getVersion());
  }
}
