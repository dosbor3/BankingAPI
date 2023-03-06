package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Account;
import com.sg.bankingapi.models.Customer;
import com.sg.bankingapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoDB implements AccountDao {
   @Autowired
    private JdbcTemplate jdbc;
   @Autowired
   CustomerDao customerDao;
   @Autowired
   TransactionDao transactionDao;

    @Override
    public Account getAccountByAccountNumber(int account_number) {
        try {
            final String SELECT_ACCT_BY_ACCT_NO = "SELECT * FROM Account WHERE account_number = ?";
            return jdbc.queryForObject(SELECT_ACCT_BY_ACCT_NO, new AccountMapper(), account_number);

        }catch (DataAccessException ex){
            return null;
        }
    }

    private List<Transaction> getTransactionsForAccount(int acct_no) {
        final String SELECT_TRANSACTIONS_FOR_ACCOUNT = "SELECT  t.* FROM transaction t"
        +" JOIN Transaction_Account ta ON ta.transId = t.trans_id WHERE ta.accountNo = ?";
        return jdbc.query(SELECT_TRANSACTIONS_FOR_ACCOUNT, new TransactionDaoDB.TransactionMapper(), acct_no);
    }

    @Override
    public Account getAccountByCustomerNumber(int customer_number) {
        try {
            final String GET_ACCT_BY_CUST_NO = "SELECT * FROM Account WHERE customer_number = ?";
            Account account = jdbc.queryForObject(GET_ACCT_BY_CUST_NO, new AccountMapper(), customer_number);
            return account;

        }catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    @Transactional
    public Account addAccount(Account account) {
        final String INSERT_ACCOUNT = "INSERT INTO Account(customer_number, current_balance, available_balance," +
                "account_category, isActive) VALUES(?,?,?,?,?)";

        jdbc.update(INSERT_ACCOUNT,
                account.getCustomer_number(),
                account.getCurrent_balance(),
                account.getAvailable_balance(),
                account.getAccount_category(),
                account.isActive());

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
    public void updateAccount(Account account) {
        final String UPDATE_ACCOUNT = "UPDATE Account SET customer_number = ?, current_balance = ?, available_balance = ?, "
                + "account_category = ?, isActive = ? " +
                "WHERE account_number = ?";

        jdbc.update(UPDATE_ACCOUNT,
                account.getCustomer_number(),
                account.getCurrent_balance(),
                account.getAvailable_balance(),
                account.getAccount_category(),
                account.isActive(),
                account.getAccount_number());
    }

    @Override
    @Transactional
    public void deleteAccountByAccountNumber(int account_number) {
        final String DELETE_ACCOUNT = "DELETE FROM Account WHERE account_number = ?";
        jdbc.update(DELETE_ACCOUNT, account_number);
    }
    public static class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
            Account account = new Account();
            account.setAccount_number(rs.getInt("account_number"));
            account.setCustomer_number(rs.getInt("customer_number"));
            account.setCurrent_balance (rs.getDouble("current_balance"));
            account.setAvailable_balance(rs.getDouble("available_balance"));
            account.setAccount_category(rs.getInt("account_category"));
            account.setActive(rs.getBoolean("isActive"));
            return account;
        }
    }
}
