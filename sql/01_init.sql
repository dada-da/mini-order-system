DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS products;

DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS order_items;

CREATE TABLE IF NOT EXISTS users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS products
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(250),
    price      FLOAT,
    stock      INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS orders
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    user_id      INT,
    total_amount FLOAT,
    status       ENUM ('done', 'ongoing', 'failed') NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS order_item
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    order_id      INT,
    product_id    INT,
    quantity      INT,
    price_at_time FLOAT
);
