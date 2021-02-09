import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler extends Thread {

    private BufferedReader reader;
    private PrintWriter writer;

    public SocketHandler(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            int symbol;
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                if ((symbol = reader.read()) != -1) {
                    if (symbol == '\n') {
                        System.out.println(stringBuffer.toString());
                        writer.println("Thank you!");
                        break;
                    }
                    stringBuffer.append((char) symbol);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
