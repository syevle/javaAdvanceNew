package javaPractice.java8.venkat.m04_collectionsMapExample;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Sample1 {
    public static void main(String[] args) {
        Map<String, String> names = new LinkedHashMap<>();
        names.put("John", "Doe");
        names.put("Fred", "Flintstone");
        names.put("Jane", "Doe");

        Optional<String> firstKey = names.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), "Doe"))
                .map(Map.Entry::getKey).findFirst();

        if (firstKey.isPresent()) {
            System.out.println(firstKey.get());
        }
    }
}