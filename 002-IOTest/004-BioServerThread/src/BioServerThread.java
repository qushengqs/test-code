import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServerThread {

    public static void main(String[] args) {
        byte[] buffer = new byte[1024];

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器开始监听8080端口");

            while (true) {
                System.out.println();
                System.out.println("等待客户端的连接....");
                Socket socket = serverSocket.accept();
                new ServerThread(socket, buffer).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class ServerThread extends Thread {
        Socket socket = null;
        byte[] buffer = null;

        public ServerThread(Socket socket, byte[] buffer) {
            this.socket = socket;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                System.out.println("连接成功....");

                System.out.println();
                System.out.println("等待客户端的数据....");
                socket.getInputStream().read(buffer);
                System.out.println("接收到数据....");

                String content = new String(buffer);
                System.out.println();
                System.out.println("接收到的请求：" + content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
