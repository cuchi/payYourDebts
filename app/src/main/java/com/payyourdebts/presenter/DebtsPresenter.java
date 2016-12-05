package com.payyourdebts.presenter;

import com.payyourdebts.model.Debt;

/**
 * @author Paulo Henrique Cuchi
 */
public interface DebtsPresenter {
    void createDebt();
    void deleteDebt(Debt debt);
    void refresh();
}
