package com.example.rm0016nc.a365project2;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

    public class MainActivity extends AppCompatActivity {
//        private DrawerLayout mDrawerLayout;
//        private ActionBarDrawerToggle mToogle;
        private static int WELCOME_TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(MainActivity.this, secondactivity.class);
                startActivity(welcome);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, WELCOME_TIMEOUT);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//
//        navigationView.setNavigationItemSelectedListener(this);
//        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//        mDrawerLayout.addDrawerListener(mToogle);
//        mToogle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new App()).commit();
//            navigationView.setCheckedItem(R.id.app);
//        }
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        switch (menuItem.getItemId()) {
//            case R.id.app:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new App()).commit();
//                break;
//            case R.id.preferences:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new Preferences()).commit();
//                break;
//            case R.id.aboutme:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new Aboutme()).commit();
//                break;
//        }
//
//        mDrawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(mToogle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
    }
}
