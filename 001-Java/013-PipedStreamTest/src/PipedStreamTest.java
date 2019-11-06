import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedStreamTest {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        writer.connect(reader);
        Thread thread = new Thread(new PrintTest(reader));
        thread.start();

        int receive = 0;

        try {
            while ((receive = System.in.read()) != -1) {
                writer.write(receive);
            }
        } finally {
            writer.close();
        }
    }
}
