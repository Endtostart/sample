package socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class NioClient {
    public static void main(String[] args) throws IOException {
        int port = 5556;
        String host = "localhost";

        // buffer define
        ByteBuffer recv = ByteBuffer.allocate(1204);


        InetSocketAddress inet = new InetSocketAddress(host, port);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(inet);
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_WRITE|SelectionKey.OP_READ);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            selector.select();
            Set<SelectionKey> sks = selector.selectedKeys();
            Iterator<SelectionKey> keys = sks.iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                SocketChannel channel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    if (channel.isConnectionPending()){
                        if (channel.finishConnect()) {
                            channel.configureBlocking(false);

                            System.out.println("connected");
                            recv.clear();
                            String mesg = "Mesg from client "+ Math.random()*100;
                            recv.put(mesg.getBytes());
                            recv.flip();
                            channel.write(recv);
                            channel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                        }
                    }
                } else if (key.isReadable()) {
                    recv.clear();
                    channel.read(recv);
                    System.out.println("Server:" + new String(recv.array()));
                    key.interestOps(SelectionKey.OP_WRITE);
                } else if (key.isWritable()) {
                    recv.clear();
                    //String mesg = "Mesg from client "+ Math.random()*100;
                    String mesg = reader.readLine();
                    recv.put(mesg.getBytes());
                    recv.flip();
                    channel.write(recv);
                    key.interestOps(SelectionKey.OP_READ);
                }

            }
        }
    }
}
