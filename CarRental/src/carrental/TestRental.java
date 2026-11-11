
package carrental;

import java.util.ArrayList;

public class TestRental {
    
    public static void main(String[] args) {
        Car car1 = new Car("Estima", 231, 150.00);
        Car car2 = new Car("Vios", 345, 80.00);
        Car car3 = new Car("Viva", 654, 50.00);
        
        
        Tenant tenant1 = new Tenant(90, "Raihana");
        Tenant tenant2 = new Tenant(91, "Boo Lee");
        Tenant tenant3 = new Tenant(95, "Sita A/P Roki");
        
        ArrayList<Rental> rental = new  ArrayList<>();
        rental.add(new Rental(1, car1, tenant1, 2));
        rental.add(new Rental(2, car2, tenant2, 4));
        rental.add(new Rental(3, car3, tenant3, 5));
        
        for(Rental details:rental)
        {
            System.out.println(details.toString());
            System.out.println();
        }
    }
    
}
