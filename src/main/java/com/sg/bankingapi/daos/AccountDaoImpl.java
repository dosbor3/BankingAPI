package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    private final JdbcTemplate jdbc;

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Account getAccountByAccountNumber(int account_number) {
        try {
            final String GET_ACCT_BY_ACCT_NO = "SELECT * FROM Account WHERE Account_number = ?";
            Account account = jdbc.queryForObject(GET_ACCT_BY_ACCT_NO, new AccountMapper(), account_number);
            return account;

        }catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    public Account getAccountByCustomerNumber(int customer_number) {
        try {
            final String GET_ACCT_BY_CUST_NO = "SELECT * FROM Account WHERE Customer_number = ?";
            Account account = jdbc.queryForObject(GET_ACCT_BY_CUST_NO, new AccountMapper(), customer_number);
            return account;

        }catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    @Transactional
    public Account addAccount(Account account) {
        final String INSERT_ACCOUNT = "INSERT INTO Account(Customer_number, Current_balance, Available_balance, Account_type, IsActive) VALUES(?,?,?,?,?)";

        jdbc.update(INSERT_ACCOUNT,
                account.getCustomer_number(),
                account.getCurrent_balance(),
                account.getAvailable_balance(),
                account.getAccount_type(),
                account.isActive()
                );

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        account.setAccount_number(newId);
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        final String SELECT_ALL_ACCTS = "SELECT * FROM Account";
        return jdbc.query(SELECT_ALL_ACCTS, new AccountMapper());
    }

    @Override
    public BigDecimal getAvailableBalance(int account_number) {
        final String GET_AVAIL_BAL = "SELECT * FROM Account WHERE Account_number = ?";
        Account account = jdbc.queryForObject(GET_AVAIL_BAL, new AccountMapper(), account_number);

        return account.getAvailable_balance();
    }

    @Override
    public BigDecimal getCurrentBalance(int account_number) {
        final String GET_CURR_BAL = "SELECT * FROM Account WHERE Account_number = ?";
        Account account = jdbc.queryForObject(GET_CURR_BAL, new AccountMapper(), account_number);

        return account.getCurrent_balance();
    }

    @Override
    public void updateAccount(Account account) {
        final String UPDATE_ACCOUNT = "UPDATE Account SET Customer_number, Account_type, IsActive) VALUES(?,?,?)";

        jdbc.update(UPDATE_ACCOUNT,
                account.getCustomer_number(),
                account.getAccount_type(),
                account.isActive()
        );
    }

    @Override
    @Transactional //future production setup
    public void deleteAccountByAccountNumber(String account_number) {
        final String DELETE_ACCOUNT = "DELETE FROM Account WHERE Account_number = ?";
        jdbc.update(DELETE_ACCOUNT, account_number);
    }

    public static class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
            Account account = new Account();
            account.setAccount_number(rs.getInt("Account_number"));
            account.setCustomer_number(rs.getInt("Customer_number"));

            BigDecimal curBal = new BigDecimal(String.valueOf(rs.getDouble("Current_balance")));
            account.setCurrent_balance(curBal);

            BigDecimal availableBal = new BigDecimal(String.valueOf(rs.getDouble("available_balance")));
            account.setAvailable_balance(availableBal);

            account.setAccount_type(rs.getInt("Account_type"));
            account.setActive(rs.getBoolean("IsActive"));
            return account;
        }
    }
}
