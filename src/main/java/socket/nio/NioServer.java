package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    private ServerSocketChannel serverChannal;
    private Selector selector;
    ByteBuffer send = ByteBuffer.allocate(1024);

    public NioServer(int port) throws IOException {
        serverChannal = ServerSocketChannel.open();
        serverChannal.socket().bind(new InetSocketAddress("localhost", port));
        serverChannal.configureBlocking(false);
        selector = Selector.open();
        serverChannal.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server start");
        System.out.println("waiting request...");
    }

    public void listen() throws IOException {
        while (true) {
            if (0 == selector.select()) {
                continue;
            }
            Set<SelectionKey> its = selector.selectedKeys();
            Iterator<SelectionKey> keys = its.iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                dealReauest(key);
            }

        }
    }

    public void dealReauest(SelectionKey key) throws IOException {

        SocketChannel client;

        if (key.isAcceptable()) {

            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            client = channel.accept();
            client.configureBlocking(false);
            /*String mesg = "Server : conneted";

            send.put(mesg.getBytes());
            client.write(send);*/
            System.out.println("new request connected");
            send.put("you conneced ok".getBytes());
            send.flip();
            client.write(send);

            client.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
        } else if (key.isReadable()) {
            client = (SocketChannel) key.channel();
            send.clear();
            client.read(send);
            System.out.println("data from Server:" + new String(send.array()));
            key.interestOps(SelectionKey.OP_WRITE);
        } else if (key.isWritable()) {
            client = (SocketChannel) key.channel();
            send.clear();
            String mesg = "Hello client";
            send.put(mesg.getBytes());
            send.flip();
            client.write(send);
            key.interestOps(SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer(5556);
        server.listen();
    }


}
