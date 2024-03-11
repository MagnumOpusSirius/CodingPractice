package com.demo.paychex;

import java.util.*;

public class Set1 {

    //Two Sum:
    static int[] twoSum(int target, int[] arr){
        Map<Integer, Integer> map= new HashMap<>();

        for(int i =0; i< arr.length; i++){
            int difference= target-arr[i];
            if(map.containsKey(difference)){
                return new int[] {map.get(difference),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
    //Valid Parentheses:
    static boolean isValid(String s){
        Stack<Character> stack= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    //Given a list of int and target val, return all list pair that add up to the target
    //{1,2,3,4,5,6} and target = 10;
    //
    static List<List<Integer>> findPair(int[] arr, int target){
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(arr);
        int left=0;
        int right= arr.length-1;

        while(left<right){
            int sum= arr[left]+ arr[right];
            if(sum==target){
                //found a pair:
                List<Integer> pair= new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                result.add(pair);

                //move both pointer:
                left++;
                right--;

            }else if (sum<target){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

    //find all possible sublist that add up to target (reusable combination sum):
    //{1,2,3,4,5,6} and target = 10;
    //1 gets added
    //arr, target=9, 0, [1,], result

    static List<List<Integer>> findAllSublist(int[] arr, int target){
        List<List<Integer>> result= new ArrayList<>();
        sublistHelper(arr, target, 0, new ArrayList<>(), result);
        return result;
    }
    static void sublistHelper(int[] arr, int target, int index, List<Integer> currList, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int i=index; i< arr.length; i++){
            int currNum= arr[i];
            if(currNum<=target){
                //include currNum in sublist
                currList.add(currNum);
                //recursive:
                sublistHelper(arr,target-currNum, i, currList, result);
                //backtrack:
                currList.remove(currList.size()-1);
            }
        }
    }

    //non-reusable combination sum:
    static List<List<Integer>> findAllSublistNotDuplicate(int[] arr, int target){
        List<List<Integer>> result= new ArrayList<>();
        sublistHelperNotDuplicate(arr, target, 0, new ArrayList<>(), result);
        return result;
    }
    static void sublistHelperNotDuplicate(int[] arr, int target, int index, List<Integer> currList, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int i=index; i< arr.length; i++){
            int currNum= arr[i];
            if(currNum<=target){
                if(i>index && arr[i]==arr[i-1])continue;
                //include currNum in sublist
                currList.add(currNum);
                //recursive:
                sublistHelper(arr,target-currNum, i+1, currList, result);
                //backtrack:
                currList.remove(currList.size()-1);
            }
        }
    }

    //find all permutation of array:
    static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> list= new ArrayList<>();
        backtrack(list, new ArrayList<>(), arr);
        return list;
    }

    static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] arr){
        if(temp.size()==arr.length){
            list.add(new ArrayList<>(temp));
        }
        for(int i =0; i< arr.length; i++){
            if(temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            backtrack(list,temp, arr);
            temp.remove(temp.size()-1);
        }
    }

    //find all subsets of an array:
    static List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(arr);
        backtrackSubset(list, new ArrayList<>(), arr, 0);
        return list;
    }
    static void backtrackSubset(List<List<Integer>> list, List<Integer> temp, int[] arr, int start){
        list.add(new ArrayList<>(temp));
        for(int i =start; i< arr.length; i++){
            temp.add(arr[i]);
            backtrackSubset(list,temp,arr,i+1);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] arr ={10,2,5};
        int target = 8;

        System.out.println(permute(arr));
    }
}
