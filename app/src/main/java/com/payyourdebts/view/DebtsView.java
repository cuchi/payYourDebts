package com.payyourdebts.view;

import android.content.Context;

import com.payyourdebts.model.Debt;

import java.util.List;

public interface DebtsView {
    void setDebts(List<Debt> debts);
    void navigateToAddDebt();
    Context getContext();
    void refresh(List<Debt> debts);
    void toast(String s);
}
