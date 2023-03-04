DROP DATABASE IF EXISTS bankingapidb;

CREATE DATABASE bankingapidb;

USE bankingapidb;

CREATE TABLE Customer (
	customer_number INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50), 
    last_name VARCHAR(50),
    address_id VARCHAR(100),
    phone VARCHAR(50),
    email VARCHAR(100),     
    isActive BOOLEAN
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
     trans_date DATE,
	 amount DECIMAL,
     total DECIMAL,
     pending_flag BOOLEAN,
     FOREIGN KEY fk_Account_Transaction (account_number)
		REFERENCES Account(account_number)  	
);

CREATE TABLE Transaction_Customer(
	transId INT NOT NULL, 
    customerNo INT NOT NULL, 
    PRIMARY KEY (transId, customerNo),
    FOREIGN KEY (transId) REFERENCES Transaction(trans_id),
    FOREIGN KEY (customerNo) REFERENCES Account(account_number)    
);
