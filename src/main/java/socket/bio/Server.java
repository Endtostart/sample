package socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(15, 20, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5));
    public static void main(String[] args) {
        int port = 5506;
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            System.out.println("server start");
            System.out.println("waiting request");
            while (true) {
                socket = server.accept();
                dealRequest(socket);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void dealRequest(Socket socket) {
        //new Thread(new socket.bio.RequestProcessor(socket));
        poolExecutor.execute(new RequestProcessor(socket));
    }
}


class RequestProcessor implements Runnable {

    private Socket socket;

    public RequestProcessor(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try{
            InputStream is = socket.getInputStream();
            BufferedReader bd = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bd.readLine()) != null){
                sb.append(line);
            }
            System.out.println("client:"+sb.toString());

            OutputStream os = socket.getOutputStream();
            /*BufferedReader re = new BufferedReader(new InputStreamReader(System.in));*/
            /*int b = re.read();
            while (true){
                if (b == '\n')
                    break;
                os.write(b);
                b = re.read();
            }*/
            os.write((Thread.currentThread().getName()+ ":message from server").getBytes("UTF-8"));
            os.flush();
            is.close();
            os.close();
            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
