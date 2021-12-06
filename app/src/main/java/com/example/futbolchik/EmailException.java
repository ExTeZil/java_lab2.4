package com.example.futbolchik;

import androidx.annotation.Nullable;

public class EmailException extends Exception {

    public EmailException(String message) {
         super(message);
    }

    @Nullable
    @Override
    public String getMessage() {
        return "Електорнна пошта - "+super.getMessage();
    }
}
