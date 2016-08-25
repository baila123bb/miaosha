package miaosha.util.netty.client;

import java.io.IOException;
import java.util.Scanner;

import miaosha.util.netty.common.IMConfig;
import miaosha.util.netty.common.IMMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;

public class NettyClient implements Runnable,IMConfig{
	/*
	 * 服务器端口号
	 */
	private int port;

	/*
	 * 服务器IP
	 */
	private String host;
	
	public static int UID = 8888;
    private NettyClientHandler clientHandler = new NettyClientHandler();
    

	public NettyClient(int port, String host)
			throws InterruptedException {
		this.port = port;
		this.host = host;
		start();
	}
	
	
//	public void sendMsg(IMMessage msg) throws IOException {
//        clientHandler.sendMsg(msg);
//    }
//    /**启动客户端控制台*/
//    private void runServerCMD() throws IOException {
//        IMMessage message = new IMMessage(
//                APP_IM,
//                CLIENT_VERSION,
//                UID,
//                TYPE_MSG_TEXT,
//                UID,
//                MSG_EMPTY);
//        @SuppressWarnings("resource")
//        Scanner scanner = new Scanner(System.in);
//        do{
//            message.setMsg(scanner.nextLine());
//        }
//        while (clientHandler.sendMsg(message));
//    }
	
	
	private void start() throws InterruptedException {

		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

		try {

			Bootstrap bootstrap = new Bootstrap();
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.group(eventLoopGroup);
			bootstrap.remoteAddress(host, port);
			
			
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel)
						throws Exception {
					
					AttributeKey<Object> name = AttributeKey.newInstance("name");
					socketChannel.attr(name).setIfAbsent("name");
					
					socketChannel.pipeline().addLast(new NettyClientHandler());
				}
			});
			ChannelFuture future = bootstrap.connect(host, port).sync();
			if (future.isSuccess()) {
				SocketChannel socketChannel = (SocketChannel) future.channel();
				System.out.println("----------------connect server success----------------");
			}
			future.channel().closeFuture().sync();
		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		NettyClient client = new NettyClient(9999, "localhost");
		
	}

	public void run() {
		// TODO Auto-generated method stub
		new Thread(this).start();
		
	}
}
