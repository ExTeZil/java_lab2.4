package com.example.futbolchik;

import androidx.annotation.Nullable;

public class NicknameException extends Exception {

    public NicknameException(String message) {
        super(message);
    }

    @Nullable
    @Override
    public String getMessage() {
        return "Нікнейм - "+super.getMessage();
    }
}
