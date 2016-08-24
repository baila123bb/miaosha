package com.baila.util.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;


public class NettyClientHandler extends ChannelHandlerAdapter {
	private ByteBuf firstMessage;
	private Channel curChannel;
	
	
	 
	 
	 
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		curChannel = ctx.channel();
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("请输入："); 
        String msg = sc.nextLine();
        byte[] data = msg.getBytes();
        		
		//byte[] data = "服务器，给我一个APPLE".getBytes();
		firstMessage = Unpooled.buffer();
		firstMessage.writeBytes(data);
		ctx.writeAndFlush(firstMessage);
		
		
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		String rev = getMessage(buf);
		System.out.println("客户端收到服务器数据:" + rev);
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
}
