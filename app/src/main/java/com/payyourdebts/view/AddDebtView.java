package com.payyourdebts.view;

/**
 * @author Paulo Henrique Cuchi
 */
public interface AddDebtView {
    void onError(String message);
    void onSuccess(int messageResId);
    void toast(String s);
}
