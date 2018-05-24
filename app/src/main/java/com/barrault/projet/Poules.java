package com.barrault.projet;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class Poules extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poules);

        Toast.makeText(getApplicationContext(),getString(R.string.tourner),Toast.LENGTH_LONG).show();

        //Declaration de la bar d'outils
        Toolbar toolbar = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>HelloSigns </font>"));
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        //Declaration du drawer de navigation
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);


                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.credit:
                                Intent intentCredit = new Intent(Poules.this, Credits.class);
                                startActivity(intentCredit);
                                return true;


                            case R.id.main_home:
                                Intent MainActivity = new Intent(Poules.this, MainActivity.class);
                                startActivity(MainActivity);
                                return true;

                            case R.id.exit:
                                new AlertDialog.Builder(Poules.this)
                                        .setCancelable(true)
                                        .setMessage("Etes vous sûr de vouloir quitter ?")
                                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }})
                                        .setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                PendingIntent pendingIntent = PendingIntent.getActivity(Poules.this, 0, new Intent(Poules.this, MainActivity.class), 0);
                                                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(Poules.this)
                                                        .setSmallIcon(R.drawable.logo)
                                                        .setContentTitle("ESIEA WorldCup")
                                                        .setContentText("Vous venez de quitter l'application.")
                                                        .setContentIntent(pendingIntent)
                                                        .setAutoCancel(true);
                                                notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                                                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(Poules.this);
                                                notificationManager.notify(1, notificationBuilder.build());

                                                moveTaskToBack(true);
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(1);
                                            }
                                        })
                                        .show();
                                return true;

                        }

                        return true;
                    }
                });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}