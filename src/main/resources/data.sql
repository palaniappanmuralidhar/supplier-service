
CREATE TABLE suppliers (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    country VARCHAR(255),
    email VARCHAR(255)
);



INSERT INTO suppliers (id, name, country, email) VALUES (1, 'Acme Corp', 'Sweden', 'contact@acme.com');
INSERT INTO suppliers (id, name, country, email) VALUES (2, 'Global Parts', 'Germany', 'info@globalparts.com');
