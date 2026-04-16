// Practical Assignment – Collection – count of elements

// Write a method that takes an array of elements as input and 
// returns a Map where the keys are the elements themselves, and the values represent how many times each element occurs.

package java_collection;

import java.util.HashMap;
import java.util.Map;


public class CountOfElements {

    public static Map<Integer, Integer> countElementFreq(Integer[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {

        Integer[] nums = { 1, 4, 5, 7, 78, 5, 4, 2, 1 };

        System.out.println(countElementFreq(nums));
    }
}