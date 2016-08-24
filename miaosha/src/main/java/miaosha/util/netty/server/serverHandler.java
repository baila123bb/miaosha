package miaosha.util.netty.server;

import java.io.UnsupportedEncodingException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miaosha.util.netty.common.IMMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;


public class serverHandler extends ChannelInboundHandlerAdapter{
	
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
				
		if(activeChannel.get(1) == null){
			activeChannel.put(1, ctx);
		}else{
			activeChannel.put(2, ctx);
		}
		
		//channellist.add(newChannel);
		
	}
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		ByteBuf buf = (ByteBuf) msg;
		String recieved = getMessage(buf);
		System.out.println("服务器接收到消息：" + recieved);
		
		
		IMMessage message = (IMMessage)msg;
        if(activeChannel.get(message.getReceiveId())==null){
        	activeChannel.put(message.getUid(), ctx);
        }
        ChannelHandlerContext c = activeChannel.get(message.getReceiveId());
        if(c==null){
            message.setMsg("对方不在线！");
            activeChannel.get(message.getUid()).writeAndFlush(message);
        }
        else
            c.writeAndFlush(message);
		
		
	}

	/*
	 * 从ByteBuf中获取信息 使用UTF-8编码返回
	 */
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
}
