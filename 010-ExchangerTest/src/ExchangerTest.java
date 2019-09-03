import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Exchanger<String> exchanger = new Exchanger<>();

        Exchanger1 exchanger1 = new Exchanger1(exchanger);
        Exchanger2 exchanger2 = new Exchanger2(exchanger);

        new Thread(exchanger1).start();
        new Thread(exchanger2).start();
    }
}
