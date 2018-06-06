package com.dsa;

import lombok.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
