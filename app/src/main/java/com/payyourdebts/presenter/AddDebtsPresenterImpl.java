package com.payyourdebts.presenter;

import com.payyourdebts.R;
import com.payyourdebts.model.Debt;
import com.payyourdebts.model.DebtsStore;
import com.payyourdebts.view.AddDebtView;

import java.math.BigDecimal;

/**
 * @author Paulo Henrique Cuchi
 */

public class AddDebtsPresenterImpl implements AddDebtsPresenter {

    private final AddDebtView view;
    private final DebtsStore store;

    public AddDebtsPresenterImpl(AddDebtView view) {
        this.view = view;
        this.store = new DebtsStore();
    }

    @Override
    public void addDebt(String name, String value) {
        this.store.save(new Debt(name, new BigDecimal(value)));
        this.view.onSuccess(R.string.successful_insert);
    }
}
