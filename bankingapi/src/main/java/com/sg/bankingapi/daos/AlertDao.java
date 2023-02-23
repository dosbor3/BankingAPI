package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Alert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public interface AlertDao {
    /**
     *
     * @param alert_id
     * @return the alert specified by the param alert_id
     */
    Alert getAlertById(String alert_id);

    /**
     *
     * @return
     */
    List<Alert> getAllAlerts();

    /**
     *
     * @param alert
     * @return
     */
    Alert addAlert(Alert alert);
    void updateAlert(Alert alert);
    void deleteAlertById(String alert_id);
    List<Alert> getAllAlertsForCustomer(String customer_id);
    List<Alert> getAllAlertsForAccount(String account_number);
    void whenBalance(BigDecimal balance_threshold);
    void accountBalance(BigDecimal account_balance);
    void getAllAlertsForDate(LocalDate date);

}
