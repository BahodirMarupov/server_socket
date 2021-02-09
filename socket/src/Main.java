import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        PrintWriter writer=new PrintWriter(socket.getOutputStream());
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer.println("Hello from Demo1");
        writer.flush();
        System.out.println(reader.readLine());
    }
}
