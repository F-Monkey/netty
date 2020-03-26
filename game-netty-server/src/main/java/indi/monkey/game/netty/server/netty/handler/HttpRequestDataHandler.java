package indi.monkey.game.netty.server.netty.handler;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.HttpRequest;

public class HttpRequestDataHandler extends MessageToMessageDecoder<HttpRequest> {

	@Override
	protected void decode(ChannelHandlerContext ctx, HttpRequest msg, List<Object> out) throws Exception {
		System.out.println(msg);
	}
}
