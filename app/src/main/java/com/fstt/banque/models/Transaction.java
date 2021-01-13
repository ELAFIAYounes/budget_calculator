package com.fstt.banque.models;

import java.util.Date;

public class Transaction {
    private  int id;
    private double prix;
    private Date dateTransaction;

    public Transaction(int id, double prix, Date dateTransaction) {
        this.id = id;
        this.prix = prix;
        this.dateTransaction = dateTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
