package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.text.html.Option;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail {

    @Column
    private String name;



    @Column
    private String swift;

    public BankAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

}
