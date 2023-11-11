package com.demo.streamAPI;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

/*
All stream API methods:
- filter(): returns a stream of elements that match the given predicate
- map(): returns a stream of results after applying given function to elements of stream
- flatMap(): applies transformation over a nested collection of streams.
- forEach(): performs an action for each element of the stream like a for loop
- collect(): collects results of element stream using Collector
- sorted(): returns a stream of elements sorted.
- distinct(): returns a stream of distinct elements
- count(): returns the count of elements in the stream
- toArray(): returns an array containing the elements of stream
 */

public class Set1 {
    /*
    Question 1: given a list of int, find all even numbers that exist in the list using stream
    */
    public static void evenNumber(List<Integer> list){
        //collect, num%2==0
        list=list.stream()
                .filter(num-> num%2==0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }
    /*
    Question 2: given a list of int find out all numbers starting with 1 using stream
     */
    public static void startingWith(List<Integer> myList){
        List<Integer> result = myList.stream()
                .map(x->x+"")//convert int to string
                .filter(x-> x.startsWith("1"))//anything that starts with 1
                .map(Integer::parseInt)//convert string to int
                .collect(Collectors.toList());
        System.out.println(result);
    }
    /*
    Question 3: find duplicate elements in given integer list using stream.
     */
    public static void duplicateElements(List<Integer> myList){
        Set<Integer> newSet = new HashSet<>();
        List<Integer> result = myList.stream()
                .filter(x-> !newSet.add(x))
                .collect(Collectors.toList());
        System.out.println(result);
    }
    /*
    Question 4: given list of integers, find the first element of list using stream
     */
    public static void findFirstElement(List<Integer> myList){
        Optional<Integer> result = myList.stream()
                .findFirst();
        result.ifPresent(x-> System.out.println(x));
    }
    /*
    Question 5: given list of integers, find the total number of elements in the list
     */
    public static void findTotalElementPresent(List<Integer> myList){
        Long result= myList.stream()
                .count();
        System.out.println(result);
    }
    /*
    Question 6: given list of integers, find the max element
     */
    public static void findMax(List<Integer> myList){
        Integer result = myList.stream()
                .max((x,y)->x.compareTo(y)).get();
        System.out.println(result);
    }
    /*
    Question 7: given string, find first non-repeated character
     */
    public static void findFirstNonRepeatedCharacter(String str){
        Optional<Character> result = str.chars()//stream of strings
                .mapToObj(x-> (char)x)
                .distinct()
                .filter(ch->str.chars().filter(c-> c == ch).count() ==1)
                .findFirst();
        result.ifPresent(x-> System.out.println(x));
    }
    /*
    Question 8: given String, find first repeated character in stream
     */
    public static void findFirstRepeatedCharacter(String str){
        Optional<Character> result = str.chars()
                .mapToObj(c-> (char)c)
                .filter(ch->str.chars().filter(c->c==ch).count()>1)
                .findFirst();
        result.ifPresentOrElse(x-> System.out.println(x), ()-> System.out.println("not present"));
    }
    /*
    Question 9: given list of int, sort all values present
     */
    public static void sortList(List<Integer> list){
        List<Integer> result= list.stream()
                .sorted((x,y)-> x.compareTo(y))
                .collect(Collectors.toList());
        System.out.println(result);
    }
    /*
    Question 11:
    given integer array,
    return true if any value appears atleast twice (x>=2)
    and return false if every element is distinct
     */
    public static void containsDuplicates(int[] arr){
        //convert array to stream and
        boolean bool= Arrays.stream(arr)
                .distinct()
                .count() != arr.length;
        System.out.println(bool);
    }
    /*
    Question 12:
    Get the current date and time
     */
    public static void getDateAndTime(){
        System.out.println("Current local date: "+ java.time.LocalDate.now());
        System.out.println("Current local time: "+ java.time.LocalTime.now());
    }
    /*
    Question 13:
    Concat two streams
     */
    public static void concatenateStream(){
        List<String> list1= Arrays.asList("hello","world");
        List<String> list2= Arrays.asList("How", "are", "you");

        Stream<String> concatStream= Stream.concat(list1.stream(), list2.stream());
        String result = concatStream.collect(Collectors.joining(" "));
        System.out.println(result);
    }
    /*
    Question 14:
    perform cube on list elements and filter numbers greater than 50
     */
    public static void findCubeAndFilterList(List<Integer> list){
        List<Integer> result= list.stream()
                .map(x->x*x*x)
                .filter(x->x>50)
                .collect(Collectors.toList());
        System.out.println(result);
    }


    public static void main(String[] args) {
        List<Integer> myList= Arrays.asList(1,2,33,4,4,6,8,3,11,23);
        evenNumber(myList);
        startingWith(myList);
        duplicateElements(myList);
        findFirstElement(myList);
        findTotalElementPresent(myList);
        findMax(myList);
        sortList(myList);
        findCubeAndFilterList(myList);

        int[] arr= {1,2,3,4,5,5};
        containsDuplicates(arr);

        String str= "abnbccdd";
        findFirstNonRepeatedCharacter(str);
        findFirstRepeatedCharacter(str);

        getDateAndTime();
        concatenateStream();
    }
}
