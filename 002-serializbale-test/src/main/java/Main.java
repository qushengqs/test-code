import java.io.*;

/**
 * @Author: senne
 * @Date: 2019/6/29 10:21
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("美好的一天");
        customer.setAge(19);
        System.out.println(customer);

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("ser-test"));) {
            stream.writeObject(customer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("ser-test"))) {
            Customer customer1 = (Customer) stream.readObject();
            System.out.println(customer1);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
