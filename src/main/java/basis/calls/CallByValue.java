package basis.calls;

/**
 * 传值调用
 */
public class CallByValue {
    public static void main(String[] args) {
        Customer c1 = new Customer("Justlion");
        some(c1);
        System.out.println(c1.name);

        Customer c2 = new Customer("Justlion");
        other(c2);
        System.out.println(c2.name);

        doService();
    }

    private static void doService() {
        Customer customer = create("Irene");
        System.out.println(customer.name);
    }

    private static Customer create(String irene) {
        Customer c = new Customer(irene);
        return c;

    }

    private static void other(Customer c2) {
        c2 = new Customer("4321");
    }

    private static void some(Customer c1) {
        c1.name = "123";
    }
}
