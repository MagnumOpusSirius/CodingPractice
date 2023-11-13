package com.demo.streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Set2 {
    public static void printRandom(){
        Random r= new Random();
        r.ints(5,1,11)
                .forEach(System.out::println);
    }
    public static void printRandomInSortedOrder(){
        Random r= new Random();
        r.ints(5,1,11)
                .sorted().forEach(System.out::println);
    }
    //get sum of all numbers present in the list:
    public static void getSumofAll() {
        List<Integer> result= Arrays.asList(1,2,3,4,5);
        Integer sum = result.stream()
                .mapToInt(x->x)
                .sum();
        System.out.println(sum);
    }
    //square the list of numbers and then filter out the numbers greater than 10
    //and then find the avg of filtered numbers:
    public static void operation1() {
        List<Integer> result= Arrays.asList(1,2,3,4,5);

        Double avg= result.stream()
                .mapToInt(e->e*e)
                .filter(e->e>10)
                .average().getAsDouble();
        System.out.println(avg);
    }
    //find the lowest and highest of a list
    public static void operation2() {
        List<Integer> result= Arrays.asList(1,2,3,4,5);
        Optional<Integer> my= result.stream().max((x, y)->x.compareTo(y));
        Integer my1=result.stream().mapToInt(e->e).min().getAsInt();

        System.out.println(my.get());
        System.out.println(my1);
    }
    //find the number of strings in a list whose length is greater than 4.
    public static void operation3() {
        List<String> list= Arrays.asList("abcd", "ac", "abcscs", "asd", "asdasfafa");
        System.out.println((Long) list.stream()
                .filter(str -> str.length() > 4).count());

    }
    //concatenate two streams;
    public static void operation4() {
        List<Integer> arr1= Arrays.asList(1,2,3,4,5);
        List<Integer> arr2= Arrays.asList(6,7,9,10);

        Stream<Integer> stream= Stream.concat(arr1.stream(), arr2.stream());
        System.out.println(stream.collect(Collectors.toList()));
    }
    //remove duplicate elements from the list:
    public static void operation5() {
        List<Integer> arr1= Arrays.asList(1,2,3,4,5,5,3,2,11);
        System.out.println(arr1.stream().distinct().collect(Collectors.toList()));
    }
    //find all even and odd numbers in the list:
    public static void operation6() {
        List<Integer> arr1= Arrays.asList(1,2,3,4,5,5,3,2,11);
        System.out.println(arr1.stream().filter(x->x%2==0).collect(Collectors.toList()));
        System.out.println(arr1.stream().filter(x->x%2!=0).collect(Collectors.toList()));
    }
    //find the duplicate elements:
    public static void operation7() {
        List<Integer> arr1= Arrays.asList(1,2,3,4,5,5,3,2,11);
        Set<Integer> set= new HashSet<>();
        System.out.println(arr1.stream().filter(x->!set.add(x)).sorted().collect(Collectors.toList()));
    }
    public static void main(String[] args) {
        operation7();
    }
}
