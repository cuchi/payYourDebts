package com.payyourdebts;

import java.util.List;

public interface DebtsView {
    void setDebts(List<String> debts);

    void showMessage(String message);
}
