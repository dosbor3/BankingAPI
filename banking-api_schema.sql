DROP DATABASE IF EXISTS bankingapidb;

CREATE DATABASE bankingapidb;

USE bankingapidb;

CREATE TABLE Address (
	address_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_number INT NOT NULL, 
	street VARCHAR(75),
	city VARCHAR(50),
	state VARCHAR(25),
	zip VARCHAR(12)    
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

CREATE TABLE AccountType (
	account_type_id INT PRIMARY KEY AUTO_INCREMENT,
    account_type VARCHAR(50),
    account_description VARCHAR(150)
);

CREATE TABLE Account (
	account_number INT PRIMARY KEY AUTO_INCREMENT,
    customer_number INT NOT NULL, 
    current_balance DOUBLE,
    available_balance DOUBLE,
    account_type INT, 
    isActive BOOLEAN,
    FOREIGN KEY fk_Customer_Account (customer_number)
		REFERENCES Customer(customer_number)
);

CREATE TABLE Transactions (
	 trans_id INT PRIMARY KEY AUTO_INCREMENT,
     account_number INT NOT NULL,
     customer_number INT NOT NULL,
     account_type INT NOT NULL, 
     trans_date DATETIME,
	 deposit_amount DECIMAL,
	 withdrawl_amount DECIMAL,
     total DECIMAL,
     pending_flag BOOLEAN,
     FOREIGN KEY fk_Account_Transactions (account_number)
		REFERENCES Account(account_number),
     FOREIGN KEY fk_Customer_Transactions (customer_number)
		REFERENCES Customer(customer_number),
	FOREIGN KEY fk_AccountType_Transactions (account_type)
		REFERENCES AccountType(account_type_id) 
);

