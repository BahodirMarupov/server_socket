import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server is running on 8888 port!");
            while (true) {
                Socket accept = serverSocket.accept();
                new SocketHandler(accept).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

