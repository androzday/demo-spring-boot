-- Create Driver Table
CREATE TABLE Driver (
    id INT AUTO_INCREMENT PRIMARY KEY,
    driver_code VARCHAR(7) unique,
    name VARCHAR(100),
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME
);

-- Create Bus Table
CREATE TABLE Bus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number_plate VARCHAR(12),
    type VARCHAR(50),
    driver_id INT,
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME,
    FOREIGN KEY (driver_id) REFERENCES Driver(id)
);

-- Create Stop Table
CREATE TABLE Stop (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME
);

-- Create BusStop Table (junction between Bus and Stop)
CREATE TABLE BusStop (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bus_id INT,
    stop_id INT,
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME,
    FOREIGN KEY (bus_id) REFERENCES Bus(id),
    FOREIGN KEY (stop_id) REFERENCES Stop(id)
);

-- Create Route Table
CREATE TABLE Route (
    id INT AUTO_INCREMENT PRIMARY KEY,
    route_code VARCHAR(5),
    name VARCHAR(100)
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME
);

-- Create RouteStop Table (junction between Route and Stop)
CREATE TABLE RouteStop (
    id INT AUTO_INCREMENT PRIMARY KEY,
    route_id INT,
    stop_id INT,
    stop_order INT,
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME,
    FOREIGN KEY (route_id) REFERENCES Route(id),
    FOREIGN KEY (stop_id) REFERENCES Stop(id)
);

-- Create BusRoute Table (junction between Bus and Route)
CREATE TABLE BusRoute (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bus_id INT,
    route_id INT,
    is_deleted TINYINT(1),
    create_at DATETIME,
    update_at DATETIME,
    FOREIGN KEY (bus_id) REFERENCES Bus(id),
    FOREIGN KEY (route_id) REFERENCES Route(id)
);
