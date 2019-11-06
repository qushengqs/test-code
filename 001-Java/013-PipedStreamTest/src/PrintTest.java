import java.io.IOException;
import java.io.PipedReader;

/**
 * @Author: senne
 * @Date: 2019/9/5 10:45
 * @Version 1.0
 */
public class PrintTest implements Runnable {
    private PipedReader reader;

    public PrintTest(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        int receive = 0;
        try {
            while ((receive = reader.read()) != -1) {
                System.out.print((char) receive);
            }
        } catch (IOException ex) {

        }
    }
}
