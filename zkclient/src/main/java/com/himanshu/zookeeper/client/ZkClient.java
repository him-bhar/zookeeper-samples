package com.himanshu.zookeeper.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ZkClient {
  private final static Logger log = LoggerFactory.getLogger(ZkClient.class);
  public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
    ZkConnection zkConnection = new ZkConnection();
    ZooKeeper zooKeeper = zkConnection.connect("localhost", 2181);
    log.info(String.valueOf(zooKeeper.getState()));
    //createNode(zooKeeper);
    readNode(zooKeeper);
    zkConnection.close();
  }

  private static void readNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
    log.info(ZkNodeReader.readNode(zooKeeper, "/abc2"));
  }

  private static void createNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
    ZkNodeCreator.createZNode(zooKeeper, "/abc2", "Hello from Zookeeper Himanshu");
  }


}
