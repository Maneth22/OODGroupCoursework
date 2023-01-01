package FuelManagementSystem;

import java.io.IOException;

public interface FuelDispenseManager {
    public double checkFuelAmount();
    void restockFuel(double fuelAmount) throws IOException;
}
