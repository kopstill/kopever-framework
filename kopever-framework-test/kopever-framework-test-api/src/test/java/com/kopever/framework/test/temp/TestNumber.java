package com.kopever.framework.test.temp;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

public class TestNumber {

    @Test
    public void test() {
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;
        System.out.println(maxLong);
        System.out.println(minLong);
        System.out.println(maxLong + 1);
        System.out.println(maxLong + 1 == minLong);
        System.out.println(minLong - 1);
        System.out.println(minLong - 1 == maxLong);
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode result = addTwoNumbers(list1, list2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    @AllArgsConstructor
    @RequiredArgsConstructor
    private static class ListNode {
        private final int val;
        private ListNode next;

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
