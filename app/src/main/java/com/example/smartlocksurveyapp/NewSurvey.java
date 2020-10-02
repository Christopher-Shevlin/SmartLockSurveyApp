package com.example.smartlocksurveyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class NewSurvey extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_survey);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);

    }

    public void  ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);

    }

    public void ClickNewSurvey(View view){
        recreate();

    }

    public void ClickHistoricalSurveys(View view){
        MainActivity.redirectActivity(this,HistoricalSurveys.class);

    }

    public void ClickFloorPlans(View view){
        MainActivity.redirectActivity(this,FloorPlans.class);
    }

    public void ClickVideoWalkthrough(View view){
        MainActivity.redirectActivity(this,VideoWalkthrough.class);
    }

    public void ClickLogout(View view){
        MainActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}