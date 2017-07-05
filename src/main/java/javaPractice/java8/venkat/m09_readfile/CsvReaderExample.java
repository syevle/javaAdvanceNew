package javaPractice.java8.venkat.m09_readfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Santosh on 7/5/17.
 */
public class CsvReaderExample {
    static String csvFile = "/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/csvData.csv";


    public static void main(String[] args) throws FileNotFoundException {
        CsvReader csvReaderObj = new CsvReader(new FileReader(csvFile));

//        System.out.println(csvReaderObj.readHeader());
        System.out.println(csvReaderObj.readRecords());
    }
}
