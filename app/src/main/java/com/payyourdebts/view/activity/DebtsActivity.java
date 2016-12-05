package com.payyourdebts.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.payyourdebts.model.Debt;
import com.payyourdebts.presenter.DebtsPresenter;
import com.payyourdebts.presenter.DebtsPresenterImpl;
import com.payyourdebts.view.DebtsView;
import com.payyourdebts.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DebtsActivity extends BaseActivity implements DebtsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.debts_list)
    ListView debts;

    private DebtsPresenter presenter;
    private List<Debt> debtsList = new ArrayList<>();
    private DebtsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        this.setContentView(R.layout.activity_debts);
        ButterKnife.bind(this);
        this.setSupportActionBar(toolbar);

        this.presenter = new DebtsPresenterImpl(this);

        this.adapter = new DebtsListAdapter(this, this.debtsList, this.presenter);
        this.debts.setAdapter(this.adapter);
    }

    @OnClick(R.id.add_debt)
    public void onClickAddDebt() {
        this.presenter.createDebt();
    }

    public void navigateToAddDebt() {
        this.startActivityForResult(new Intent(this, AddDebtActivity.class), 0);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void refresh(List<Debt> debts) {
        this.debtsList = debts;
        this.debts.invalidate();
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDebts(List<Debt> debts) {
        this.debtsList = debts;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.presenter.refresh();
        this.debts.invalidate();
        this.adapter.notifyDataSetChanged();
    }
}
