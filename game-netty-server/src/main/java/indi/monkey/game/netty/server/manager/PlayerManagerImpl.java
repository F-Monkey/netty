package indi.monkey.game.netty.server.manager;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import indi.monkey.game.netty.server.player.Player;
import indi.monkey.game.netty.server.util.ThreadPoolUtil;
import io.netty.channel.ChannelHandlerContext;

public class PlayerManagerImpl implements PlayerManager {
	// users
	private final ConcurrentHashMap<String, Player> users;
	// thread poll
	private ExecutorService executorService;

	private int TIME_OUT = 2 << 9;

	public PlayerManagerImpl() {
		this.users = new ConcurrentHashMap<>();
		this.executorService = new ThreadPoolExecutor(2, ThreadPoolUtil.ioIntesivePoolSize(), TIME_OUT,
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1000));
		// new Thread(this.new RemoveUserThread()).start();
	}

	@Override
	public void addPlayer(Player player) {

	}

	@Override
	public Set<String> getPlayers() {
		return null;
	}

	@Override
	public Player getPlayer(String username) {
		return null;
	}

	@Override
	public void broadcast(String message) {
	}

	@Override
	public void onMessage(ChannelHandlerContext ctx, String message) {

	}

	@Override
	public void sendMessage(String username, String message) {

	}

	@Override
	public void offline(ChannelHandlerContext ctx) {
		ctx.name();
	}
}
