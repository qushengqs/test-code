import javafx.beans.binding.IntegerBinding;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class BufferTest {

    static IntBuffer buffer;

    public static void main(String[] args) {
        allocateTest();
        putTest();
        flipTest();
        getTest();
        rewindTest();
        reReadTest();
        resetTest();
        clearTest();
    }

    public static void allocateTest() {
        buffer = IntBuffer.allocate(20);
        logger("after allocate");
    }

    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            buffer.put(i * 2);
        }
        logger("after put");
    }

    public static void flipTest() {
        buffer.flip();
        logger("after flip");
    }

    public static void getTest() {
        loggerMessage("after get 2");
        for (int i = 0; i < 2; i++) {
            int current = buffer.get();
            logger(current);
        }
        logger();

        loggerMessage("after get 3");
        for (int i = 0; i < 3; i++) {
            int current = buffer.get();
            logger(current);
        }
        logger();
    }

    public static void rewindTest() {
        buffer.rewind();
        logger("after rewind");
    }

    public static void reReadTest() {
        loggerMessage("after reRead");
        for (int i = 0; i < 5; i++) {
            int current = buffer.get();
            logger(current);

            if (i == 2) {
                buffer.mark();
            }
        }

        logger();
    }

    public static void clearTest() {
        buffer.clear();
        logger("after clear");
    }

    public static void resetTest() {
        buffer.reset();
        logger("after reset");
    }

    public static void logger(int current) {
        System.out.println("current = " + current);
    }

    public static void loggerMessage(String message) {
        System.out.println("----------- " + message + " -----------");
    }

    public static void logger(String message) {
        loggerMessage(message);
        logger();
    }

    public static void logger() {
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        System.out.println("capacity = " + buffer.capacity());
        System.out.println();
    }
}
