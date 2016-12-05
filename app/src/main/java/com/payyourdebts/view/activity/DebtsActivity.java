package com.payyourdebts.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.payyourdebts.model.Debt;
import com.payyourdebts.presenter.DebtsPresenter;
import com.payyourdebts.presenter.DebtsPresenterImpl;
import com.payyourdebts.view.DebtsView;
import com.payyourdebts.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DebtsActivity extends BaseActivity implements DebtsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.debts_list)
    TextView debts;

    private DebtsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_debts);
        this.setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        this.presenter = new DebtsPresenterImpl(this);
    }

    @OnClick(R.id.add_debt)
    public void onClickAddDebt() {
        this.presenter.createDebt();
    }

    public void navigateToAddDebt() {
        this.startActivity(new Intent(this, AddDebtActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(R.menu.menu_debts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setDebts(List<Debt> debts) {
        StringBuilder debtsList = new StringBuilder("Debts:\n\n");
        for (Debt debt : debts) {
            debtsList.append(debt.getName())
                .append(" - ")
                .append(debt.getValue().toString())
                .append("\n");
        }
        this.debts.setText(debtsList.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.presenter.refresh();
    }
}
