package com.rubydev.basketcourtrgb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvTeamA, tvTeamB, tvScoreA, tvScoreB;
    Button btnSave, btnReset;
    Button btnAdd3A, btnMin3A, btnAdd2A, btnMin2A, btnAdd1A, btnMin1A;
    Button btnAdd3B, btnMin3B, btnAdd2B, btnMin2B, btnAdd1B, btnMin1B;
    private int scoreA, scoreB;
    String teamA, teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tvTeamA = (TextView) findViewById(R.id.tvTeamA);
        tvTeamB = (TextView) findViewById(R.id.tvTeamB);
        tvScoreA = (TextView) findViewById(R.id.tvScoreA);
        tvScoreB = (TextView) findViewById(R.id.tvScoreB);
        btnSave  = (Button) findViewById(R.id.btnSave);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnAdd3A = (Button) findViewById(R.id.btnAdd3A);
        btnMin3A = (Button) findViewById(R.id.btnMin3A);
        btnAdd2A = (Button) findViewById(R.id.btnAdd2A);
        btnMin2A = (Button) findViewById(R.id.btnMin2A);
        btnAdd1A = (Button) findViewById(R.id.btnAdd1A);
        btnMin1A = (Button) findViewById(R.id.btnMin1A);
        btnAdd3B = (Button) findViewById(R.id.btnAdd3B);
        btnMin3B = (Button) findViewById(R.id.btnMin3B);
        btnAdd2B = (Button) findViewById(R.id.btnAdd2B);
        btnMin2B = (Button) findViewById(R.id.btnMin2B);
        btnAdd1B = (Button) findViewById(R.id.btnAdd1B);
        btnMin1B = (Button) findViewById(R.id.btnMin1B);

        btnAdd3A.setOnClickListener(this);
        btnMin3A.setOnClickListener(this);
        btnAdd2A.setOnClickListener(this);
        btnMin2A.setOnClickListener(this);
        btnAdd1A.setOnClickListener(this);
        btnMin1A.setOnClickListener(this);
        btnAdd3B.setOnClickListener(this);
        btnMin3B.setOnClickListener(this);
        btnAdd2B.setOnClickListener(this);
        btnMin2B.setOnClickListener(this);
        btnAdd1B.setOnClickListener(this);
        btnMin1B.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        Intent i = getIntent();
        teamA = i.getStringExtra("teamA");
        teamB = i.getStringExtra("teamB");
        tvTeamA.setText(teamA);
        tvTeamB.setText(teamB);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd1A:
                scoreA = scoreA + 1;
                break;
            case R.id.btnAdd2A:
                scoreA = scoreA + 2;
                break;
            case R.id.btnAdd3A:
                scoreA = scoreA + 3;
                break;
            case R.id.btnMin1A:
                if (scoreA > 0){
                    scoreA = scoreA - 1;
                }
                break;
            case R.id.btnMin2A:
                if (scoreA >= 2){
                    scoreA = scoreA - 2;
                }
                break;
            case R.id.btnMin3A:
                if (scoreA >= 3){
                    scoreA = scoreA - 3;
                }
                break;
            case R.id.btnAdd1B:
                scoreB = scoreB + 1;
                break;
            case R.id.btnAdd2B:
                scoreB = scoreB + 2;
                break;
            case R.id.btnAdd3B:
                scoreB = scoreB + 3;
                break;
            case R.id.btnMin1B:
                if (scoreB > 0){
                    scoreB = scoreB - 1;
                }
                break;
            case R.id.btnMin2B:
                if (scoreB >= 2){
                    scoreB = scoreB - 2;
                }
                break;
            case R.id.btnMin3B:
                if (scoreB >= 3){
                    scoreB = scoreB - 3;
                }
                break;
            case R.id.btnReset:
                scoreA =0;
                scoreB =0;
                break;
            case R.id.btnSave:
                Intent returnIntent = new Intent();
                returnIntent.putExtra("scoreA", scoreA);
                returnIntent.putExtra("scoreB", scoreB);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
                break;
        }
        tvScoreA.setText(String.valueOf(scoreA));
        tvScoreB.setText(String.valueOf(scoreB));
    }
}
