package com.payyourdebts.model;

import java.math.BigDecimal;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author Paulo Henrique Cuchi
 */

public class Debt extends RealmObject {
    @PrimaryKey
    private String name;
    private String value;

    public Debt() {}

    public Debt(String name, BigDecimal value) {
        this.name = name;
        this.value = value.toPlainString();
    }

    public BigDecimal getValue() {
        return new BigDecimal(this.value);
    }

    public void setValue(BigDecimal value) {
        this.value = value.toPlainString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
