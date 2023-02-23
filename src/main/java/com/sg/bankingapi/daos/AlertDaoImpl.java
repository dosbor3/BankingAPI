package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Alert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AlertDaoImpl implements AlertDao{
    /**
     * @param alert_id
     * @return the alert specified by the param alert_id
     */
    @Override
    public Alert getAlertById(String alert_id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Alert> getAllAlerts() {
        return null;
    }

    /**
     * @param alert
     * @return
     */
    @Override
    public Alert addAlert(Alert alert) {
        return null;
    }

    @Override
    public void updateAlert(Alert alert) {

    }

    @Override
    public void deleteAlertById(String alert_id) {

    }

    @Override
    public List<Alert> getAllAlertsForCustomer(String customer_id) {
        return null;
    }

    @Override
    public List<Alert> getAllAlertsForAccount(String account_number) {
        return null;
    }

    @Override
    public void whenBalance(BigDecimal balance_threshold) {

    }

    @Override
    public void accountBalance(BigDecimal account_balance) {

    }

    @Override
    public void getAllAlertsForDate(LocalDate date) {

    }


}
