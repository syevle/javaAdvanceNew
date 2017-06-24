package javaPractice.java8.venkat.m09_readfile;

/**
 * Created by Santosh on 6/24/17.
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

import static java.lang.Integer.compare;
import static java.lang.Integer.parseInt;

/**
 * Created by dphillips on 8/6/16.
 */
public class SimplParallelStreamWordCounteList {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\nParallel word count example using Old Testement King James bible");
        textWordCount("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data1.txt");
    }
    /**
     * Return the top 5 most frequently used words from the sample text.
     * @throws Exception
     */
    private static void textWordCount(String fileName) throws Exception {
        long start = Instant.now().toEpochMilli();
        ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();
        System.out.println("\tReading file: "+fileName);
        Path filePath = Paths.get(fileName);
        Files.readAllLines(filePath)
                .parallelStream()                               // Start streaming the lines
                .map(line -> line.split("\\s+"))                // Split line into individual words
                .flatMap(Arrays::stream)                        // Convert stream of String[] to stream of String
                .parallel()                                     // Convert to parallel stream
                .filter(w -> w.matches("\\w+"))                 // Filter out non-word items
                .map(String::toLowerCase)                       // Convert to lower case
                .forEach(word -> {                              // Use an AtomicAdder to tally word counts
                    if (!wordCounts.containsKey(word))          // If a hashmap entry for the word doesn't exist yet
                        wordCounts.put(word, new LongAdder());  // Create a new LongAdder
                    wordCounts.get(word).increment();           // Increment the LongAdder for each instance of a word
                });
        wordCounts
                .keySet()
                .stream()
                .map(key -> String.format("%-10d %s", wordCounts.get(key).intValue(), key))
                .sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
                .limit(5)
                .forEach(t -> System.out.println("\t"+t));
        long end = Instant.now().toEpochMilli();
        System.out.println(String.format("\tCompleted in %d milliseconds", (end-start)));
    }
}