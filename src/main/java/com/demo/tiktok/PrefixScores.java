package com.demo.tiktok;

import java.util.*;

public class PrefixScores {
    public static List<Integer> getPrefixScores(List<Integer> arr) {
        // Write your code here
        int getLength= arr.size();
        List<Integer> prefixArr= new ArrayList<>();
        List<Integer> newArr = new ArrayList<>();
        // int score=0;
        for(int i =0; i<getLength; i++ ){
            prefixArr.add(arr.get(i));
            // System.out.println("prefixArr= "+prefixArr);

            //cloned list
            List<Integer> updatedPrefixArr= new ArrayList<>(prefixArr);
            // System.out.println("updatedPrefixArr= "+updatedPrefixArr);
            //find the max of the current PrefixArr: int max
            int max = Integer.MIN_VALUE;
            for(int j=0; j<=i; j++){
                max = Math.max(max, arr.get(j));
            }
            // System.out.println("max= "+max);
            //then we add that max with the current position of the list (arr.get(i)) => prefixArr.forEach(item= -> item += max)
            // updatedPrefixArr.forEach(item -> item +=max);
            for (int j = 0; j <= i; j++) {
                updatedPrefixArr.set(j, updatedPrefixArr.get(j) + max);
                max = Math.max(max, updatedPrefixArr.get(j));
            }
            // System.out.println("updatedPrefixArr after max is added= "+updatedPrefixArr);

            //find the sum of this updatedPrefixArr
            int sum = updatedPrefixArr.stream().mapToInt(Integer::intValue).sum();
            //store that sum value in the newArr
            // System.out.println("sum = "+ sum);
            newArr.add(sum);
        }
        return newArr;
    }



    /*
    C++ code:
    vector<int> getPrefixScore (vector<int> arr) {
        vector<int> ans(arr.size());
        int mx=0; M= int(1e9)+7, sum=0, ssum=0;
        for(int i=0; i< arr.size(); i++){
            sum+=arr[i];
            sum%=M;
            ssum+=sum;
            ssum%=M;
            mx=max(mx,arr([i]);
            ans[i]=ssum+1LL*mx*(i+1)%M;
            ans[i]%=M;
        }
        return ans;
    }
     */

    private int number;

    public PrefixScores(int number){
        this.number= number;
    }

    //override hashcode and equals:
    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        PrefixScores prefixScores= (PrefixScores) obj;
        return number == prefixScores.number;
    }
    public static void main(String[] args) {
//        List<Integer> val= new ArrayList<>();
//        val.add(1);
//        val.add(2);
//        val.add(3);
//
//        List<Integer> prefixScores= getPrefixScores(val);
//        System.out.println(prefixScores);

        Set<PrefixScores> set= new HashSet<>();
        set.add(new PrefixScores(1));
        set.add(new PrefixScores(2));

        System.out.println(set.contains(new PrefixScores(1)));

    }
}
