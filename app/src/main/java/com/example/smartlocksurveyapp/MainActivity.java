package com.example.smartlocksurveyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){

        openDrawer(drawerLayout);

    }

    private static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);


    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }
public void ClickNewSurvey (View view){

        redirectActivity(this, NewSurvey.class);
}
public void ClickHistoricalSurveys (View view){

        redirectActivity(this, HistoricalSurveys.class);
}
public void ClickVideoWalkThrough (View view){

        redirectActivity(this, VideoWalkthrough.class);
}
public void ClickFloorPlans (View view){
        redirectActivity(this, FloorPlans.class);
}
public void ClickLogout (View view){
        logout(this);
}

private static void logout(final Activity activity){
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setTitle("Logout");
    builder.setMessage("Confirm");
    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            activity.finishAffinity();
            System.exit(0);
        }
    });
builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
    }
});
builder.show();


}


private static void redirectActivity(Activity activity, Class aClass){
    Intent intent = new Intent(activity, aClass);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    activity.startActivity(intent);
}

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}