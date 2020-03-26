package indi.monkey.game.netty.server.manager;

import java.util.Set;


import indi.monkey.game.netty.server.player.Player;
import io.netty.channel.ChannelHandlerContext;

public interface PlayerManager {
	void addPlayer(Player player);

	Set<String> getPlayers();

	Player getPlayer(String username);

	void broadcast(String message);

	void onMessage(ChannelHandlerContext ctx, String message);

	public void sendMessage(String username, String message);

	void offline(ChannelHandlerContext ctx);
}
