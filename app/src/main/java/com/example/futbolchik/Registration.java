package com.example.futbolchik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Registration extends AppCompatActivity {

    private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }


    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void click(View view) {
        EditText editmail = findViewById(R.id.email);
        EditText editname = findViewById(R.id.nickname);

        String nickname = editname.getText().toString();
        String email = editmail.getText().toString();


        try {
            validationNickname(nickname);
            validationEmail(email);
        }
        catch (NicknameException ex){
            editname.setError(ex.getMessage());
            return;
        }
        catch (EmailException ex)
        {
            editmail.setError(ex.getMessage());
            return;
        }


        Registration(email,nickname);

    }

    private void Registration(String email, String nickname){
        Intent intent = new Intent(Registration.this, MainActivity.class);
        intent.putExtra("nickname", nickname);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    private void validationEmail(String email) throws EmailException {
        if (email.isEmpty()) throw new EmailException("заповніть поле");
        if (email.trim().matches(emailPattern) == false) throw new EmailException("заповнено невірно");
    }
    private void validationNickname(String nickname) throws NicknameException {
        if (TextUtils.isEmpty(nickname)) throw new NicknameException("Пусто");
        return;
    }
}