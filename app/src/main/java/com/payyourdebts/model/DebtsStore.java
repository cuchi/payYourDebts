package com.payyourdebts.model;

import java.util.List;

import io.realm.Realm;

/**
 * @author Paulo Henrique Cuchi
 */

public class DebtsStore {

    Realm realm;

    public DebtsStore() {
        this.realm = Realm.getDefaultInstance();
    }

    public List<Debt> findAll() {
        return this.realm.where(Debt.class).findAllSorted("name");
    }

    public void save(Debt debt) {
        this.realm.beginTransaction();
        this.realm.copyToRealm(debt);
        this.realm.commitTransaction();
    }

    public void clear() {
        this.realm.beginTransaction();
        this.realm.delete(Debt.class);
        this.realm.commitTransaction();
    }

    public void delete(Debt debt) {
        this.realm.beginTransaction();
        Debt toDelete = this.realm.where(Debt.class).equalTo("name", debt.getName()).findFirst();
        if (toDelete != null) {
            toDelete.deleteFromRealm();
        }
        this.realm.commitTransaction();
    }
}
