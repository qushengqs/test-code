import java.io.IOException;
import java.net.Socket;

public class BioClientThread {

    public static void main(String[] args) {
        new Thread(new ClientThread(5000, "客户端1发送数据")).start();
        new Thread(new ClientThread(6000, "客户端2发送数据")).start();
        new Thread(new ClientThread(8000, "客户端3发送数据")).start();

    }

    public static class ClientThread implements Runnable {
        private int sleepTime;
        private String message;

        public ClientThread(int sleepTime, String message) {
            this.sleepTime = sleepTime;
            this.message = message;
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);

                Thread.sleep(this.sleepTime);
                socket.getOutputStream().write(message.getBytes());
                socket.close();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
