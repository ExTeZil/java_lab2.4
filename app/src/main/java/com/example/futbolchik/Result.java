package com.example.futbolchik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String nickname = getIntent().getStringExtra("nickname");
        String email = getIntent().getStringExtra("email");
        String treu = getIntent().getStringExtra("true");
        String falce = getIntent().getStringExtra("false");

        System.out.println(nickname);
        System.out.println(treu);

        TextView tr = findViewById(R.id.textView2);
        tr.setText(treu);
        TextView fl = findViewById(R.id.textView4);
        fl.setText(falce);
    }


    public void click(View view) {
        String nickname = getIntent().getStringExtra("nickname").toString();
        String email = getIntent().getStringExtra("email").toString();
        String treu = getIntent().getStringExtra("true").toString();
        String falce = getIntent().getStringExtra("false").toString();

        Intent gemail = new Intent(Intent.ACTION_SEND);
        gemail.putExtra(Intent.EXTRA_EMAIL, new String[]{ email});
        gemail.putExtra(Intent.EXTRA_SUBJECT, "Результат: "+nickname);
        gemail.putExtra(Intent.EXTRA_TEXT, "Правильних відповідей - "+ treu +
                "\nНе правильних - " + falce);

        //need this to prompts email client only
        gemail.setType("message/rfc822");

        startActivity(Intent.createChooser(gemail, "Choose an Email client :"));
    }
}