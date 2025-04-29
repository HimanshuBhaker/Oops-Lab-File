CREATE DATABASE BankDB;
USE BankDB;

-- Create Customer table
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(15)
);

-- Create Account table
CREATE TABLE Account (
    account_number INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    account_type VARCHAR(50),
    balance DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- Create Transaction table
CREATE TABLE Transaction (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_number INT,
    transaction_type VARCHAR(50),
    amount DOUBLE,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES Account(account_number)
);
