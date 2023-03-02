DROP DATABASE IF EXISTS bankingApiDBTest;

CREATE DATABASE bankingApiDBTest;

USE bankingApiDBTest;

CREATE TABLE Address (
	address_id INT PRIMARY KEY AUTO_INCREMENT,
	street VARCHAR(75),
	city VARCHAR(50),
	state VARCHAR(25),
	zipcode VARCHAR(12)
);

CREATE TABLE Customer (
	customer_number INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50), 
    last_name VARCHAR(50),
    address_id INT,
    phone VARCHAR(50),
    email VARCHAR(100),     
    isActive BOOLEAN,
    FOREIGN KEY fk_Address_Customer (address_id)
		REFERENCES Address(address_id)
);

CREATE TABLE Account (
	account_number INT PRIMARY KEY AUTO_INCREMENT,    
    customer_number INT,
    current_balance DOUBLE,
    available_balance DOUBLE,
    account_category VARCHAR(50), 
    isActive BOOLEAN,
    FOREIGN KEY fk_Customer_Account (customer_number)
		REFERENCES Customer(customer_number)
);

CREATE TABLE Transaction (
	 trans_id INT PRIMARY KEY AUTO_INCREMENT,
     trans_type INT, 
     account_number INT NOT NULL,          
     trans_date DATETIME,
	 amount DECIMAL,
     total DECIMAL,
     pending_flag BOOLEAN,
     FOREIGN KEY fk_Account_Transactions (account_number)
		REFERENCES Account(account_number)  	
);

CREATE TABLE Account_Customer(
	account_number INT NOT NULL, 
    customer_number INT NOT NULL, 
    trans_type INT,
    PRIMARY KEY(account_number, customer_number),
    FOREIGN KEY (account_number) REFERENCES Account(account_number),
    FOREIGN KEY (customer_number) REFERENCES Customer(customer_number)
);