package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TransactionDaoDB implements TransactionDao {
    private final JdbcTemplate jdbc;
    @Autowired
    public TransactionDaoDB(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    @Override
    public Transaction getTransactionById(int trans_id) {
        try {
            final String GET_TRANS_BY_ID = "SELECT * FROM Transaction WHERE trans_id = ?";
            return jdbc.queryForObject(GET_TRANS_BY_ID, new TransactionMapper(), trans_id);

        }catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        final String GET_ALL_ACCT_TRANS = "SELECT * FROM Transaction";
        return jdbc.query(GET_ALL_ACCT_TRANS, new TransactionMapper());
    }

    @Override
    public List<Transaction> getAllTransactionsByAccountNumber(int account_number) {
        final String GET_ALL_TRANS_FOR_ACCT = "SELECT * FROM Transaction WHERE account_number = ?";
        return jdbc.query(GET_ALL_TRANS_FOR_ACCT, new TransactionMapper());
    }

    /**
     * This method will return a List of ALL transactions made by the customer object with the specific customer_number
     *
     * @param customer_number@return, a List of all transactions made by a given customer
     */
    @Override
    public List<Transaction> getAllTransactionsByCustomerNumber(int customer_number) {
        return null;
    }

    /**
     * This method will return a list of transactions made by a customer for a specific type of transaction based on the
     * trans_type variable
     *
     * @param customer_number
     * @param account_number
     * @param trans_type
     * @return List structure that holds a specific transaction type for a customer
     */
    @Override
    public List<Transaction> getAllTransactionsTypeByCustomerNumber(int customer_number, int account_number, int trans_type) {
        return null;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        final String INSERT_TRANSACTION = "INSERT INTO Transaction(trans_type, account_number, trans_date, amount, total, pending_flag" +
                "VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_TRANSACTION,
                transaction.getTrans_type(),
                transaction.getAmount(),
                transaction.getTrans_date(),
                transaction.getAmount(),
                transaction.getTotal(),
                transaction.getPending_flag());
        int newId = jdbc.queryForObject("SELECT_LAST_INSERT_ID()", Integer.class);
        transaction.setTrans_id(newId);

        return  transaction;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        final String UPDATE_TRANSACTION = "UPDATE Transaction SET trans_type = ?, account_number = ?, trans_date = ?," +
                " amount = ?, total = ?, pending_flag = ? WHERE trans_id = ?";
        jdbc.update(UPDATE_TRANSACTION,
                transaction.getTrans_id(),
                transaction.getTrans_type(),
                transaction.getAccount_number(),
                transaction.getTrans_date(),
                transaction.getAmount(),
                transaction.getTotal(),
                transaction.getPending_flag());
    }

    @Override
    public void deleteTransaction(int trans_id) {
        final String DELETE_TRANSACTION = "DELETE FROM Transaction WHERE trans_id = ?";
        jdbc.update(DELETE_TRANSACTION, trans_id);

    }

    public static final class TransactionMapper implements RowMapper<Transaction> {
        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction transaction = new Transaction();
            transaction.setTrans_id(rs.getInt("trans_id"));
            transaction.setTrans_type(rs.getInt("trans_type"));
            transaction.setAccount_number(rs.getInt("account_number"));
            transaction.setTrans_date((rs.getDate("trans_date").toLocalDate()));
            transaction.setAmount((rs.getBigDecimal("amount")));
            transaction.setTotal(rs.getBigDecimal("total"));
            transaction.setPending_flag(rs.getBoolean("pending_flag"));

            return transaction;
            //todo Start here with completing the mapper for Transaction, implement the service layer and input
            //todo validation, complete testing, and research a customized Bootstrap theme
            //todo Complete TransactionDaoDB to incorporate bridge table see Step 6: Course DAO Implementation of the
            //todo Code-Along: JDBC Template and Thymeleaf
        }
    }
}
