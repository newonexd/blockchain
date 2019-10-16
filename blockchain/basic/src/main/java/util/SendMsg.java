package util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rxd
 * @ClassName SendMsg
 * Description TODO
 * @date 2019-09-27 09:30
 * @Version 1.0
 */
public final class SendMsg {
    private static final ConcurrentHashMap<String, SocketChannel> hashMap = new ConcurrentHashMap<>(Constant.REAL_NODE_COUNT);
    private static ByteArrayOutputStream byteArrayOutputStream = null;
    private static ObjectOutputStream objectOutputStream = null;

    public static void send_msg(String location, Object obj) throws IOException {
        SocketChannel socketChannel = SendMsg.hashMap.get(location);
        try {
            if (socketChannel == null) {
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                socketChannel.connect(new InetSocketAddress(location, Constant.PORT));
                Thread.sleep(Constant.DELAY_TIME);
                if (socketChannel.finishConnect())
                    SendMsg.hashMap.put(location, socketChannel);
            }
            if (socketChannel.finishConnect()) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(obj);
                ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                socketChannel.write(byteBuffer);
            }
        } catch (NoRouteToHostException | InterruptedException e) {
        } catch (IOException e) {
            hashMap.remove(location);
        } finally {
            byteArrayOutputStream.close();
            objectOutputStream.close();
        }

    }


}
