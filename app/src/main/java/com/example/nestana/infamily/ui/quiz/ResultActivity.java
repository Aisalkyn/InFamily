package com.example.nestana.infamily.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.nestana.infamily.R;


public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t = (TextView) findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score) {
            case 0:
                t.setText(R.string.urnot_ready);
                break;
            case 1:
                t.setText(R.string.urnot_ready);
                break;
            case 2:
                t.setText(R.string.urnot_ready);
                break;
            case 3:
                t.setText(R.string.urnot_ready);
                break;
            case 4:
                t.setText(R.string.ur_ready);
                break;
            case 5:
                t.setText(R.string.ur_ready);
                break;
            case 6:
                t.setText(R.string.ur_ready);

                break;
            case 7:
                t.setText(R.string.ur_ready);

                break;
            case 8:
                t.setText(R.string.ur_ready);

                break;
        }
    }


}
