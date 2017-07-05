package javaPractice.java8.venkat.m09_readfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Santosh on 7/5/17.
 */
public class CsvReader {

    private static final String SEPARATOR = ";";

    private final Reader source;

    CsvReader(Reader source) {
        this.source = source;
    }

    List<String> readHeader() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .findFirst()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .get();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

//    List<List<String>> readRecords() {
//        try (BufferedReader reader = new BufferedReader(source)) {
//            return reader.lines().skip(1)
//                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//    }

    List<List<String>> readRecords() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines().skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    Function<String, List<String>> mapper
            = line -> Arrays.asList(line.split(SEPARATOR));
}
