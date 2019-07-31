package javaPractice.thread.defogexample.largeFileProccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FileHandling {

    public static void main(String[] args) throws FileNotFoundException {

        File filePath = new File("c:/users/cc/temp/test.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        reader.lines().forEach(line -> {
            // process liness
            System.out.println(line);
        });
    }

}

