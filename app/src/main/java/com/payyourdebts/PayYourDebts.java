package com.payyourdebts;

import android.app.Application;

import io.realm.Realm;

/**
 * @author Paulo Henrique Cuchi
 */

public class PayYourDebts extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}