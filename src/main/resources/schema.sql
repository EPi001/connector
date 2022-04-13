CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL PRIMARY KEY,
    gender VARCHAR(10),
    name VARCHAR(70),
    location VARCHAR(70),
    email VARCHAR(70)
);