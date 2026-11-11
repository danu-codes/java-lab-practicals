
package carrental;

public class Car {
    private String carName;
    private int carId;
    private double rentPerHour;
    
    public Car(String carName, int carId, double rentPerHour)
    {
        setCarName(carName);
        setCarId(carId);
        setRentPerHour(rentPerHour);
    }
    
    public String getCarName()
    {
        return carName;
    }      
    public double getRentPerHour()
    {
        return rentPerHour;
    }
    public int getCarId()
    {
        return carId;
    }
    
    public void setCarName(String carName)
    {
        this.carName = carName;
    }   
    public void setRentPerHour(double rentPerHour)
    {
        this.rentPerHour = rentPerHour;
    }
    public void setCarId(int carId)
    {
        this.carId = carId;
    }
}
