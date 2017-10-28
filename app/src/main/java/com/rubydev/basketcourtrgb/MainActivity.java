package com.rubydev.basketcourtrgb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<Score> listHistory = new ArrayList<>();
    HistoryAdapter adapter;
    RecyclerView rvHistory;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHistory = (RecyclerView) findViewById(R.id.rvHistory);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HistoryAdapter(MainActivity.this, listHistory);
        rvHistory.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(getApplicationContext(), InputActivity.class);
        startActivityForResult(i, REQUEST_CODE);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK){

                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
                Calendar c = Calendar.getInstance();
                String date = dateFormatter.format(c.getTime());

                listHistory.add( new Score(data.getIntExtra("scoreA", 0),
                                data.getIntExtra("scoreB",0),
                                data.getStringExtra("teamA"),
                                data.getStringExtra("teamB"),
                                date
                                )
                        );
                adapter.notifyDataSetChanged();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

}
