package socket.bio;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 5506;
        String ip = "127.0.0.1";
        Socket socket = null;
        try {
            socket = new Socket(ip,port);
            System.out.println("client start");
            String hello = "hello server";
            OutputStream os = socket.getOutputStream();
            os.write(hello.getBytes("UTF-8"));
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            BufferedReader bd = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bd.readLine()) != null){
                sb.append(line);
            }
            System.out.println("server:"+sb.toString());
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
