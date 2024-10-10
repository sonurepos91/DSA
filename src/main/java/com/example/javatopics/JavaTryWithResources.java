package com.example.javatopics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaTryWithResources {

    public static void main (String[] args) {
        try (FileOutputStream fos = new FileOutputStream("C://Users//SinhaSonu//Downloads//demo.txt")) {
            String text = "This is a java program";

            byte arr[] = text.getBytes();
            fos.write(arr);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
