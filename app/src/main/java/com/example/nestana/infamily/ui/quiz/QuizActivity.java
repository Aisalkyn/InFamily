package com.example.nestana.infamily.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.nestana.infamily.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    List<String> quesList;
    int score = 0;
    int qid = 0;
    RadioButton rb1;
    RadioButton rb2;
    String currentQ;
    TextView txtQuestion;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rb1 = (RadioButton) findViewById(R.id.radio0);
        rb2 = (RadioButton) findViewById(R.id.radio1);
        List<String> list = new ArrayList<>();
        list.add("1.Давно ли вы думаете об усыновлении опеке? (более полугода)");
        list.add("2.Было ли какое-то событие, которое повлияло на ваше решение?");
        list.add("3.Было ли это событие связано с потерей детей?");
        list.add("4.Был ли у вас опыт в сфере воспитания детей?");
        list.add("5.Изменится ли ваш образ жизни с принятием ребенка в свою семью?");
        list.add("6.Согласен ли ваш супруг супруга на принятие ребенка в семью?");
        list.add("7.Поддерживают ли вас родственники и друзья?");
        list.add("8.Есть ли у вас предпочтения относительно пола, возраста и национальности ребенка?");
        quesList = list;
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textView1);

        butNext = (Button) findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qid < 8) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }


            }
        });
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ);
        qid++;
    }
}
