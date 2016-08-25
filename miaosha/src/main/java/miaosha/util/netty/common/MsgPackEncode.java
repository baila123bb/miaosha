package miaosha.util.netty.common;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgPackEncode extends MessageToByteEncoder<IMMessage> {

	@Override
	protected void encode(ChannelHandlerContext ctx, IMMessage msg, ByteBuf out) throws Exception {
		// TODO Auto-generated method stub
		 out.writeBytes(new MessagePack().write(msg));
	}

}
