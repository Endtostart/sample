package socket.nio.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class BufferTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        byte[] msg = "before word".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(msg);
        ReadableByteChannel readableChannel = Channels.newChannel(inputStream);
        readableChannel.read(buffer);
        //buffer.flip();
        buffer.clear();
        readableChannel.read(buffer);




        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WritableByteChannel writableChannel = Channels.newChannel(outputStream);
        writableChannel.write(buffer);

        System.out.println("before : " + outputStream.toString());





        /*String msg = "before word";
        buffer.put(msg.getBytes());
        System.out.println("buffer: " + buffer.slice(). toString());
        System.out.println("= = = = = = = = = ");

        buffer.clear();
        System.out.println("after clean: " + buffer.slice().toString());
        System.out.println("= = = = = = = = = ");

        msg = "hello";
        buffer.put(msg.getBytes());
        System.out.println("after put: " + buffer.slice().toString());

        System.out.println("= = = = = = = = = ");
        buffer.flip();
        System.out.println("after flip: " + buffer.slice().toString());*/
    }
}
