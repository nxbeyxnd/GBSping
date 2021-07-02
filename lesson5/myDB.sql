DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO product (title, cost) VALUES
('potato', 100),
('cucumber', 200),
('tomato', 300),
('doter', 400),
('corn', 500);