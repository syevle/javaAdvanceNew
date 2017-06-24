package javaPractice.java8.venkat.m09_readfile;

/**
 * Created by Santosh on 6/24/17.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitWordCount {
    public static void main(String[] args) {
        List<String> terms = Arrays.asList(
                "Coding is great",
                "Search Engine are great",
                "Google is a nice search engine",
                "Bing is also a nice engine");

        Stream<String> stream = null;
        try {
            stream = Files.readAllLines(Paths.get("/Users/Santosh/java8/master/javaAdvanceNew/src/main/java/javaPractice/java8/venkat/m09_readfile/data1.txt")).parallelStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TopOccurrence topOccurrence = new TopOccurrence(4);
        assert stream != null;
        stream //Utilizes multi-core hardware
                .flatMap(s -> Arrays.asList(s.split(" ")).stream())
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum)) // Big O(n)
                .forEach((s, integer) -> topOccurrence.add(new WordCount(s, integer)));
        System.out.println(topOccurrence);
    }
    static class TopOccurrence {
        private final PriorityQueue<WordCount> minHeap;
        private final int maxSize;
        public TopOccurrence(int maxSize) {
            this.maxSize = maxSize;
            this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt(wc -> wc.count));
// This constructs a min heap (when order of elements is natural i.e. ascending order).
// We are using Natural order for integers (wc.count)
// In order to create a max-heap, we just need to provide reversed comparator i.e. that sorts in descending order,as shown below
// this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt((WordCount wc) -> wc.count).reversed());
        }
        public void add(WordCount data) {
            if (minHeap.size() < maxSize) { // size() is Big O(1)
                minHeap.offer(data); // Big O(log(k)) where k is the number of top occurrences required
            } else if (minHeap.peek().count < data.count) { // peek() is Big O(1)
                minHeap.poll(); // Big O(log(k))
                minHeap.offer(data); // Big O(log(k))
            }
        }
        @Override
        public String toString() {
            return "TopOccurrence{" + "minHeap=" + minHeap + ", maxSize=" + maxSize + '}';
        }
    }
    static class WordCount {
        protected final String word;
        protected final int count;
        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
        @Override
        public String toString() {
            return "{" + "word='" + word + '\'' + ", count=" + count + '}'+"\r\n";
        }
    }
}
