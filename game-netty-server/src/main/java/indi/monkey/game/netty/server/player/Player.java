package indi.monkey.game.netty.server.player;

public interface Player {
	String getUserName();
	
	void write(String message);

	void offline();

	boolean isOffline();
	
}
