DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NULL
);

INSERT INTO users (name, email, password) VALUES
  ('Aliko Dangote', 'ad@mail.com', 'password'),
  ('Bill Gates', 'bg@mail.com', 'password');