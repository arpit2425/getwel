package com.example.arpit.getwel;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    ImageView s1,s2,s3,s4,s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        drawer=(DrawerLayout)findViewById( R.id.drawer );
        s1=(ImageView)findViewById(R.id.slide1);
        s2=(ImageView)findViewById(R.id.slide2);
        s3=(ImageView)findViewById(R.id.slide3);
        s4=(ImageView)findViewById(R.id.slide4);
        s5=(ImageView)findViewById(R.id.slide5);


        mToggle=new ActionBarDrawerToggle( this,drawer,R.string.open,R.string.close );
        drawer.addDrawerListener( mToggle );
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        NavigationView navigationView=(NavigationView)findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(this);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, aqua1.class));
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, coughcure.class));
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, abc200.class));
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, beachwel.class));
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, nefrovetds.class));
            }
        });

    }
    @Override
    public void onBackPressed(){

        System.exit(0);
        super.onBackPressed();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

       if(mToggle.onOptionsItemSelected( item ))
        {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.Products) {
            drawer.closeDrawers();
            startActivity(new Intent(MainActivity.this, list.class));

        }     else if(id==R.id.home) {
            drawer.closeDrawers();
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }

        else if(id==R.id.Findus) {
            drawer.closeDrawers();
            startActivity(new Intent(MainActivity.this, MapsActivity.class));
        }
        else if(id==R.id.Contactus) {
            drawer.closeDrawers();
            startActivity(new Intent(MainActivity.this, contact.class));
        }
        else if(id==R.id.about) {
            drawer.closeDrawers();
            startActivity(new Intent(MainActivity.this, about.class));
        }
        else if(id==R.id.Close)
            drawer.closeDrawers();
        else if(id==R.id.exit)
            System.exit(0);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dot,menu);
        return true;
    }

}
