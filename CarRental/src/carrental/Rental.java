package carrental;

public class Rental {

    private int rentId;
    private Car car;
    private Tenant tenant;
    private int unit;

    public Rental(int rentId, Car car, Tenant tenant, int unit) {
        setRentalId(rentId);
        setCar(car);
        setTenant(tenant);
        setUnit(unit);
    }

    public void setRentalId(int rentId) {
        this.rentId = rentId;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }

    public int getRentalId() {
        return rentId;
    }

    public Car getCar() {
        return car;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public double calTotalRent() {
        return car.getRentPerHour() * unit;
    }

    @Override
    public String toString() {
        return ("Rental ID : " + getRentalId() + "\nTenant : " + tenant.getTenantName() + "\nCar Name : " + car.getCarName() + "\nHours : "+ unit + "\nRental per Hour : " + car.getRentPerHour() + "\n" + "Total Rent : " + calTotalRent());
    }
}
