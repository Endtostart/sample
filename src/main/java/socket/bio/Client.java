package socket.bio;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
    public static void main(String[] args) {
        int port = 5506;
        String ip = "127.0.0.1";
        Socket socket = null;
        try {
            for (int i = 0; i < 10; i++) {
                new Thread(new ClientThread(new Socket(ip,port))).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread implements Runnable {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            System.out.println("client start");
            String hello = Thread.currentThread().getName()+":message from client";
            OutputStream os = null;
            os = socket.getOutputStream();
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
            //socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
