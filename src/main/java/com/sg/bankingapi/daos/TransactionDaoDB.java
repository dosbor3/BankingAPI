package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionDaoDB implements TransactionDao {

    private final JdbcTemplate jdbc;

    @Autowired
    public TransactionDaoDB(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    @Override
    public Transaction getAccountTransactionById(int trans_id) {
        try {
            final String GET_TRANS_BY_ID = "SELECT * FROM Transaction WHERE trans_id = ?";
            return jdbc.queryForObject(GET_TRANS_BY_ID, new TransactionMapper(), trans_id);

        }catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Transaction> getAllAccountTransactions() {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsForCustomer(int customer_number) {
        return null;
    }

    @Override
    public List<Transaction> getAllAccountWithdrawlsByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Transaction> getAllAccountDepositsByDate(LocalDate date) {
        return null;
    }

    @Override
    public Transaction addAccountTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public void updateAccountTransaction(Transaction transaction) {

    }

    @Override
    public void deleteAccountTransaction(Transaction transaction) {

    }

    public static final class TransactionMapper implements RowMapper<Transaction> {
        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction transaction = new Transaction();
            return null;
        }
    }
}
