package com.payyourdebts.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author Paulo Henrique Cuchi
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }
}
