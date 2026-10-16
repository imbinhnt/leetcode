// Leetcode 0002 | Medium | Fri Oct 16 2026
class ListNode {
    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.value = val;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }

        return dummy.next;
    }
}