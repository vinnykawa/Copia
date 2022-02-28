package com.vinnykawa.copia.model;

public class Transaction {
    private String ref;
    private int amount;

    public Transaction(String ref, int amount) {
        this.ref = ref;
        this.amount = amount;
    }

    public String getRef() {
        return ref;
    }

    public int getAmount() {
        return amount;
    }

}
