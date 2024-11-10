CREATE TABLE User(
                     accountid int Primary Key auto_increment,
                     firstname varchar(30),
                     midname varchar(30),
                     lastname varchar(30),
                     email varchar (50),
                     phone bigint,
                     dob date,
                     passwd varchar(20),
                     acc_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Driver_Details (
                                driver_id INT PRIMARY KEY AUTO_INCREMENT,
                                user_id INT UNIQUE,
                                vehicle_type ENUM('Car', 'Bike','Scooter') NOT NULL,
                                vehicle_fuel ENUM('Petrol','Diesel','Electic') NOT NULL,
                                vehicle_model VARCHAR(50) NOT NULL,
                                vehicle_year YEAR,
                                rc_no VARCHAR(15) UNIQUE NOT NULL,
                                driver_license VARCHAR(255),
                                FOREIGN KEY (user_id) REFERENCES User(accountid)
);

CREATE TABLE Rides (
                       ride_id INT PRIMARY KEY AUTO_INCREMENT,
                       driver_id INT,
                       rider_id INT,
                       pickup_location VARCHAR(255) NOT NULL,
                       dropoff_location VARCHAR(255) NOT NULL,
                       scheduled_time DATETIME,
                       actual_start_time DATETIME,
                       actual_end_time DATETIME,
                       distance FLOAT,
                       fare DECIMAL(10, 2),
                       status ENUM('Scheduled', 'In Progress', 'Completed', 'Canceled') DEFAULT 'Scheduled',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (driver_id) REFERENCES Driver_Details(driver_id),
                       FOREIGN KEY (rider_id) REFERENCES User(accountid)
);