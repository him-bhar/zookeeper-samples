package com.himanshu.zookeeper.client;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZkNodeCreator {
  public static void createZNode(ZooKeeper zooKeeper, String path, String data) throws KeeperException, InterruptedException {
    zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
  }
}
