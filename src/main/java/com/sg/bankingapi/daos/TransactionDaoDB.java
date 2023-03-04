//FUTURE DEVELOPMENT
package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
public class TransactionDaoDB implements TransactionDao {
    @Autowired
    private JdbcTemplate jdbc;

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
    @Transactional
    public Transaction addTransaction(Transaction transaction) {
        final String INSERT_TRANSACTION = "INSERT INTO Transaction(trans_type, account_number, trans_date, amount, total, pending_flag)" +
                "VALUES(?, ?, ?, ?, ?,?)";
        jdbc.update(INSERT_TRANSACTION,
                transaction.getTrans_type(),
                transaction.getAccount_number(),
                transaction.getTrans_date(),
                transaction.getAmount(),
                transaction.getTotal(),
                transaction.getPending_flag());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
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
    @Transactional
    public void deleteTransactionById(int trans_id) {
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
            transaction.setAmount((rs.getDouble("amount")));
            transaction.setTotal(rs.getDouble("total"));
            transaction.setPending_flag(rs.getBoolean("pending_flag"));

            return transaction;
            //todo Start here with completing the mapper for Transaction, implement the service layer and input
            //todo validation, complete testing, and research a customized Bootstrap theme
            //todo Complete TransactionDaoDB to incorporate bridge table see Step 6: Course DAO Implementation of the
            //todo Code-Along: JDBC Template and Thymeleaf
        }
    }
}
