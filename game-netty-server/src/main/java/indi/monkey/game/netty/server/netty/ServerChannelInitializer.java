package indi.monkey.game.netty.server.netty;

import indi.monkey.game.netty.server.manager.PlayerManagerImpl;
import indi.monkey.game.netty.server.netty.handler.HttpRequestDataHandler;
import indi.monkey.game.netty.server.netty.handler.NettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// 添加编解码
		ch.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
		ch.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
		ch.pipeline().addLast("httpDecoder", new HttpRequestDataHandler());
		ch.pipeline().addLast(new NettyServerHandler(new PlayerManagerImpl()));
	}

}
