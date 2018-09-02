package com.example.arpit.getwel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class register extends AppCompatActivity {
    EditText nam, phone, pass;
    Button register;
    TextView log;
    DatabaseReference db;

    String product, amount;
    String quantity;
    SharedPreferences sharedpreferences;
    ConnectionDitector ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nam = (EditText) findViewById(R.id.name);

        phone = (EditText) findViewById(R.id.phone);
        pass = (EditText) findViewById(R.id.pas);

        register = (Button) findViewById(R.id.register);
        db = FirebaseDatabase.getInstance().getReference("Customer");
        ob = new ConnectionDitector(this);

        sharedpreferences = getSharedPreferences("My_pref", Context.MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addon();
            }
        });
    }

    public void addon() {
        String key = db.push().getKey();
        String name = nam.getText().toString().trim();

        String num = phone.getText().toString().trim();
        String add = pass.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(num) && !TextUtils.isEmpty(add)) {
            if (ob.isConnected()) {

                product = sharedpreferences.getString("product", null);
                quantity = sharedpreferences.getString("Quantity", null);
                amount = sharedpreferences.getString("price", null);
                customer cus = new customer(name, num, add, product, quantity, amount);
                db.child(key).setValue(cus);
                finish();
                startActivity(new Intent(register.this, login.class));
            }
            else
                Toast.makeText(getApplicationContext(),"Please check Your Internet Connetcion",Toast.LENGTH_LONG).show();

        }

    }
}
