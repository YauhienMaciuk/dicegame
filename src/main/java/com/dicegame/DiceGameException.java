package com.dicegame;

public class DiceGameException extends RuntimeException {

    public DiceGameException() {
    }

    public DiceGameException(String message) {
        super(message);
    }
}