package com.himanshu.zookeeper.server;

import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerMain;

import java.io.IOException;

public class ZookeeperQuorumNode2Main {
  public static void main(String[] args) throws QuorumPeerConfig.ConfigException, IOException {
    QuorumPeerMain peerMain = new QuorumPeerMain();
    QuorumPeerConfig quorumPeerConfig = new QuorumPeerConfig();
    String zkQuorumNode1ConfigFilePath = ZookeeperQuorumNode2Main.class.getResource("/").getFile().concat("/zk_quorum_2.properties");
    quorumPeerConfig.parse(zkQuorumNode1ConfigFilePath);
    peerMain.runFromConfig(quorumPeerConfig);

  }
}
