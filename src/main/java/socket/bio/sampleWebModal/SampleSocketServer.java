package socket.bio.sampleWebModal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleSocketServer extends Thread{
    private int port;
    private ServerSocket serverSocket;
    private boolean running = false;

    public SampleSocketServer(int port){
        this.port = port;
    }

    public void startServer(){
        try {
            System.out.println("start server");
            System.out.println("listen port:"+port);
            serverSocket = new ServerSocket(port);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopServer(){
        System.out.println("stoping server");
        this.running = false;
        this.interrupt();
    }

    @Override
    public void run(){
        running = true;
        while (running){
            try {
                Socket socket = serverSocket.accept();
                /*PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("HTTP/1.1 500 Domain Not Found");
                out.println("Cache-Control: private, no-cache");
                out.println("Success");
                out.flush();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = in.readLine()) != null && line.length() > 0){
                    sb.append(line);
                }
                System.out.println("client"+Thread.currentThread().getName()+":"+sb.toString());
                out.close();
                in.close();
                socket.close();*/
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SampleSocketServer server = new SampleSocketServer(9909);
        server.startServer();
        try {
            Thread.sleep(60000);
            server.stopServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
