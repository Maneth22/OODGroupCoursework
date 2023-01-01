package FuelManagementSystem;

import java.io.IOException;

public class cal {
    public static void main(String[] args) throws IOException {
        Customer c= new Customer("awd",2,false,"awd","wad",null);
        System.out.println(c.getCustomerNo());
        c.setCustomerNo();
        System.out.println(c.getCustomerNo());
    }
}
