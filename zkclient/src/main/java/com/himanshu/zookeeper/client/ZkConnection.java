package com.himanshu.zookeeper.client;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkConnection {
  private ZooKeeper zooKeeper;
  private final static Logger log = LoggerFactory.getLogger(ZkConnection.class);
  private final CountDownLatch connectedSignal = new CountDownLatch(1);

  public ZooKeeper connect(String host, int port) throws IOException, InterruptedException {
    return zooKeeper = connectToZk(host, port);
  }

  public void close() throws InterruptedException {
    zooKeeper.close();
  }

  private ZooKeeper connectToZk(String host, int port) throws IOException, InterruptedException {
    ZooKeeper zooKeeper = new ZooKeeper(host+":"+port, 2000, new Watcher() {
      @Override
      public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected.equals(watchedEvent.getState())) {
          connectedSignal.countDown();
        }
      }
    });
    connectedSignal.await();
    return zooKeeper;
  }

}
