package com.rubydev.basketcourtrgb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    Button btnCreate;
    EditText edtTeamA, edtTeamB;
    String teamA, teamB;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        edtTeamA = (EditText) findViewById(R.id.edtTeamA);
        edtTeamB = (EditText) findViewById(R.id.edtTeamB);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
                teamA = edtTeamA.getText().toString();
                teamB = edtTeamB.getText().toString();
                i.putExtra("teamA", teamA);
                i.putExtra("teamB", teamB);
                Log.i("Test", teamA + teamB);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                returnIntent.putExtra("scoreA", data.getIntExtra("scoreA",0));
                returnIntent.putExtra("scoreB", data.getIntExtra("scoreB",0));

                returnIntent.putExtra("teamA", teamA);
                returnIntent.putExtra("teamB", teamB);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
