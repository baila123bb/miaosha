package miaosha.util.netty.server;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;

public class activeChannel {
	 //用户表
    private static HashMap<Integer, ChannelHandlerContext> onlineUser = new HashMap<Integer, ChannelHandlerContext>();
    
    public static void put(Integer uid, ChannelHandlerContext uchc){
        onlineUser.put(uid, uchc);
    }
    public static void remove(Integer uid){
        onlineUser.remove(uid);
    }
    public static ChannelHandlerContext get(Integer uid){
        return onlineUser.get(uid);
    }
}
