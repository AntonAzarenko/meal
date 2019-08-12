package com.azarenka;

import com.azarenka.util.KeyGenerator;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + ": " + KeyGenerator.generateUuid());
        }
    }
}
