DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO products (title, cost) VALUES
('potato', 100),
('cucumber', 200),
('tomato', 300),
('doter', 400),
('corn', 500);

DROP TABLE IF EXISTS clients CASCADE;
CREATE TABLE clients (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO clients (name) VALUES
('Kirill'),
('Anton'),
('Alexey'),
('Papich'),
('Semadog'),
('Liza'),
('John'),
('Andrew'),
('Max'),
('Igor');

DROP TABLE IF EXISTS clients_products CASCADE;
CREATE TABLE clients_products (client_id integer REFERENCES clients (id) ON DELETE CASCADE, product_id integer REFERENCES products (id) ON DELETE CASCADE);
INSERT INTO clients_products VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(2,1),
(2,2),
(2,3),
(3,3),
(3,1),
(4,3);


