package com.payyourdebts.presenter;

import com.payyourdebts.model.Debt;
import com.payyourdebts.model.DebtsStore;
import com.payyourdebts.view.DebtsView;

/**
 * @author Paulo Henrique Cuchi
 */
public class DebtsPresenterImpl implements DebtsPresenter {
    private final DebtsView view;
    private final DebtsStore store;

    public DebtsPresenterImpl(DebtsView view) {
        this.store = new DebtsStore();
        this.view = view;
        this.refresh();
    }

    @Override
    public void createDebt() {
        this.view.navigateToAddDebt();
    }

    @Override
    public void deleteDebt(Debt debt) {
        this.store.delete(debt);
        this.view.refresh(this.store.findAll());
        this.view.toast("Dívida deletada!");
    }

    @Override
    public void refresh() {
        this.view.setDebts(store.findAll());
    }

}
