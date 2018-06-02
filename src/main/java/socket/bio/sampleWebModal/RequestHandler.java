package socket.bio.sampleWebModal;

import sun.awt.windows.ThemeReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler extends Thread{
    private Socket socket;
    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            System.out.println("Receved a connection Thread:"+Thread.currentThread().getName());
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Echo Server 1.0 Thread:"+Thread.currentThread().getName());
            out.flush();

            String line = bf.readLine();
            while (line != null && line.length() > 0){
                out.println("Echo:"+line+" Thread:"+Thread.currentThread().getName());
                out.flush();
                line = bf.readLine();
            }

            out.close();
            bf.close();
            socket.close();

            System.out.println("Connection closed Thread:"+ Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
