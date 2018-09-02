package com.example.arpit.getwel;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class grownup extends AppCompatActivity {
    TextView t;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grownup);
        t= (TextView) findViewById(R.id.ori);

        t.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        b1=(Button)findViewById(R.id.firstalso);
        b2=(Button)findViewById(R.id.secalso);
        b3=(Button)findViewById(R.id.thirdalso);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), grownup5lit.class);
                startActivity(i);

            }
        });



    }
}
