package com.tutorials.hp.mysqlgridviewswiperefresh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.tutorials.hp.mysqlgridviewswiperefresh.m_MySQL.Downloader;


public class MainActivity extends AppCompatActivity {

    static String urlAddress="http://10.0.2.2/android/spacecraft_select_images.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        final GridView gv= (GridView) findViewById(R.id.gv);
        final SwipeRefreshLayout swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swiper);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(MainActivity.this,urlAddress,gv,swipeRefreshLayout).execute();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Downloader(MainActivity.this,urlAddress,gv,swipeRefreshLayout).execute();

            }
        });


    }


}
