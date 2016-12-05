package com.payyourdebts.view;

import com.payyourdebts.model.Debt;

import java.util.List;

public interface DebtsView {
    void setDebts(List<Debt> debts);
    void navigateToAddDebt();
}
