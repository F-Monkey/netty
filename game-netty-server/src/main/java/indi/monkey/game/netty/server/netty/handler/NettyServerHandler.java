package indi.monkey.game.netty.server.netty.handler;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import indi.monkey.game.netty.server.manager.PlayerManager;
import indi.monkey.game.netty.server.player.GamePlayer;
import indi.monkey.game.netty.server.player.Player;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	private PlayerManager playerManager;
	private static final Gson GSON = new GsonBuilder().create();

	public NettyServerHandler(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	/**
	 * 客户端连接会触发
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("Channel active......");
	}

	/**
	 * 客户端发消息会触发
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("服务器收到消息: {},ctx.name:{}", msg.toString(), ctx.name());
		// gson
		HashMap<String, String> data = GSON.fromJson(msg.toString(), new TypeToken<HashMap<String, String>>() {
		}.getType());
		String username = data.get("username");
		Player player = new GamePlayer(username, ctx);
		playerManager.addPlayer(player);
		ctx.flush();
	}

	/**
	 * 发生异常触发
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.error("exception:{}", cause);
		playerManager.offline(ctx);
		ctx.close();
	}
}