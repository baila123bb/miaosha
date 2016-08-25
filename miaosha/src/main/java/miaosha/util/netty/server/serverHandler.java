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
		System.out.println("鏈嶅姟鍣ㄦ帴鏀跺埌娑堟伅锛�" + recieved);
		
		
		IMMessage message = (IMMessage)msg;
        if(activeChannel.get(message.getReceiveId())==null){
        	activeChannel.put(message.getUid(), ctx);
        }
        ChannelHandlerContext c = activeChannel.get(message.getReceiveId());
        if(c==null){
            message.setMsg("瀵规柟涓嶅湪绾匡紒");
            activeChannel.get(message.getUid()).writeAndFlush(message);
        }
        else
            c.writeAndFlush(message);
		
		
	}

	/*
	 * 浠嶣yteBuf涓幏鍙栦俊鎭� 浣跨敤UTF-8缂栫爜杩斿洖
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
	
	/**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.err.println("与客户端断开连接:"+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
    
    
    
}
