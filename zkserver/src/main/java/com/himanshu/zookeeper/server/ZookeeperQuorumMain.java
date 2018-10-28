package com.himanshu.zookeeper.server;

import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerMain;

import java.io.IOException;

/**
 * @see {}https://zookeeper.apache.org/doc/r3.3.3/api/org/apache/zookeeper/server/quorum/QuorumPeerMain.html}
 */
public class ZookeeperQuorumMain {
  public static void main(String[] args) throws QuorumPeerConfig.ConfigException, IOException {
    QuorumPeerMain peerMain = new QuorumPeerMain();
    QuorumPeerConfig quorumPeerConfig = new QuorumPeerConfig();
    String zkQuorumNode1ConfigFilePath = ZookeeperQuorumMain.class.getResource("/").getFile().concat("/zk_quorum.properties");
    quorumPeerConfig.parse(zkQuorumNode1ConfigFilePath);
    peerMain.runFromConfig(quorumPeerConfig);

  }
}
