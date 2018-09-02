package com.example.arpit.getwel;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class about extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        drawer=(DrawerLayout)findViewById( R.id.drawer );
        mToggle=new ActionBarDrawerToggle( this,drawer,R.string.open,R.string.close );
        drawer.addDrawerListener( mToggle );
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        NavigationView navigationView=(NavigationView)findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(this);
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
            startActivity(new Intent(getApplicationContext(), list.class));

        }     else if(id==R.id.home) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        else if(id==R.id.Findus) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
        }
        else if(id==R.id.about) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), about.class));
        }
        else if(id==R.id.Contactus) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), contact.class));
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
