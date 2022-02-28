package com.vinnykawa.copia.model;


public class Receipt {
    private String id;
    private int amountToBePaid;

    public Receipt(String id, int amountToBePaid) {
        this.id = id;
        this.amountToBePaid = amountToBePaid;
    }

    public String getId() {
        return id;
    }


    public int getAmountToBePaid() {
        return amountToBePaid;
    }

}
