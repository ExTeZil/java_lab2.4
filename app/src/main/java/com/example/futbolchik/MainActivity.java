package com.example.futbolchik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.futbolchik.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nickname = getIntent().getStringExtra("nickname");
        String email = getIntent().getStringExtra("email");

        TextView nick = (TextView) findViewById(R.id.textView6);
        nick.setText(nickname);
        System.out.println(nickname);

        List<Integer> fc = new ArrayList<>();
        fc.add(R.drawable.psg);
        fc.add(R.drawable.mu);
        fc.add(R.drawable.borussia);
        fc.add(R.drawable.chelsea);
        fc.add(R.drawable.liverpoll);
        fc.add(R.drawable.manchestercity);
        fc.add(R.drawable.yuvantus);
        fc.add(R.drawable.unnamed);

        Button buttonYes = (Button)findViewById(R.id.buttonYes);
        Button buttonNo = (Button)findViewById(R.id.buttonNo);
        TextView vopros = (TextView) findViewById(R.id.textView);
        buttonNo.setVisibility(View.INVISIBLE);
        buttonYes.setVisibility(View.INVISIBLE);
        vopros.setVisibility(View.INVISIBLE);

        List<String> fc_name = new ArrayList<>();
        fc_name.add("Парі Сен-Жермен");
        fc_name.add("Манчестер Юнайтед");
        fc_name.add("Боруссія Дортмунд");
        fc_name.add("Челсі");
        fc_name.add("Ліверпуль");
        fc_name.add("Манчестер Сіті");
        fc_name.add("Ювентус");
        fc_name.add("Барселона");

        Button startButton = (Button) findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            int currentimage = 0;
            @Override
            public void onClick(View view) {
                Button buttonYes = (Button)findViewById(R.id.buttonYes);
                Button buttonNo = (Button)findViewById(R.id.buttonNo);
                TextView vopros = (TextView) findViewById(R.id.textView);
                TextView fcname  =(TextView) findViewById(R.id.fcname);
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                startButton.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.VISIBLE);
                buttonYes.setVisibility(View.VISIBLE);
                vopros.setVisibility(View.VISIBLE);
                TextView answers  =(TextView) findViewById(R.id.textView2);

                vopros.setText("Чи відповідає назва клубу логотипу?");
                TextView timerText = (TextView) findViewById(R.id.textView4);


                final int[] answer = {0,0};
                Random random = new Random();
                currentimage = fc.get(random.nextInt(fc.size()));
                imageView.setImageDrawable(getDrawable(currentimage));
                fcname.setText(fc_name.get(random.nextInt(fc_name.size())));

                CountDownTimer countDownTimer = new CountDownTimer(5 * 1000, 1000) {
                    @Override
                    public void onTick(long millis) {
                        timerText.setText("seconds :" + (int)(millis / 1000));
                    }

                    @Override
                    public void onFinish() {
                        startButton.setVisibility(View.VISIBLE);
                        timerText.setVisibility(View.INVISIBLE);
                        vopros.setText("Правильних відповідей - " + answer[0] + "\n" +
                                "Неправильних відповідей - " + answer[1]);
                        buttonYes.setVisibility(View.INVISIBLE);
                        buttonNo.setVisibility(View.INVISIBLE);
                        Intent intent1 = new Intent(MainActivity.this, Result.class);
                        intent1.putExtra("true",String.valueOf(answer[0]));
                        intent1.putExtra("false",String.valueOf(answer[1]));
                        intent1.putExtra("nickname",nickname);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                    }
                }.start();

/*
                int currentimage = fc.get(7);
                imageView.setImageDrawable(getDrawable(currentimage));
                fcname.setText(fc_name.get(0));
                System.out.println(currentimage);
*/


buttonYes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        switch (currentimage){
            case 2131165331:
                if(fcname.getText().toString().equals(fc_name.get(0)))
                    answer[0]++;
                else answer[1]++;
                break;

            case 2131165317:
                if(fcname.getText().toString().equals(fc_name.get(1)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165272:
                if(fcname.getText().toString().equals(fc_name.get(2)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165281:
                if(fcname.getText().toString().equals(fc_name.get(3)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165295:
                if(fcname.getText().toString().equals(fc_name.get(4)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165296:
                if(fcname.getText().toString().equals(fc_name.get(5)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165336:
                if(fcname.getText().toString().equals(fc_name.get(6)))
                    answer[0]++;
                else answer[1]++;
                break;
            case 2131165335:
                if(fcname.getText().toString().equals(fc_name.get(7)))
                    answer[0]++;
                else answer[1]++;
                break;
        }
        answers.setText("Правильно:"+answer[0]+"Не правильно:"+answer[1]);
        currentimage = fc.get(random.nextInt(fc.size()));
        imageView.setImageDrawable(getDrawable(currentimage));
        fcname.setText(fc_name.get(random.nextInt(fc_name.size())));
    }
});

                buttonNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (currentimage){
                            case 2131165331:
                                if(fcname.getText().toString().equals(fc_name.get(0)))
                                    answer[1]++;
                                else answer[0]++;
                                break;

                            case 2131165317:
                                if(fcname.getText().toString().equals(fc_name.get(1)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165272:
                                if(fcname.getText().toString().equals(fc_name.get(2)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165281:
                                if(fcname.getText().toString().equals(fc_name.get(3)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165295:
                                if(fcname.getText().toString().equals(fc_name.get(4)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165296:
                                if(fcname.getText().toString().equals(fc_name.get(5)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165336:
                                if(fcname.getText().toString().equals(fc_name.get(6)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                            case 2131165335:
                                if(fcname.getText().toString().equals(fc_name.get(7)))
                                    answer[1]++;
                                else answer[0]++;
                                break;
                        }
                        currentimage = fc.get(random.nextInt(fc.size()));
                        imageView.setImageDrawable(getDrawable(currentimage));
                        fcname.setText(fc_name.get(random.nextInt(fc_name.size())));
                        answers.setText("Правильно:"+answer[0]+"Не правильно:"+answer[1]);
                    }
                });
            }
        });
    }

}