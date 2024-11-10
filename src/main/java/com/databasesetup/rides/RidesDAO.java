package com.databasesetup.rides;

public interface RidesDAO {
    void addrider (RidesData rides);
    RidesData getrider (int rideId);
    void deleteride (int rideId);
}
