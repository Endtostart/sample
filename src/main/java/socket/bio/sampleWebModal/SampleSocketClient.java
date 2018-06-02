package socket.bio.sampleWebModal;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.io.*;
import java.net.Socket;

public class SampleSocketClient extends Thread{
    int port = 9909;
    String server = "127.0.0.1";
    String path = "";

    public void request(){
        this.start();
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+":Loading connect to "+ server);

        try {
            Socket socket = new Socket(server,port);
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET "+Thread.currentThread().getName()+"HTTP/1.0");
            out.println();

            String line = in.readLine();
            while (line != null){
                System.out.println(line);
                line = in.readLine();
            }

            in.close();
            out.close();
            socket.close();
            System.out.println(Thread.currentThread().getName()+": close connect");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        /*System.out.println("Loading connect to "+ server);

        try {
            Socket socket = new Socket(server,port);
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET "+path+"HTTP/1.0");
            out.println();

            String line = in.readLine();
            while (line != null){
                System.out.println(line);
                line = in.readLine();
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        for(int i=0;i<20;i++){
            SampleSocketClient ssc = new SampleSocketClient();
            ssc.start();
        }

    }
}
