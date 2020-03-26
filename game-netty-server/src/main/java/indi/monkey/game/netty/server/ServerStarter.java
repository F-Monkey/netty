package indi.monkey.game.netty.server;

import java.net.InetSocketAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import indi.monkey.game.netty.server.netty.NettyServer;

@SpringBootApplication
public class ServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ServerStarter.class, args);
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
	}
}
