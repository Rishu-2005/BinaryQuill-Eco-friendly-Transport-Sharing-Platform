package com.databasesetup.rides;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RiderMain {
    public static void main(String[] args) {
        RidesDAO ridesDAO = new RidesDAOImplementer();
        LocalDateTime scheduledTime = LocalDateTime.of(2024,11,12,12,0,0);
        Timestamp scheduled = Timestamp.valueOf(scheduledTime);
        LocalDateTime startTime = LocalDateTime.of(2024,11,12,14,0,0);
        Timestamp start = Timestamp.valueOf(startTime);
        LocalDateTime endTime = LocalDateTime.of(2024,11,12,17,0,0);
        Timestamp end = Timestamp.valueOf(endTime);
//        RidesData ridesData = new RidesData(1,1,"Delhi","Greater Noida",scheduled,start,end,65,100,"Scheduled");
//        ridesDAO.addrider(ridesData);
        RidesData saveruser = ridesDAO.getrider(1);
        System.out.println(saveruser);
    }
}
