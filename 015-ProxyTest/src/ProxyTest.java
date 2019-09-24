import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        FormService target = new FormServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        FormService proxy = (FormService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        proxy.removeForm(10);
        proxy.removeTopic(1012);
    }

}
