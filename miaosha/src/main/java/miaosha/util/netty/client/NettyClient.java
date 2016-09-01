package miaosha.util.netty.client;

import java.util.Scanner;

import miaosha.util.netty.common.IMConfig;
import miaosha.util.netty.common.IMMessage;
import miaosha.util.netty.common.MsgPackDecode;
import miaosha.util.netty.common.MsgPackEncode;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

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
		
	}

	public static void main(String[] args) throws InterruptedException {

		NettyClient client = new NettyClient(9999, "localhost");
		new Thread(client).start();
		client.scaner();
	}
	
	public void scaner(){
		System.err.println("可以输入文字了");
		IMMessage message = new IMMessage();
		String msg ="";
		do{
			Scanner sc = new Scanner(System.in);
			msg= sc.nextLine();
			
		}while(clientHandler.senMsg(msg));
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
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
					
					socketChannel.pipeline().addLast("frameDecoder", new LengthFieldBasedFrameDecoder(65536, 0, 2, 0, 2));
					socketChannel.pipeline().addLast("msgpack decoder",new MsgPackDecode());
					socketChannel.pipeline().addLast("frameEncoder", new LengthFieldPrepender(2));
					socketChannel.pipeline().addLast("msgpack encoder",new MsgPackEncode());
                    
					socketChannel.pipeline().addLast(clientHandler);
				}
			});
			ChannelFuture future = bootstrap.connect(host, port).sync();
			if (future.isSuccess()) {
				SocketChannel socketChannel = (SocketChannel) future.channel();
				System.out.println("----------------connect server success----------------");
			}
			future.channel().closeFuture().sync();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}

}
