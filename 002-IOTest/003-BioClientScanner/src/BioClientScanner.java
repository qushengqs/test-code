import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BioClientScanner {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            String message = null;

            Scanner scanner = new Scanner(System.in);
            message = scanner.next();

            socket.getOutputStream().write(message.getBytes());

            socket.close();
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
