package socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5506;
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            System.out.println("server start");
            System.out.println("waiting request");
            socket = server.accept();
            InputStream is = socket.getInputStream();
            BufferedReader bd = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bd.readLine()) != null){
                sb.append(line);
            }
            System.out.println("client:"+sb.toString());

            OutputStream os = socket.getOutputStream();
            BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
            int b = re.read();
            while (true){
                if (b == '\n')
                    break;
                os.write(b);
                b = re.read();
            }
            /*os.write("message from server".getBytes("UTF-8"));*/
            os.flush();
            is.close();
            os.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
