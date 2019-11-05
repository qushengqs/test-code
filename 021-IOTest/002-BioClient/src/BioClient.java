import java.io.IOException;
import java.net.Socket;

public class BioClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            socket.getOutputStream().write("向服务器发送数据".getBytes());
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
