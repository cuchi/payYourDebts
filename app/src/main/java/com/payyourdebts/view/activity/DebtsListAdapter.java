package com.payyourdebts.view.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.payyourdebts.R;
import com.payyourdebts.model.Debt;
import com.payyourdebts.presenter.DebtsPresenter;
import com.payyourdebts.view.DebtsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (C) 2015 - NG Informática
 *
 * @author Paulo Henrique Cuchi
 * @since 05/12/16.
 */
public class DebtsListAdapter extends ArrayAdapter<Debt> {

  private List<Debt> debts;
  private DebtsPresenter presenter;

  public DebtsListAdapter(DebtsView view, List<Debt> objects, DebtsPresenter presenter) {
    super(view.getContext(), 0, objects);
    this.presenter = presenter;
    this.debts = objects;
  }

  @NonNull
  @Override
  public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
    LayoutInflater inflater = LayoutInflater.from(this.getContext());
    ViewHolder viewHolder;

    if (view == null) {
      view = inflater.inflate(R.layout.debt_list_item, viewGroup, false);
      viewHolder = new ViewHolder(view);
      view.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) view.getTag();
    }

    final Debt debt = debts.get(i);

    viewHolder.name.setText(debt.getName());
    viewHolder.amount.setText("R$ " + debt.getValue().setScale(2).toPlainString());
    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View view) {
        presenter.deleteDebt(debt);
        return false;
      }
    });

    return view;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.amount)
    TextView amount;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
