CREATE TABLE IF NOT EXISTS users (
    id INT NOT null AUTO_INCREMENT,
    gender VARCHAR(10),
    name VARCHAR(300),
    location VARCHAR(300),
    email VARCHAR(70),
    PRIMARY KEY (id)
);