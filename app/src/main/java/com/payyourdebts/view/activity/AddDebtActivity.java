package com.payyourdebts.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import com.payyourdebts.R;
import com.payyourdebts.presenter.AddDebtsPresenter;
import com.payyourdebts.presenter.AddDebtsPresenterImpl;
import com.payyourdebts.view.AddDebtView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Paulo Henrique Cuchi
 */

public class AddDebtActivity extends BaseActivity implements AddDebtView {

    @BindView(R.id.name)
    EditText nameField;

    @BindView(R.id.value)
    EditText valueField;

    private AddDebtsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_add_debt);
        ButterKnife.bind(this);

        this.presenter = new AddDebtsPresenterImpl(this);
    }

    @OnClick(R.id.insert)
    public void insertDebt() {
        final String name = nameField.getText().toString();
        final String value = valueField.getText().toString();
        this.presenter.addDebt(name, value);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSuccess(int messageResId) {
        final Intent data = this.getIntent();
        data.putExtra("message", messageResId);
        this.setResult(RESULT_OK, data);
        this.finish();
    }

    @Override
    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
