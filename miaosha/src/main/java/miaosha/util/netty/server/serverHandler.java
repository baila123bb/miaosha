package com.baila.util.netty.server;

import java.io.UnsupportedEncodingException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;


public class serverHandler extends ChannelHandlerAdapter {
	
	
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
		
		try {
			
			ctx.writeAndFlush(getSendByteBuf("消息已发送"));
			
			ChannelHandlerContext two = activeChannel.get(2);
			two.writeAndFlush(getSendByteBuf("收到1的消息"));
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
