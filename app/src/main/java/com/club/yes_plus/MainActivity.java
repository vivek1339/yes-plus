package com.club.yes_plus;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth mauth=FirebaseAuth.getInstance();
        if(mauth.getCurrentUser()==null)
        {
            Intent i=new Intent(this,Login_Activity.class);
            startActivity(i);
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Handle navigation view item clicks here.
                        int id = menuItem.getItemId();
                        System.out.println(id);
                        if (id == R.id.home) {
                            // Handle the camera action
                            setContentView(R.layout.activity_member);
                        }
                        else if (id == R.id.Events) {
                            //Intent intent = new Intent(MainActivity.this, events.class);
                            //startActivity(intent);
                        }
                        else if (id == R.id.Projects) {
                            //Intent intent=new Intent(MainActivity.this,Projects.class);
                            //startActivity(intent);
                        }
                        else if(id == R.id.Members) {
                            Intent intent=new Intent(MainActivity.this,Member.class);
                            startActivity(intent);
                            // In future to make the complete application only on one activity
                            //setContentView(R.layout.activity_member);
                        }
                        else if(id==R.id.About_us)
                        {
                            Intent intent=new Intent(MainActivity.this,about_us.class);
                            startActivity(intent);
                        }
                        else if(id==R.id.Follow_up)
                        {
                            //Intent intent=new Intent(MainActivity.this,followup.class);
                            //startActivity(intent);
                        }
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }

}
