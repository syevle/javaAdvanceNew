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

/*
public class CsvReaderTest {

    @Test
    public void readsHeader() {
        CsvReader csvReader = createCsvReader();
        List<String> header = csvReader.readHeader();
        assertThat(header)
                .contains("username")
                .contains("visited")
                .hasSize(2);
    }

    @Test
    public void readsRecords() {
        CsvReader csvReader = createCsvReader();
        List<List<String>> records = csvReader.readRecords();
        assertThat(records)
                .contains(Arrays.asList("jdoe", "10"))
                .contains(Arrays.asList("kolorobot", "4"))
                .hasSize(2);
    }

    private CsvReader createCsvReader() {
        try {
            Path path = Paths.get("src/test/resources", "sample.csv");
            Reader reader = Files.newBufferedReader(
                path, Charset.forName("UTF-8"));
            return new CsvReader(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
 */
