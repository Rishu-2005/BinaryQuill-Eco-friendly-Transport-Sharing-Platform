package com.databasesetup.driver;

public interface DriverDAO {
    void addDriver(DriverData driver);

    DriverData getDriver(int driverId);

    void deleteDriver(DriverData driver);
}
