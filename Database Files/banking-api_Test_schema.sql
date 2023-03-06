DROP DATABASE IF EXISTS bankingApiDBTest;

CREATE DATABASE bankingApiDBTest;

USE bankingApiDBTest;

CREATE TABLE Customer (
	customer_number INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50), 
    last_name VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(50),
    email VARCHAR(100),     
    isActive BOOLEAN
);

CREATE TABLE Transaction (
	 trans_id INT PRIMARY KEY AUTO_INCREMENT,
     trans_type INT, 
     trans_date DATE,
	 amount DECIMAL,
     total DECIMAL,
     pending_flag BOOLEAN  	
);

CREATE TABLE Account (
	account_number INT PRIMARY KEY AUTO_INCREMENT, 
    customer_number INT NOT NULL, 
    current_balance DOUBLE,
    available_balance DOUBLE,
    account_category VARCHAR(50), 
    isActive BOOLEAN,
    FOREIGN KEY fk_Transaction_Customer (customer_number)
		REFERENCES Customer(customer_number)
);

CREATE TABLE Account_Tansaction(
	transId INT NOT NULL, 
    accountNo INT NOT NULL, 
    PRIMARY KEY (transId, accountNo),
    FOREIGN KEY (transId) REFERENCES Transaction(trans_id),
    FOREIGN KEY (accountNo) REFERENCES Account(account_number)    
);
