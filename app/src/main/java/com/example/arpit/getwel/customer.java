package com.example.arpit.getwel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;

public class customer {
    String name;
    String email;
    String phone;
    String address;
String product;
    String amount;
String quantity;
    public customer() {
    }

    public customer(String name, String phone, String address,String product,String quantity,String amount) {
        this.name = name;

        this.phone = phone;
        this.address = address;
this.product=product;
this.quantity=quantity;
this.amount=amount;

    }
    public String getName() {
        return name;
    }



    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getAmount() {
        return amount;
    }
}
