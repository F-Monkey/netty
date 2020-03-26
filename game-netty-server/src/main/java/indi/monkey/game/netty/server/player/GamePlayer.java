package indi.monkey.game.netty.server.player;

import io.netty.channel.ChannelHandlerContext;

public class GamePlayer implements Player {

	private String username;
	private ChannelHandlerContext ctx;
	private boolean isOnline = true;

	public GamePlayer(String username, ChannelHandlerContext ctx) {
		this.username = username;
		this.ctx = ctx;
	}

	@Override
	public String getUserName() {
		return username;
	}

	@Override
	public void write(String message) {
		ctx.write(message);
	}

	@Override
	public void offline() {
		this.isOnline = false;
	}

	@Override
	public boolean isOffline() {
		return !isOnline;
	}

}
