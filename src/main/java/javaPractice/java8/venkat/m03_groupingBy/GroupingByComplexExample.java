package javaPractice.java8.venkat.m03_groupingBy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import java.util.stream.Collectors;

public class GroupingByComplexExample {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(groupingBy(Item::getPrice));
        System.out.println("1) ========================group by price========================");
        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        System.out.println("2) ========================group by price, uses 'mapping' to convert List<Item> to Set<String>========================");
        Map<BigDecimal, Set<String>> result =
                items.stream()
                        .collect(groupingBy(Item::getPrice, mapping(Item::getName, Collectors.toSet())));

        System.out.println(result);

        System.out.println("3) ========================group by price, uses 'mapping' to convert List<Item> to List<String>========================");
        Map<BigDecimal, List<String>> result1 =
                items.stream().collect(groupingBy(Item::getPrice, mapping(Item::getName, Collectors.toList())));

        System.out.println(result1);

    }
}