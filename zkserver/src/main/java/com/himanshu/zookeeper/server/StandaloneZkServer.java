package com.himanshu.zookeeper.server;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;

import java.io.*;

public class StandaloneZkServer {
  public static void main(String[] args) throws QuorumPeerConfig.ConfigException, IOException {
    String zkStandalongConfigFilePath = StandaloneZkServer.class.getResource("/").getFile().concat("/zk_standalone.properties");
    /*File f = new File(zkStandalongConfigFilePath);
    try (InputStream configStream = new FileInputStream(f)) {
      StringBuilder sb = new StringBuilder();
      int ch;
      while((ch = configStream.read()) != -1) {
        sb.append((char)ch);
      }
      System.out.println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }*/

    ZooKeeperServerMain zkStandaloneServer = new ZooKeeperServerMain();
    ServerConfig serverConfig = new ServerConfig();
    serverConfig.parse(zkStandalongConfigFilePath);
    zkStandaloneServer.runFromConfig(serverConfig);
  }
}
