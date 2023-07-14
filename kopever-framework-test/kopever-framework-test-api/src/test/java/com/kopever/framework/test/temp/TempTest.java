package com.kopever.framework.test.temp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TempTest {

    @Test
    public void testRemoveDuplicates() {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 7};
        int[] arr1 = {1, 1, 1, 2, 2, 3, 3, 3, 7};
        Assert.assertEquals(7, removeDuplicates(arr));
        Assert.assertEquals(7, removeDuplicates1(arr1));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;

        return i;
    }

    public int removeDuplicates1(int[] nums) {
        //
        // Initialize the counter and the second pointer.
        //
        int j = 1, count = 1;

        //
        // Start from the second element of the array and process
        // elements one by one.
        //
        for (int i = 1; i < nums.length; i++) {
            //
            // If the current element is a duplicate, increment the count.
            //
            if (nums[i] == nums[i - 1]) {

                count++;

            } else {
                //
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }

            //
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            //
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }

}
