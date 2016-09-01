package miaosha.util.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import miaosha.util.netty.common.IMConfig;
import miaosha.util.netty.common.IMMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;





public class NettyClientHandler extends ChannelInboundHandlerAdapter implements IMConfig {

	
	 private ChannelHandlerContext ctx;
	 
	 
	 
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		System.out.println("成功连接服务器");
        //this.ctx = ctx;
        //ctx.channel().writeAndFlush(getSendByteBuf("xxxx"));
        IMMessage message = new IMMessage(
                APP_IM,
                CLIENT_VERSION,
                NettyClient.UID,
                TYPE_CONNECT,
                SERVER_ID,
                MSG_EMPTY);
        
        ctx.channel().writeAndFlush(message);
        
        
        //sendMsg(message);
		
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		String rev = getMessage(buf);
		System.out.println("客户端接受消息" + rev);
	}

	private String getMessage(ByteBuf buf) {
		byte[] con = new byte[buf.readableBytes()];
		buf.readBytes(con);
		try {
			return new String(con, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ByteBuf getSendByteBuf(String message)
			throws UnsupportedEncodingException {

		byte[] req = message.getBytes("UTF-8");
		ByteBuf pingMessage = Unpooled.buffer();
		pingMessage.writeBytes(req);

		return pingMessage;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
